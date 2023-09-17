package cz.cvut.fit.tjv.climbers2.dao;

import cz.cvut.fit.tjv.climbers2.domain.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
}
