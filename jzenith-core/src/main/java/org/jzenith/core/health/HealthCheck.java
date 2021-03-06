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
package org.jzenith.core.health;

import io.reactivex.Single;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class HealthCheck {


    public Single<HealthCheckResult> execute() {
        return executeInternal().timeout(getTimeout().toMillis(), TimeUnit.MILLISECONDS)
                .onErrorResumeNext(error -> Single.just(createResult(error)));
    }

    protected HealthCheckResult createResult(Throwable error) {
        return HealthCheckResult.create(error, getName());
    }

    protected HealthCheckResult createResult(boolean up) {
        return HealthCheckResult.create(up, getName());
    }

    protected abstract Single<HealthCheckResult> executeInternal();

    public String getName() {
        return getClass().getSimpleName();
    }

    public Duration getTimeout() {
        return Duration.ofSeconds(5);
    }

}
