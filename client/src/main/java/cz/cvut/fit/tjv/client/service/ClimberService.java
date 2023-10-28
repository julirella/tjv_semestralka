package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.ClimberClient;
import cz.cvut.fit.tjv.client.domain.Climber;
import org.springframework.stereotype.Service;

@Service
public class ClimberService extends AbstractService<Climber>{
    public ClimberService(ClimberClient client) {
        super(client);
    }
}
