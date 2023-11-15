package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CentreRepository;
import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
public class RouteRepositoryTest {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private ClimberRepository climberRepository;
    @Autowired
    private CentreRepository centreRepository;
    @Test
    void recommendRoutes(){
        Climber climber = new Climber("test", "climber", 7, 300);
        climberRepository.save(climber);

        Centre cheapCentre = new Centre("cheap", 200);
        Centre expensiveCentre = new Centre("expensive", 400);
        centreRepository.save(cheapCentre);
        centreRepository.save(expensiveCentre);

        Route easyRoute1 = new Route("a", 7, cheapCentre);
        Route easyRoute2 = new Route("b", 5, cheapCentre);
        Route easyRoute3 = new Route("c", 3, expensiveCentre);
        Route hardRoute1 = new Route("d", 8, cheapCentre);
        Route hardRoute2 = new Route("e", 10, cheapCentre);
        Route hardRoute3 = new Route("f", 9, expensiveCentre);
        routeRepository.saveAll(Arrays.asList(easyRoute1, easyRoute2, easyRoute3, hardRoute1, hardRoute2, hardRoute3));

        Iterable<Route> correctRoutes = List.of(easyRoute2, easyRoute1);
        Assertions.assertIterableEquals(routeRepository.recommendRoutesForClimber(climber.getId()), correctRoutes);
    }
}
