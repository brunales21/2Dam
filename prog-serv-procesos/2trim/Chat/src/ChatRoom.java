import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String id;
    protected User moderator;
    private int maxUsers;
    private List<User> users;
    private List<Message> messages;

    public ChatRoom(String id, User moderator, int maxUsers) {
        this.id = id;
        this.moderator = moderator;
        this.maxUsers = maxUsers;
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
        addUser(moderator);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addUser(User user) {
        users.add(user);
    }


    public void addMessage(Message message) {
        messages.add(message);
    }
    public User getModerator() {
        return moderator;
    }

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
