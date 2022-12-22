package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.AbstractCrudService;
import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;

public abstract class AbstractCrudController<E extends DomainEntity<ID>, D, ID> {

    protected AbstractCrudService<E, ID> service;
}
