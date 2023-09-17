package cz.cvut.fit.tjv.climbers2.dao;

import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepositoryImplementation<Route, Long> {
}
