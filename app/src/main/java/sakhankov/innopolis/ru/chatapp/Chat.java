package sakhankov.innopolis.ru.chatapp;

public class Chat {
    private final String title;
    private final String address;

    public Chat(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }
}
