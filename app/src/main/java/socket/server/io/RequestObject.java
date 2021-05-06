package socket.server.io;

import java.io.Serializable;
import java.util.Map;

public class RequestObject implements Serializable {
    public String managerName;
    public String method;
    public Map<String, String> args;
}
