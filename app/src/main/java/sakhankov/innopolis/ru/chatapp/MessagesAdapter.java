package sakhankov.innopolis.ru.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessagesAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final List<Message> values;

    public MessagesAdapter(Context context, List<Message> values) {
        super(context, R.layout.chat_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.message_list_item, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.message_title);
        ImageView logoView = (ImageView) rowView.findViewById(R.id.message_icon);
        titleView.setText(values.get(position).getTitle());
//        Integer logoId = values.get(position).getLogoId();
//        if (logoId != null) {
//            logoView.setImageResource(logoId);
//        } else {
//            logoView.setImageBitmap(values.get(position).getLogo());
//        }
        return rowView;
    }
}

