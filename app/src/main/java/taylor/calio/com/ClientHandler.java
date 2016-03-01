package taylor.calio.com;

import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Handler;

/**
 * Created by L0612564 on 2/23/2016.
 */
public class ClientHandler extends Thread {
    private final InetAddress mAddress;
    private Handler handler;
    private ChatManager chat;
    private InetAddress Maddress;
    private static final String TAG="ClientHandler";
    public ClientHandler(Handler handler,InetAddress groupAddress){
        this.handler=handler;
        this.mAddress=groupAddress;


    }
    public void run(){
        Socket socket=new Socket();
        try {
            socket.bind(null);
            socket.connect(new InetSocketAddress(mAddress.getHostAddress(),
                    WiFiServiceDiscoveryActivity.SERVER_PORT), 5000);
            Log.d(TAG, "Lauching");
            chat=new ChatManager(socket,handler);
            new Thread(chat).start();

        } catch (IOException e) {
            e.printStackTrace();
            try {
                socket.close();
            }
            catch (IOException e1) {
            }
            return;
            }
        }
    public ChatManager getChat(){return chat;}
    }


