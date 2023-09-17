package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.stereotype.Component;


@Component
public class RouteService extends AbstractCrudService<Route, Long>
{
    public RouteService(RouteRepository repository) {
        super(repository);
    }
}
