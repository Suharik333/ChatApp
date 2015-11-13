package sakhankov.innopolis.ru.chatapp;

import java.util.UUID;

public class Constants {
    public static String MAC_ADDRESS = "mac_address";

    private Constants() {
    }

    public static final UUID CHAT_UUID =
            UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a661");

    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";
}
