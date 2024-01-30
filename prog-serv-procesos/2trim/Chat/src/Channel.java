import java.util.ArrayList;
import java.util.List;

public class Channel extends ChatRoom {
    private User creator;
    private List<User> users;
    public Channel(String channelName, User creator) {
        super(channelName);
        this.creator = creator;
        this.users = new ArrayList<>();
    }

}
