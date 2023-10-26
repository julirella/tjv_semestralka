package cz.cvut.fit.tjv.client.api_client;

import cz.cvut.fit.tjv.client.domain.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CentreClient extends AbstractClient<Centre>{
//    String endpoint = "/centre";
    public CentreClient() {
        super("/centre");
    }

//    public CentreClient(String endpoint) {
//        super(endpoint);
//    }
}
