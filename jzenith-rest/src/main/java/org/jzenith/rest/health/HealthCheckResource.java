package org.jzenith.rest.health;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.jzenith.core.health.HealthCheck;
import org.jzenith.core.health.HealthCheckResult;
import org.jzenith.core.health.HealthState;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/health")
public class HealthCheckResource {

    private final Set<HealthCheck> healthChecks;

    @Inject
    public HealthCheckResource(Set<HealthCheck> healthChecks) {
        this.healthChecks = healthChecks;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Single<Response> doHealthChecks() {
        return Observable.fromIterable(healthChecks)
                .flatMapSingle(healthCheck -> healthCheck.execute())
                .toList()
                .map(this::toResponse);
    }

    private Response toResponse(List<HealthCheckResult> healthCheckResults) {
        final boolean isDown = healthCheckResults.stream().anyMatch(HealthCheckResult::isDown);

        final HealthCheckResponse response = new HealthCheckResponse(isDown ? HealthState.DOWN : HealthState.UP, healthCheckResults);

        if (isDown) {
            return Response.status(500).entity(response).build();
        } else {
            return Response.status(200).entity(response).build();
        }
    }

}
