package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CentreRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import org.springframework.stereotype.Component;

@Component
public class CentreService extends AbstractCrudService<Centre, Long>
{
    public CentreService(CentreRepository repository) {
        super(repository);
    }
}
