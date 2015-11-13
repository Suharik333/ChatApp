package sakhankov.innopolis.ru.chatapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static sakhankov.innopolis.ru.chatapp.ChatContract.ChatEntry.TABLE_NAME;

public class Dao {
    private static final List<Chat> chats = new ArrayList<>();
    private static final List<Message> messages = new ArrayList<>();

    static {
        chats.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        chats.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        chats.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        chats.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        chats.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));

        messages.add(new Message("My message", "1212:sfds:dfsf:sdfsdf:sdfs"));
        messages.add(new Message("My message", "1212:sfds:dfsf:sdfsdf:sdfs"));
        messages.add(new Message("My message", "1212:sfds:dfsf:sdfsdf:sdfs"));
        messages.add(new Message("My message", "1212:sfds:dfsf:sdfsdf:sdfs"));
        messages.add(new Message("My message", "1212:sfds:dfsf:sdfsdf:sdfs"));
    }

    public static List<Chat> getAllChats(ChatDbHelper dbHelper) {
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor query = readableDatabase.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        query.moveToFirst();
        List<Chat> chats = new ArrayList<>();
        while (query.moveToNext()) {
            Chat chat = DbConverter.convertToChat(query);
            chats.add(chat);
        }
        return chats;
    }

    public static List<Message> getMessages(ChatDbHelper dbHelper, String macAddress) {
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor query = readableDatabase.query(ChatContract.MessagesEntry.TABLE_NAME,
                null,
                ChatContract.MessagesEntry.COLUMN_NAME_TEXT + " = '" + macAddress + "'",
                null,
                null,
                null,
                null);
        query.moveToFirst();
        List<Message> messages = new ArrayList<>();
        while (query.moveToNext()) {
            Message message = DbConverter.convertToMessage(query);
            messages.add(message);
        }
        return Dao.messages;
    }

    public static void saveChat(ChatDbHelper dbHelper, Chat chat) {
        chats.add(chat);
    }

    public static void saveMessage(ChatDbHelper dbHelper, Message message) {
        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
        writableDatabase.insert(ChatContract.MessagesEntry.TABLE_NAME, null, DbConverter.convertMessageToContentValues(message));
    }
}