package Problem;

/**
 * Created by develop on 19-01-17.
 */
public class NotSuchRouteException extends RuntimeException {
    public NotSuchRouteException(String s) {
        super("NO SUCH ROUTE");
    }
}
