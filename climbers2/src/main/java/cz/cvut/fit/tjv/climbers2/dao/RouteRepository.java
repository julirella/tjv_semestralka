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

    //can this be made more efficient?
//    @Query(value = """
//            select * from route r
//                    where r.id not in (select routes_id from route_climber where climber_id = :climberId)
//                    and r.grade <= (select strength from climber c where c.id = :climberId)
//                    and (select price from centre where id = r.centre_id) <= (select budget from climber c where c.id = :climberId)
//                    order by r.grade;
//            """, nativeQuery = true)
    @Query(value = """
            SELECT r FROM Route r
                where r not in (select cl.routes from Climber cl where cl.id = :climberId)
                and r.grade <= (select cl.strength from Climber cl where cl.id = :climberId)
                and (r.centre.price <= (select cl.budget from Climber cl where cl.id = :climberId))
                order by r.grade""")
//    @Query(value = """
//            SELECT r FROM Route r join Climber c on c.id
//                where r not in (select cl.routes from Climber cl where cl.id = :climberId)
//                and r.grade <= c.strength
//                and r.centre.price <= c.budget
//                order by r.grade""")
    Iterable<Route> recommendRoutesForClimber(@Param("climberId") Long climberId);
}
