package cz.cvut.fit.tjv.climbers2.dao;

import cz.cvut.fit.tjv.climbers2.domain.Climber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {
    boolean existsByIdAndRoutes_Id(Long climberId, Long routeId);
}
