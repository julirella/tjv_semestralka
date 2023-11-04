package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.ClimberService;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
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

    @PostMapping("/{climberId}/addRoute/{routeId}")
    public Climber addRoute(@PathVariable Long climberId, @PathVariable Long routeId){
        return service.addRoute(climberId, routeId);
    }

    @DeleteMapping("/{climberId}/deleteRoute/{routeId}")
    public Climber deleteRoute(@PathVariable Long climberId, @PathVariable Long routeId){
        return service.deleteRoute(climberId, routeId);
    }

    /**
     * For a given climber, recommends routes that the climber hasn't climbed yet, are within their strength range and budget,
     * ordered by centre price
     * */
    @Operation(description = "Recommend routes that the climber hasn't climbed yet and are within their strength range and budget.")
    @GetMapping("/recommendRoutes/{id}")
    public Iterable<Route> recommendRoutes(@PathVariable Long id){
        return service.recommendRoutes(id);
    }
}
