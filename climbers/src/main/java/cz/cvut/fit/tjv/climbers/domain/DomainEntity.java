package cz.cvut.fit.tjv.climbers.domain;

import java.io.Serializable;

public interface DomainEntity<ID> extends Serializable {
    ID getID();
}
