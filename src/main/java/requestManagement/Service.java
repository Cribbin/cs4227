package requestManagement;

/**
 * This interface is used to define services that operate on the interception points exposed by the dispatcher.
 */
public interface Service {

    default void processIncomingRequest(Context context) { }

    default void processOutgoingResponse(Context context) { }
}
