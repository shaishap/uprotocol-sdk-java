/*
 * Copyright (c) 2023 General Motors GTO LLC
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.eclipse.uprotocol.cloudevent.serialize;

import io.cloudevents.CloudEvent;
import io.cloudevents.jackson.JsonFormat;

/**
 * CloudEventSerializer to serialize and deserialize CloudEvents to JSON format.
 */
public class CloudEventToJsonSerializer implements CloudEventSerializer {

    // Force database64 encoding as we know the data will be in a protobuf format
    private static final JsonFormat serializer = new JsonFormat(true, false);

    public byte[] serialize(CloudEvent cloudEvent) {
        return serializer.serialize(cloudEvent);
    }

    @Override
    public CloudEvent deserialize(byte[] bytes) {
        return serializer.deserialize(bytes);
    }

}
