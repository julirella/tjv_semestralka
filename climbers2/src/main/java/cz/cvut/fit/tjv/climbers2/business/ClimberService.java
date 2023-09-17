package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import org.springframework.stereotype.Component;

@Component
public class ClimberService extends AbstractCrudService<Climber, Long>{
    public ClimberService(ClimberRepository climberRepository) {
        super(climberRepository);
    }
}
