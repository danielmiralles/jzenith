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
package org.jzenith.core.guice;

import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.spi.BindingScopingVisitor;
import com.google.inject.spi.ProvisionListener;

import java.io.Closeable;
import java.lang.annotation.Annotation;

public class CloseableListener implements ProvisionListener {

    private final LifeCycleObjectRepository repo;

    public CloseableListener(LifeCycleObjectRepository repo) {
        this.repo = repo;
    }

    @Override
    public <T> void onProvision(ProvisionInvocation<T> provisionInvocation) {
        T provision = provisionInvocation.provision();

        if (shouldManage(provisionInvocation)) {
            if (provision instanceof Closeable) {
                repo.register(((Closeable) provision)::close);
            }
            if (provision instanceof AutoCloseable) {
                repo.register(((AutoCloseable) provision)::close);
            }
        }
    }

    private boolean shouldManage(ProvisionInvocation<?> provisionInvocation) {
        return provisionInvocation.getBinding().acceptScopingVisitor(new BindingScopingVisitor<>() {

            @Override
            public Boolean visitEagerSingleton() {
                return true;
            }

            @Override
            public Boolean visitScope(Scope scope) {
                return scope == Scopes.SINGLETON;
            }

            @Override
            public Boolean visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation) {
                return scopeAnnotation.isAssignableFrom(Singleton.class) || scopeAnnotation.isAssignableFrom(javax.inject.Singleton.class);
            }

            @Override
            public Boolean visitNoScoping() {
                return false;
            }

        });
    }
}
