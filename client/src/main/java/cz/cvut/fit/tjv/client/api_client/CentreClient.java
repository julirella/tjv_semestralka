package cz.cvut.fit.tjv.client.api_client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fit.tjv.client.domain.Centre;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public class CentreClient extends AbstractClient<Centre>{
    public CentreClient() {
        super("/centre", Centre.class);
    }

//    @Override
//    Centre convertFromHashList(Centre map) {
//        ObjectMapper mapper = new ObjectMapper();
//        Centre centre = mapper.convertValue(map, Centre.class);
//        return centre;
//    }

    @Override
    List<Centre> convertFromHashList(List<Centre> map) {
        ObjectMapper mapper = new ObjectMapper();
        List<Centre> changedEntities = mapper.convertValue(map, new TypeReference<List<Centre>>() { });
        return changedEntities;
    }
}
