package CompanhWise;

import java.util.LinkedList;
import java.util.Queue;


public class ServiceRequest {
    String name;
    int throttleValue;
    long duration;

    Queue<Long> timeStamp;

    public ServiceRequest(){}
    public ServiceRequest(final String name, final int throttleValue, final Long duration) {
        this.name = name;
        this.throttleValue = throttleValue;
        this.duration = duration;
        this.timeStamp = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getThrottleValue() {
        return throttleValue;
    }

    public void setThrottleValue(final int throttleValue) {
        this.throttleValue = throttleValue;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    public Queue<Long> getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(final Queue<Long> timeStamp) {
        this.timeStamp = timeStamp;
    }
}
