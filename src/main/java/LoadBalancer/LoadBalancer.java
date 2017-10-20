package LoadBalancer;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public interface LoadBalancer {


    static LoadBalancerBuilder getBuilder(){
        return new LoadBalancerBuilder();
    }

}
