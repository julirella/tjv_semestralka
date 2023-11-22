package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CentreRepository;
import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import cz.cvut.fit.tjv.climbers2.exceptions.IdDoesNotExistException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class RouteService extends AbstractCrudService<Route, Long>
{
    CentreRepository centreRepository;
    ClimberRepository climberRepository;
    RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository, CentreRepository centreRepository, ClimberRepository climberRepository) {
        super(routeRepository);
        this.routeRepository = routeRepository;
        this.centreRepository = centreRepository;
        this.climberRepository = climberRepository;
    }

    @Override
    public Route create(Route route) {
        Centre centre = route.getCentre();
        if(!centreRepository.existsById(centre.getId())) throw new IdDoesNotExistException("Centre with id " + centre.getId() + "doesn't exist.");
        return super.create(route);
    }

    @Override
    public Route update(Route route){
        Centre centre = route.getCentre();
        if(!centreRepository.existsById(centre.getId())) throw new IdDoesNotExistException("Centre with id " + centre.getId() + "doesn't exist.");
        return super.update(route);
    }

    @Override
    public void deleteById(Long routeId){
        Optional<Route> route = routeRepository.findById(routeId);
        if(route.isEmpty()) throw new IdDoesNotExistException("Route with id " + routeId + " doesn't exist.");
        Iterable<Climber> climbers = climberRepository.findClimbersByRoutes_Id(routeId);
        //for each climber, check if it has route, if yes, delete the route
        for(Climber climber : climbers){
            climber.deleteRoute(route.get());
        }
        routeRepository.deleteById(routeId);
    }
}
