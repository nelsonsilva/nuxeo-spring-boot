/*
 * (C) Copyright 2006-2018 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     matic
 */
package org.nuxeo.sdk.dto;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedInfo {

    private Long id;

    @Transient
    public Serializable getSerializableValue() {
        throw new UnsupportedOperationException();
    }

    public <T> T getValue(Class<T> clazz) {
        return clazz.cast(this.getSerializableValue());
    }

    @Value
    public static class LongInfo extends ExtendedInfo {

        long longValue;

        @Override
        @Transient
        public Serializable getSerializableValue() {
            return longValue;
        }

    }

    @Value
    public static class DateInfo extends ExtendedInfo {

        Date dateValue;

        @Override
        @Transient
        public Serializable getSerializableValue() {
            return dateValue;
        }

    }

    @Value
    public static class StringInfo extends ExtendedInfo {

        String stringValue;

        @Override
        @Transient
        public Serializable getSerializableValue() {
            return stringValue;
        }

    }

    @Value
    public static class DoubleInfo extends ExtendedInfo {

        Double doubleValue;

        @Override
        @Transient
        public Serializable getSerializableValue() {
            return doubleValue;
        }

    }

    @Value
    public static class BooleanInfo extends ExtendedInfo {

        Boolean booleanValue;

        @Override
        @Transient
        public Serializable getSerializableValue() {
            return booleanValue;
        }

    }

    @Value
    public static class BlobInfo extends ExtendedInfo {

        Serializable blobValue;

        @Override
        @Transient
        public Serializable getSerializableValue() {
            return blobValue;
        }

    }

}
