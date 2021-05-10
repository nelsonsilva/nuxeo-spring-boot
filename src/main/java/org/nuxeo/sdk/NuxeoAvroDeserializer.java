package org.nuxeo.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.nuxeo.lib.stream.codec.AvroMessageCodec;
import org.nuxeo.lib.stream.codec.Codec;
import org.nuxeo.lib.stream.codec.FileAvroSchemaStore;
import org.nuxeo.lib.stream.computation.Record;
import org.nuxeo.sdk.dto.LogEntry;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class NuxeoAvroDeserializer implements Deserializer<LogEntry> {

    private final Codec<Record> codec;

    public NuxeoAvroDeserializer(String schemaDirectory) {
        FileAvroSchemaStore schemaStore = new FileAvroSchemaStore(Path.of(schemaDirectory));
        codec = new AvroMessageCodec<>(Record.class, schemaStore);
    }

    @Override
    public LogEntry deserialize(String s, byte[] bytes) {
        LogEntry entry;
        try {
            Record record = codec.decode(bytes);
            String json = new String(record.getData(), UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            entry = mapper.readValue(json, LogEntry.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
        return entry;
    }
}
