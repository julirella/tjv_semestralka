package cz.cvut.fit.tjv.climbers2.dao;

import cz.cvut.fit.tjv.climbers2.domain.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepositoryImplementation<Route, Long> {
    Iterable<Route> findRoutesByCentre_Id(Long id);

    @Query(value = """
            SELECT r FROM Route r
                where r not in (select cl.routes from Climber cl where cl.id = :climberId)
                and r.grade <= (select cl.strength from Climber cl where cl.id = :climberId)
                and (r.centre.price <= (select cl.budget from Climber cl where cl.id = :climberId))
                order by r.grade""")
    Iterable<Route> recommendRoutesForClimber(@Param("climberId") Long climberId);
}
