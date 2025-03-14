/*
 * Copyright 2024 Aklivity Inc
 *
 * Licensed under the Aklivity Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 *   https://www.aklivity.io/aklivity-community-license/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.aklivity.zillabase.service.api.gen.internal.model;

public enum ApiGenEventType
{
    CATALOG_UPDATED,
    KAFKA_ASYNC_API_PUBLISHED,
    KAFKA_ASYNC_API_ERRORED,
    HTTP_ASYNC_API_PUBLISHED,
    HTTP_ASYNC_API_ERRORED,
    ZILLA_CONFIG_ERRORED,
    ZILLA_CONFIG_PUBLISHED;
}
