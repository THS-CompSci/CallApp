package taylor.calio.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L0612564 on 2/25/2016.
 */
public class wififragment {
    private View view;
    private ChatManager chatManager;
    private TextView textView;
    private ListView listView;
    private List<String> iteam = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view=inflater.inflate(R.layout.fragment_chat,container,false);
        return view;
    }
}






