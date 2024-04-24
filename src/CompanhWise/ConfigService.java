package CompanhWise;

import java.util.HashMap;
import java.util.Map;


public class ConfigService {
    public  static Map<String, Integer> configMap = new HashMap<>();

    public void feedConfig(String serviceName, Integer config){
        configMap.put(serviceName, config);
    }

    public int getCongif(String serviceName){
        return configMap.get(serviceName);
    }

}
