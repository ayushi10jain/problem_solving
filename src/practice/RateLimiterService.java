package practice;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;


public class RateLimiterService {
    // Api is exposed to ouetr world
    // Rate limiter Request will have the customer, Each customer is having its own no of request i.e throttle
    // and duration i.e time in sec and the values would be configutrable.
    // Function should return true/false if the request is served or reject.
    static int throttleValue = 5;
    static Long duration = 1000L;
    static Map<String, Queue<Long>> customerToTimeMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        String customerId = "A";

        for (int i = 0; i < 6; i++) {
            boolean isAllowed = isRequestAllowed(customerId);
            System.out.println(i);
            System.out.println(isAllowed);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean isAllowed = isRequestAllowed(customerId);
        System.out.println(isAllowed);
    }

    private static boolean isRequestAllowed(final String customerId) {
        boolean allowRequest = false;
        Long currentTimeStamp = System.currentTimeMillis();
        if (!customerToTimeMap.containsKey(customerId)) {
            Queue<Long> timeStamp = new LinkedList<>();
            addTimeStampTOMAp(timeStamp, customerToTimeMap, currentTimeStamp, customerId);
            allowRequest = true;
        } else if (customerToTimeMap.get(customerId).size() < throttleValue) {

            Queue<Long> timeStamp = customerToTimeMap.get(customerId);
            addTimeStampTOMAp(timeStamp, customerToTimeMap, currentTimeStamp, customerId);
            allowRequest = true;
        } else {
            boolean action = false;
            Queue<Long> timeStamp = customerToTimeMap.get(customerId);

            if (remoteTimeStampFromQueue(timeStamp, duration, currentTimeStamp) == true) {
                addTimeStampTOMAp(timeStamp, customerToTimeMap, currentTimeStamp, customerId);
                allowRequest = true;
            } else {
                allowRequest = false;
            }
        }
        return allowRequest;

    }

    public static void addTimeStampTOMAp(Queue<Long> timeStamp, Map<String, Queue<Long>> customerToTimeMap,
            Long currentTimeStamp, String customerId) {
        timeStamp.add(currentTimeStamp);
        customerToTimeMap.put(customerId, timeStamp);

    }

    public static synchronized boolean remoteTimeStampFromQueue(Queue<Long> timeStamp, Long duration,
            Long currentTimeStamp) {
        while (timeStamp != null && !timeStamp.isEmpty() && currentTimeStamp - timeStamp.peek() > duration) {
            timeStamp.poll();
            return true;
        }
        return false;
    }
}



