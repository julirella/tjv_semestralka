package cz.cvut.fit.tjv.climbers2.dao.jpa;

import cz.cvut.fit.tjv.climbers2.dao.CrudRepository;
import cz.cvut.fit.tjv.climbers2.domain.Centre;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CentreJpaRepository extends JpaRepository<Centre, Long>, CrudRepository<Centre, Long> {
}
