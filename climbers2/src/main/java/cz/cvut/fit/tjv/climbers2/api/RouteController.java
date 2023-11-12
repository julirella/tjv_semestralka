package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.RouteService;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController extends AbstractCrudController<Route, Long>{
    public RouteController(RouteService service){
        super(service);
    }

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "centre does not exist")
    @ApiResponse(responseCode = "500", description = "entity already exists")
    @PostMapping
    @Override
    public Route create(Route body) {
        return super.create(body);
    }
}
