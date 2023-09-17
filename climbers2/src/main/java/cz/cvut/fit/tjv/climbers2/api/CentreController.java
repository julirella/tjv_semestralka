package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.api.model.CentreDto;
import cz.cvut.fit.tjv.climbers2.business.CentreService;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centre")
public class CentreController extends AbstractCrudController<Centre, CentreDto, Long>{
    public CentreController(CentreService service){
        super(service);
    }
}
