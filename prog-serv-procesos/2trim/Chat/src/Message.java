public class Message {
    private User sender;
    private String receptorName;
    private String text;

    public Message(User sender, String receptorName, String text) {
        this.sender = sender;
        this.receptorName = receptorName;
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getReceptorName() {
        return receptorName;
    }

    public void setReceptorName(String receptorName) {
        this.receptorName = receptorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
