package taylor.calio.com;

import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static taylor.calio.com.WiFiServiceDiscoveryActivity.*;

/**
 * Handles reading and writing of messages with socket buffers. Uses a Handler
 * to post messages to UI thread for UI updates.
 */
public class ChatManager implements Runnable {
    private Socket socket = null;
    private Handler handler;
    public ChatManager(Socket socket, Handler handler) {
        this.socket = socket;
        this.handler = handler;
    }
    private InputStream iStream;
    private OutputStream oStream;
    private static final String TAG = "ChatHandler";

    public ChatManager(Socket socket, java.util.logging.Handler handler) {

    }

    @Override
    public void run() {
        try {
            iStream = socket.getInputStream();
            oStream = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytes;
            int MY_HANDXLE = 0;
            handler.obtainMessage(MY_HANDXLE, this)
                    .sendToTarget();
            while (true) {
                try {
                    // Read from the InputStream
                    bytes = iStream.read(buffer);
                    if (bytes == -1) {
                        break;
                    }
                    // Send the obtained bytes to the UI Activity
                    Log.d(TAG, "Rec:" + String.valueOf(buffer));
                    int MESSAGE_READ = 0;
                    handler.obtainMessage(MESSAGE_READ,
                            bytes, -1, buffer).sendToTarget();
                } catch (IOException e) {
                    Log.e(TAG, "disconnected", e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void write(byte[] buffer) {
        try {
            oStream.write(buffer);
        } catch (IOException e) {
            Log.e(TAG, "Exception during write", e);
        }
    }
}