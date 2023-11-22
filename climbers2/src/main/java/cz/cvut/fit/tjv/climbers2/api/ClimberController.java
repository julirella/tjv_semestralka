package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.ClimberService;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/climber")
public class ClimberController extends AbstractCrudController<Climber, Long>{
    private final ClimberService service;
    public ClimberController(ClimberService service){
        super(service);
        this.service = service;
    }

    @Operation(description = "Add a route to climbers list of climbed routes.")
    @Parameter(name = "climberId", description = "id of the climber")
    @Parameter(name = "routeId", description = "id of the route")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "ID does not exist")
    @ApiResponse(responseCode = "400", description = "climber has already climbed this route")
    @PostMapping("/{climberId}/addRoute/{routeId}")
    public Climber addRoute(@PathVariable Long climberId, @PathVariable Long routeId){
        return service.addRoute(climberId, routeId);
    }


    @Operation(description = "Delete a route from climbers list of climbed routes.")
    @Parameter(name = "climberId", description = "id of the climber")
    @Parameter(name = "routeId", description = "id of the route")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "ID does not exist")
    @DeleteMapping("/{climberId}/deleteRoute/{routeId}")
    public Climber deleteRoute(@PathVariable Long climberId, @PathVariable Long routeId){
        return service.deleteRoute(climberId, routeId);
    }

    @Operation(description = "Recommend routes that the climber hasn't climbed yet and are within their strength range and budget.")
    @Parameter(name = "id", description = "Id of the climber")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "ID does not exist")
    @GetMapping("/recommendRoutes/{id}")
    public Iterable<Route> recommendRoutes(@PathVariable Long id){
        return service.recommendRoutes(id);
    }
}
