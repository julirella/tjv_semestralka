package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.RouteService;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController extends AbstractCrudController<Route, Long>{
    public RouteController(RouteService service){
        super(service);
    }
}
