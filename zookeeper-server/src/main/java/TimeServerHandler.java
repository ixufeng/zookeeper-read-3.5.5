import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

/**
 * @author xufeng
 * Create Date: 2019-10-10 17:41
 **/
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String body;
            while (true) {
                body = in.readLine();
                if (Objects.equals(body, "bye\n")) {
                    break;
                } else {
                    socket.getOutputStream().write(body.getBytes());
                }
            }
        } catch (Exception e) {
            //
        }
    }
}
