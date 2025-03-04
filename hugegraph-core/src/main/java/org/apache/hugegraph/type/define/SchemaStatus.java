/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hugegraph.type.define;

public enum SchemaStatus implements SerialEnum {

    CREATED(1, "created"),

    CREATING(2, "creating"),

    REBUILDING(3, "rebuilding"),

    DELETING(4, "deleting"),

    UNDELETED(5, "undeleted"),

    INVALID(6, "invalid");

    private byte code = 0;
    private String name = null;

    static {
        SerialEnum.register(SchemaStatus.class);
    }

    SchemaStatus(int code, String name) {
        assert code < 256;
        this.code = (byte) code;
        this.name = name;
    }

    public boolean ok() {
        return this == CREATED;
    }

    public boolean deleting() {
        return this == DELETING || this == UNDELETED;
    }

    @Override
    public byte code() {
        return this.code;
    }

    public String string() {
        return this.name;
    }
}
