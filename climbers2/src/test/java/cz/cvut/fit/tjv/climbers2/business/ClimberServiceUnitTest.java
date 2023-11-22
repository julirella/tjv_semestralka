package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.ClimberRepository;
import cz.cvut.fit.tjv.climbers2.dao.RouteRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class ClimberServiceUnitTest {

    @Autowired
    ClimberService climberService;

    @MockBean
    ClimberRepository climberRepository;

    @MockBean
    RouteRepository routeRepository;

    @Test
    void shouldAddRouteToClimber(){
        Climber climber = new Climber(1L, "Test", "Climber", 5, 300);
        Route route = new Route(2L, "TestRoute", 4, new Centre(3L, "TestCentre", 200));

        Mockito.when(climberRepository.findById(1L)).thenReturn(Optional.of(climber));
        Mockito.when(routeRepository.findById(2L)).thenReturn(Optional.of(route));
        Mockito.when(climberRepository.existsByIdAndRoutes_Id(1L,2L)).thenReturn(false);

        climberService.addRoute(1L, 2L);

        Assertions.assertTrue(climber.getRoutes().contains(route));
    }
}
