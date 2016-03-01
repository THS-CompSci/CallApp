package taylor.calio.com;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Handler;

/**
 * Created by L0612564 on 2/24/2016.
 */
public class OwnerSocket extends Thread {
    ServerSocket socket = null;
    private Handler handler;
    private final int THERAD_COUNT=10;


    public OwnerSocket(Handler handler) throws IOException {
        try {
            socket = new ServerSocket(1234);
            this.handler = handler;
        } catch (IOException e) {
            e.printStackTrace();

            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException ioe) {
            }

            e.printStackTrace();




            }

        }
    }



