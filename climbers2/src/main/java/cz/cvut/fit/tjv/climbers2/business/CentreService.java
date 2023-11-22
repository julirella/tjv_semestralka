package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CentreRepository;
import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import cz.cvut.fit.tjv.climbers2.exceptions.IdDoesNotExistException;
import org.springframework.stereotype.Component;

@Component
public class CentreService extends AbstractCrudService<Centre, Long>
{
    private final CentreRepository centreRepository;
    private final RouteRepository routeRepository;
    private final RouteService routeService;
    public CentreService(CentreRepository repository, CentreRepository centreRepository, RouteRepository routeRepository, RouteService routeService) {
        super(repository);
        this.centreRepository = centreRepository;
        this.routeRepository = routeRepository;
        this.routeService = routeService;
    }

    @Override
    public void deleteById(Long centreId) {
        if(!centreRepository.existsById(centreId)) throw new IdDoesNotExistException("Centre with id " + centreId + "  doesn't exist.");
        //find all routes in centre
        Iterable<Route> routes = routeRepository.findRoutesByCentre_Id(centreId);
        //delete those routes, which will delete all route-climber connections for those routes
        for(Route route : routes){
            routeService.deleteById(route.getId());
        }
        //delete centre
        centreRepository.deleteById(centreId);
    }
}
