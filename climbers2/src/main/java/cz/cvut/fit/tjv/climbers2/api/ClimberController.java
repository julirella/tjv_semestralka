package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.api.model.ClimberDto;
import cz.cvut.fit.tjv.climbers2.business.ClimberService;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/climber")
public class ClimberController extends AbstractCrudController<Climber, ClimberDto, Long>{
    private final ClimberService service;
    public ClimberController(ClimberService service){
        super(
                service
//                ,entity -> {
//                    var dto = new ClimberDto();
//                    dto.setId(entity.getId());
//                    dto.setName(entity.getName());
//                    dto.setSurname(entity.getSurname());
//                    dto.setAddress(entity.getAddress());
//                    dto.setStrength(entity.getStrength());
//                    dto.setBudget(entity.getBudget());
//                    return dto;
//                },
//                dto -> {
//                    var entity = new Climber(dto.getId(), dto.getName(), dto.getSurname(), dto.getAddress(), dto.getStrength(), dto.getBudget());
//                    return entity;
//                }
        );
        this.service = service;
    }

    @PostMapping("/{climberId}/addRoute/{routeId}")
    public Climber addRoute(@PathVariable Long climberId, @PathVariable Long routeId){
        return service.addRoute(climberId, routeId);
    }
//
//    @GetMapping("/recommendRoutes/{id}")
//    public Iterable<Route> recommendRoutes(@PathVariable Long id){
//        return service.recommendRoutes(id);
//    }
}
