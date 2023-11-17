package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CentreRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import cz.cvut.fit.tjv.climbers2.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CentreServiceIntegrationTest {

    @Autowired
    CentreService centreService;

    @Autowired
    CentreRepository centreRepository;

    @Test
    void shouldCreateCentre(){
        Centre centre = new Centre("TestCentre", 200);
        centreService.create(centre);
        Assertions.assertTrue(centreRepository.existsById(centre.getId()));
    }

    @Test
    void shouldThrowException(){
        Centre centre = new Centre(1L, "TestCentre", 200);
        centreRepository.save(centre);
        Assertions.assertThrows(BadRequestException.class, () -> centreService.create(centre));
    }
}
