package cz.cvut.fit.tjv.client.api_client;

import cz.cvut.fit.tjv.client.domain.Climber;
import org.springframework.stereotype.Component;

@Component
public class ClimberClient extends AbstractClient<Climber>{
    public ClimberClient() {
        super("/climber", Climber.class);
    }
}
