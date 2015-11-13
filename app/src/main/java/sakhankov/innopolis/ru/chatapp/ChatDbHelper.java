package sakhankov.innopolis.ru.chatapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChatDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "chat.db";

    private static final String SQL_CREATE_CHATS_ENTRIES =
            "CREATE TABLE " + ChatContract.ChatEntry.TABLE_NAME + " (" +
                    ChatContract.ChatEntry._ID + " INTEGER PRIMARY KEY," +
                    ChatContract.ChatEntry.COLUMN_NAME_TITLE + " TEXT," +
                    ChatContract.ChatEntry.COLUMN_NAME_ADDRESS + " TEXT" +
                    " )";
    private static final String SQL_CREATE_MESSAGES_ENTRIES =
            "CREATE TABLE " + ChatContract.MessagesEntry.TABLE_NAME + " (" +
                    ChatContract.MessagesEntry._ID + " INTEGER PRIMARY KEY," +
                    ChatContract.MessagesEntry.COLUMN_NAME_TITLE + " TEXT," +
                    ChatContract.MessagesEntry.COLUMN_NAME_TEXT + " TEXT" +
                    " )";
    private Context context;


    public ChatDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CHATS_ENTRIES);
        db.execSQL(SQL_CREATE_MESSAGES_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + ChatContract.ChatEntry.TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Do nothing
    }
}