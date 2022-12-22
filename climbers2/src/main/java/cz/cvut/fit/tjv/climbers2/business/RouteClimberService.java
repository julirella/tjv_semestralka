package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.jpa.CentreJpaRepository;
import cz.cvut.fit.tjv.climbers2.dao.jpa.RouteClimberJpaRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.domain.RouteClimber;
import org.springframework.stereotype.Component;


@Component
public class RouteClimberService extends AbstractCrudService<RouteClimber, Long>
{

    protected RouteClimberService(RouteClimberJpaRepository repository) {
        super(repository);
    }
}
