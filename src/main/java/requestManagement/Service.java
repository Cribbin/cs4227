package requestManagement;


import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/**
 * This interface is used to define services that operate on the interception points exposed by the dispatcher.
 */
public interface Service {

    default void processIncomingRequest(HttpRequest request, Context context){

    }

    default void processOutgoingResponse(HttpResponse response, Context context) {

    }
}
