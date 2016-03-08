package taylor.calio.com;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L0612564 on 2/25/2016.
 */
public class wififragment extends Fragment {
    private View view;
    private ChatManager chatManager;
    private TextView textView;
    private ListView listView;
    private List<String> iteams = new ArrayList<>();
    private ChatMessageAdapter adapter=null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        textView= (TextView) view.findViewById(R.id.textView);
        listView = (ListView) view.findViewById(android.R.id.list);
        adapter = new ChatMessageAdapter(getActivity(), android.R.id.text1,
                iteams);
        listView.setAdapter(adapter);
        view.findViewById(R.id.SendButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        if (chatManager != null) {
                            chatManager.write(textView.getText().toString()
                                    .getBytes());
                            pushMessage("Me: " + textView.getText().toString());
                            textView.setText("");
                            textView.clearFocus();
                        }
                    }
                });
        return view;
    }
    public interface MessageTarget {
        public Handler getHandler();
    }
    public void setChatManager(ChatManager obj) {
        chatManager = obj;
    }
    public void pushMessage(String readMessage) {
        adapter.add(readMessage);
        adapter.notifyDataSetChanged();
    }
    /**
     * ArrayAdapter to manage chat messages.
     */
    public class ChatMessageAdapter extends ArrayAdapter<String> {
        List<String> messages = null;
        public ChatMessageAdapter(Context context, int textViewResourceId,
                                  List<String> items) {
            super(context, textViewResourceId, items);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getActivity()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(android.R.layout.simple_list_item_1, null);
            }
            String message = iteams.get(position);
            if (message != null && !message.isEmpty()) {
                TextView nameText = (TextView) v
                        .findViewById(android.R.id.text1);
                if (nameText != null) {
                    nameText.setText(message);
                    if (message.startsWith("Me: ")) {
                        nameText.setTextAppearance(getActivity(),
                                R.style.TextAppearance_MaterialCalendarWidget_Date);
                    } else {
                        nameText.setTextAppearance(getActivity(),
                                R.style.TextAppearance_MaterialCalendarWidget_Header);
                    }
                }
            }
            return v;
        }
    }
}






