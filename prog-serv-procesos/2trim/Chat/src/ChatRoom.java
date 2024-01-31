import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String nickname;
    private List<User> users;
    private List<Message> messages;

    public ChatRoom(String id) {
        this.nickname = id;
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void addMessage(Message message) {
        messages.add(message);
    }
}