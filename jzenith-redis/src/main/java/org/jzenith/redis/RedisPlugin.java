/**
 * Copyright © 2018 Marcus Thiesen (marcus@thiesen.org)
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
 */
package org.jzenith.redis;

import com.google.common.collect.ImmutableList;
import com.google.inject.Injector;
import com.google.inject.Module;
import lombok.extern.slf4j.Slf4j;
import org.jzenith.core.AbstractPlugin;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class RedisPlugin extends AbstractPlugin {

    private RedisPlugin() {
    }

    public static RedisPlugin create() {
        return new RedisPlugin();
    }

    @Override
    protected List<Module> getModules() {
        return ImmutableList.of(new RedisBinder());
    }

    @Override
    protected CompletableFuture<String> start(Injector injector) {
        if (log.isDebugEnabled()) {
            log.debug("jZenith Redis is starting");
        }

        return CompletableFuture.completedFuture("Done");
    }


}
