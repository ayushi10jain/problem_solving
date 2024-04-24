package CompanhWise;

public class RateLimitRequest {
    String requestId;
    ServiceRequest service;

    public RateLimitRequest(final String s, final ServiceRequest serviceRequest) {
        this.requestId = s;
        this.service = serviceRequest;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    public ServiceRequest getService() {
        return service;
    }

    public void setService(final ServiceRequest service) {
        this.service = service;
    }
}
