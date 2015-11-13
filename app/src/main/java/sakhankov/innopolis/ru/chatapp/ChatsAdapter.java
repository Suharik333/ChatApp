package sakhankov.innopolis.ru.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatsAdapter extends ArrayAdapter<Chat> {
    private final Context context;
    private final List<Chat> values;

    public ChatsAdapter(Context context, List<Chat> values) {
        super(context, R.layout.chat_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.chat_list_item, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.chat_title);
        TextView macView = (TextView) rowView.findViewById(R.id.mac_address);
        ImageView logoView = (ImageView) rowView.findViewById(R.id.chat_icon);
        titleView.setText(values.get(position).getTitle());
        macView.setText(values.get(position).getAddress());
//        Integer logoId = values.get(position).getLogoId();
//        if (logoId != null) {
//            logoView.setImageResource(logoId);
//        } else {
//            logoView.setImageBitmap(values.get(position).getLogo());
//        }
        return rowView;
    }
}

