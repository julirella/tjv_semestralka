package cz.cvut.fit.tjv.climbers2.dao.jpa;

import cz.cvut.fit.tjv.climbers2.dao.CrudRepository;
import cz.cvut.fit.tjv.climbers2.domain.Climber;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ClimberJpaRepository extends JpaRepository<Climber, Long>, CrudRepository<Climber, Long> {
}
