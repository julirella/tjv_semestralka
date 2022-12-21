package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.ClimberService;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/climber")
public class ClimberController {
    private final ClimberService climberService;

    @Autowired //dependency injection
    public ClimberController(ClimberService climberService) {
        this.climberService = climberService;
    }

    @GetMapping
    public List<Climber> getClimbers(){
        return climberService.getClimbers();
    }

    @PostMapping
    public Climber createClimber(@RequestBody Climber climber){
        return climberService.createClimber(climber);
    }

    @PutMapping("/{id}")
    public void updateClimber(@RequestBody Climber climber, @PathVariable Long id){
        climberService.updateClimber(climber, id);
    }
    @DeleteMapping("/{id}")
    public void deleteClimber(@PathVariable Long id){
        climberService.deleteById(id);
    }
}
