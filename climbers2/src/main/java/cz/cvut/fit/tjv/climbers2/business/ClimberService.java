package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //bean, @component also works
public class ClimberService {

    private final ClimberRepository climberRepository;

    @Autowired
    public ClimberService(ClimberRepository climberRepository){
        this.climberRepository = climberRepository;
    }
    public List<Climber> getClimbers(){
        return climberRepository.findAll(); //returns list of climbers
    }
}
