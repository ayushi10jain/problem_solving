package CompanhWise;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


public class ApiRateLimitService {

    public static void main(String[] args) {
        getRateLimitRequest();
        ConfigService configService = new ConfigService();
        configService.feedConfig(getRateLimitRequest().getService().getName(),
                getRateLimitRequest().getService().throttleValue);

    }

    public boolean RateLimitExecutor(){
        // validateRequest service, value,
        // Allow Request
        return allowRequest(getRateLimitRequest().getService());

    }

    private boolean allowRequest(final ServiceRequest service) {
        HashMap<String, Queue<Long>> serviceToTimeMap = new HashMap();
        if(!serviceToTimeMap.containsKey(service.name)){
            addRequestToQueue(service, serviceToTimeMap);
            return true;
        }else if(service.getTimeStamp().size() < service.getThrottleValue()){
            addRequestToQueue(service, serviceToTimeMap);
                return true;
        }else{
            Long currentTime = System.currentTimeMillis();
            int requewtRemoved = 0;
                while(currentTime - service.getTimeStamp().remove() > service.duration){
                    service.getTimeStamp().poll();
                    requewtRemoved++;
                }
                if(requewtRemoved > 0 ){
                    addRequestToQueue(service, serviceToTimeMap);
                    return true;
                }
                return false;
            }

        }

        public void addRequestToQueue(ServiceRequest service, Map<String, Queue<Long>> serviceToTimeMap){
            Queue<Long> time = service.getTimeStamp();
            time.add(System.currentTimeMillis());
            serviceToTimeMap.put(service.name, time);
        }


    private static RateLimitRequest getRateLimitRequest() {
        ServiceRequest serviceRequest = new ServiceRequest("A",5, 5L);
        RateLimitRequest request = new RateLimitRequest("id-1", serviceRequest);
        return request;
    }
}
