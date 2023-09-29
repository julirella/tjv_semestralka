package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CentreRepository;
import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
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
    public Route create(Route route) throws BadRequestException{
        Centre centre = route.getCentre();
        if(!centreRepository.existsById(centre.getId())) throw new BadRequestException("Centre with id " + centre.getId() + "doesn't exist.");
        return super.create(route);
    }

    @Override
    public Route update(Route route){
        Centre centre = route.getCentre();
        if(!centreRepository.existsById(centre.getId())) throw new BadRequestException("Centre with id " + centre.getId() + "doesn't exist.");
        return super.update(route);
    }

    @Override
    public void deleteById(Long routeId){
        Optional<Route> route = routeRepository.findById(routeId);
        if(route.isEmpty()) throw new BadRequestException("Route with id " + routeId.toString() + " doesn't exist.");
        Iterable<Climber> climbers = climberRepository.findClimbersByRoutes_Id(routeId);
        //for each climber, check if it has route, if yes, delete the route
        for(Climber climber : climbers){
            climber.deleteRoute(route.get());
        }
        routeRepository.deleteById(routeId);
    }
}
