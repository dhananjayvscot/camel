/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.spi;

import java.util.List;

import org.apache.camel.Consumer;
import org.apache.camel.Service;

/**
 * A registry of all REST services running within the {@link org.apache.camel.CamelContext} which have been defined and created
 * using the <a href="http://camel.apache.org/rest-dsl">Rest DSL</a>.
 */
public interface RestRegistry extends Service {

    /**
     * Details about the REST service
     */
    interface RestService {

        /**
         * Gets the consumer of the REST service
         */
        Consumer getConsumer();

        /**
         * Gets the state of the REST service (started, stopped, etc)
         */
        String getState();

        /**
         * Gets the absolute url to the REST service
         */
        String getUrl();

        /**
         * Gets the uri template (context path)
         */
        String getUriTemplate();

        /**
         * Gets the HTTP method (GET, POST, PUT etc)
         */
        String getMethod();

        /**
         * Optional details about what media-types the REST service accepts
         */
        String getConsumes();

        /**
         * Optional details about what media-types the REST service returns
         */
        String getProduces();

    }

    /**
     * Adds a new REST service to the registry.
     *
     * @param consumer    the consumer
     * @param url         the absolute url of the REST service
     * @param method      the HTTP method
     * @param uriTemplate the uri template (context-path)
     * @param consumes    optional details about what media-types the REST service accepts
     * @param produces    optional details about what media-types the REST service returns
     */
    void addRestService(Consumer consumer, String url, String method, String uriTemplate, String consumes, String produces);

    /**
     * Removes the REST service from the registry
     *
     * @param consumer  the consumer
     */
    void removeRestService(Consumer consumer);

    /**
     * List all REST services from this registry.
     *
     * @return all the REST services
     */
    List<RestService> listAllRestServices();

    /**
     * Number of rest services in the registry.
     *
     * @return number of rest services in the registry.
     */
    int size();

}
