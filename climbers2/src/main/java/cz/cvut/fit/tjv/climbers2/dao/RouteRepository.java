package cz.cvut.fit.tjv.climbers2.dao;

import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepositoryImplementation<Route, Long> {
    void deleteRoutesByCentre_Id(Long id);
    Iterable<Route> findRoutesByCentre_Id(Long id);

    @Query(value = "select * from route where route.id not in (select routes_id from route_climber where route_climber.climber_id = :climberId);", nativeQuery = true)
    Iterable<Route> recommendRoutesForClimber(@Param("climberId") Long climberId);
}
