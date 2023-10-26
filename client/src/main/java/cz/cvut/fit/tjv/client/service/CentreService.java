package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.AbstractClient;
import cz.cvut.fit.tjv.client.api_client.CentreClient;
import cz.cvut.fit.tjv.client.domain.Centre;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CentreService extends AbstractService<Centre>{
    public CentreService(CentreClient client) {
        super(client);
    }
}
