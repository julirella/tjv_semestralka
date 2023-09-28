package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class ClimberService extends AbstractCrudService<Climber, Long>{
    private final ClimberRepository climberRepository;
    private final RouteRepository routeRepository;
    public ClimberService(ClimberRepository climberRepository, RouteRepository routeRepository) {

        super(climberRepository);
        this.climberRepository = climberRepository;
        this.routeRepository = routeRepository;
    }

    public Climber addRoute(Long climberId, Long routeId){
        Optional<Climber> climber = climberRepository.findById(climberId);
        Optional<Route> route = routeRepository.findById(routeId);
        if(climberRepository.existsByIdAndRoutes_Id(climberId, routeId)) throw new EntityExistsException("route already added"); //find better exception
        if(climber.isEmpty() || route.isEmpty()) throw new EntityNotFoundException();
        climber.get().addRoute(route.get()); //maybe do this part in repository?
        return climberRepository.save(climber.get());
    }

    public Climber deleteRoute(Long climberId, Long routeId){
        Optional<Climber> climber = climberRepository.findById(climberId);
        Optional<Route> route = routeRepository.findById(routeId);
        if(climber.isEmpty() || route.isEmpty()) throw new EntityNotFoundException();
        climber.get().deleteRoute(route.get());
        return climberRepository.save(climber.get());
    }

//    public Iterable<Route> recommendRoutes(Long climberId){
//        /*
//        * check that climber exists
//        * select routes where centre price <= budget, route grade <= climber strength, climber hasn't climbed the route yet
//        * order by distance of climber from centre
//        * */
//    }
}
