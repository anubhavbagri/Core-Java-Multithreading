package l_designpatterns.behavioral;

class Request {
    public String user;
    public int requestCount;
    public String payload;

    public Request(String user, int requestCount, String payload) {
        this.user = user;
        this.requestCount = requestCount;
        this.payload = payload;
    }
}

// handler interface
//
interface RequestHandler {
    public void setNext(RequestHandler next);

    public void handle(Request request);
}

// abstract BaseHandler with reusable functionality
abstract class BaseHandler implements RequestHandler {
    protected RequestHandler next;

    @Override
    public void setNext(RequestHandler next) {
        this.next = next;
    }

    protected void forward(Request request) {
        if (next != null) {
            next.handle(request);
        }
    }
}

/*
 * each concrete handler implements one responsibility
 * implement handle(request) & determine whether to continue chain or
 * short-circuit it
 */
class AuthHandler extends BaseHandler {

    @Override
    public void handle(Request request) {
        if (request.user == null) {
            System.out.println("AuthHandler: user not authenticated.");
            return;
        }
        System.out.println("AuthHandler: Authenticated.");
        forward(request);
    }
}

class RateLimitHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if (request.requestCount >= 100) {
            System.out.println("RateLimitHandler: Rate limit exceeded.");
            return;
        }
        System.out.println("RateLimitHandler: Within rate limit");
        forward(request);
    }
}

class ValidationHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if (request.payload == null || request.payload.isEmpty()) {
            System.out.println("ValidationHandler: Invalid payload.");
            return;
        }
        System.out.println("ValidationHandler: Payload valid");
        forward(request);
    }

}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        BaseHandler auth = new AuthHandler();
        BaseHandler rateLimit = new RateLimitHandler();
        BaseHandler validate = new ValidationHandler();

        auth.setNext(rateLimit);
        rateLimit.setNext(validate);

        Request req = new Request("john", 10, "{'data': '123'}");
        auth.handle(req);

        System.out.println();
        Request req2 = new Request("john", 12, "");
        auth.handle(req2);
    }
}
