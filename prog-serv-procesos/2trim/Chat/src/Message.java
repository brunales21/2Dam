public class Message {
    private User sender;
    private String text;

    public Message(User sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    @Override
    public String toString() {
        return sender+";"+text;
    }
}