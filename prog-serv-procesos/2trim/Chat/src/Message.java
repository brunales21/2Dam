public class Message {
    private String text;
    private User sender;
    private ChatRoom chatRoom;

    public Message(String text, User sender, ChatRoom chat) {
        this.text = text;
        this.sender = sender;
        this.chatRoom = chat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
