package taylor.calio.com;

import android.app.Activity;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.os.Handler;
import android.os.Message;


/**
 * Created by L0612564 on 2/17/2016.
 */
public class WiFiServiceDiscoveryActivity extends Activity implements Handler.Callback,MessageTarget,ConnectionInfoListener {
   public static final String TAG="a" ;
    public static final String TXTRECORD_PROP_AVAILVABLE="available";
    public static final String SERVICE_INSTANCE="availavle";
 public static int SERVER_PORT;

 @Override
    public boolean handleMessage(Message msg) {
        return true;
    }

    @Override
    public void onConnectionInfoAvailable(WifiP2pInfo info) {

    }

    public class MY_HANDLE {
    }
}
