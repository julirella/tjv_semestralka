package cz.cvut.fit.tjv.climbers2.dao.jpa;

import cz.cvut.fit.tjv.climbers2.dao.CrudRepository;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface RouteJpaRepository extends JpaRepository<Route, Long>, CrudRepository<Route, Long> {
}
