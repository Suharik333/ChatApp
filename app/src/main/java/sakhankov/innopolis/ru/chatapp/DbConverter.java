package sakhankov.innopolis.ru.chatapp;

import android.content.ContentValues;
import android.database.Cursor;

public class DbConverter {
    public static ContentValues convertChatToContentValues(Chat chat) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ChatContract.ChatEntry.COLUMN_NAME_TITLE, chat.getTitle());
        contentValues.put(ChatContract.ChatEntry.COLUMN_NAME_ADDRESS, chat.getAddress());
        return contentValues;
    }

    public static Chat convertToChat(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(ChatContract.ChatEntry._ID));
        String title = cursor.getString(cursor.getColumnIndex(ChatContract.ChatEntry.COLUMN_NAME_TITLE));
        String address = cursor.getString(cursor.getColumnIndex(ChatContract.ChatEntry.COLUMN_NAME_ADDRESS));
        Chat chat = new Chat(title, address);
        return chat;
    }

    public static Message convertToMessage(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(ChatContract.ChatEntry._ID));
        String title = cursor.getString(cursor.getColumnIndex(ChatContract.MessagesEntry.COLUMN_NAME_TITLE));
        String text = cursor.getString(cursor.getColumnIndex(ChatContract.MessagesEntry.COLUMN_NAME_TEXT));
        Message message = new Message(title, text);
        return message;
    }

    public static ContentValues convertMessageToContentValues(Message message) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ChatContract.ChatEntry.COLUMN_NAME_TITLE, message.getTitle());
        contentValues.put(ChatContract.ChatEntry.COLUMN_NAME_ADDRESS, message.getText());
        return contentValues;
    }
}
