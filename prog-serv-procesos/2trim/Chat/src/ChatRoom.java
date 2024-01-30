import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String id;
    private List<User> users;
    private List<Message> messages;

    public ChatRoom(String id) {
        this.id = id;
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void addMessage(Message message) {
        messages.add(message);
    }
}