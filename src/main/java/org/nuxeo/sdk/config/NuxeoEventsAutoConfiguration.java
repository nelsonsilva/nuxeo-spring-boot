package org.nuxeo.sdk.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.nuxeo.sdk.NuxeoAvroDeserializer;
import org.nuxeo.sdk.event.EventChannels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableConfigurationProperties(NuxeoEventsProperties.class)
@AutoConfigureAfter({ IntegrationAutoConfiguration.class, KafkaAutoConfiguration.class })
public class NuxeoEventsAutoConfiguration {

    @Autowired
    private NuxeoEventsProperties properties;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public IntegrationFlow eventsListeningFlow(final ConsumerFactory<?, ?> consumerFactory) {
        return IntegrationFlows
                .from(Kafka.messageDrivenChannelAdapter(consumerFactory,
                        KafkaMessageDrivenChannelAdapter.ListenerMode.record, properties.getTopic())
                                .filterInRetry(true)
                                .errorChannel(errorChannel())
                )
                .channel(logChannel())
                .get();
    }

    @Bean(name = EventChannels.LOG)
    public PublishSubscribeChannel logChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean(name = EventChannels.ERROR)
    public DirectChannel errorChannel() {
        return new DirectChannel();
    }

    @Bean
    public ConsumerFactory<?, ?> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                this.kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                new NuxeoAvroDeserializer(properties.getSchemaDirectory()));
    }
}

