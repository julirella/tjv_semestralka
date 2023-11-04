package cz.cvut.fit.tjv.client.api_client;

import cz.cvut.fit.tjv.client.domain.Centre;
import org.springframework.stereotype.Component;

@Component
public class CentreClient extends AbstractClient<Centre>{
    public CentreClient() {
        super("/centre", Centre.class);
    }
}
