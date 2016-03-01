package taylor.calio.com;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import java.nio.channels.Channel;

/**
 * Created by L0612564 on 2/22/2016.
 *
 */


public class WifiDirectBroadcast extends BroadcastReceiver {
    private WifiP2pManager manager ;
    private Channel channel ;
    private Activity activity;


    public WifiDirectBroadcast(WifiP2pManager manager, Channel channel, Activity activity){

        super();
        this.manager=manager;
        this.channel=channel;
        this.activity=activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Log.d(WiFiServiceDiscoveryActivity.TAG,action);
        if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            if (manager==null){
                return;
            }
            NetworkInfo networkInfo=(NetworkInfo) intent
                    .getParcelableExtra(WifiP2pManager .EXTRA_NETWORK_INFO);
            if(networkInfo.isConnected()) {
                Log.d(WiFiServiceDiscoveryActivity.TAG, "Connected to Wifi");
                manager.requestConnectionInfo((WifiP2pManager.Channel) channel, (WifiP2pManager.ConnectionInfoListener) activity);
            } else {


                }

            }else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)){
            WifiP2pDevice device=(WifiP2pDevice)intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE);
            Log.d(WiFiServiceDiscoveryActivity.TAG,"Status"+device.status);
        }

    }
}


