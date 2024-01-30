import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class User extends Client {
    private String nickname;
    private String command;
    private List<ChatRoom> chatRooms;

    public User(String name, String hostname, int port) {
        super(hostname, port);
        this.nickname = name;
        this.chatRooms = new ArrayList<>();
    }

    @Override
    public void run() {
        do {

        } while (true);
    }

    public User() {
        super();
    }

    private void sendMessage(String message) {
        try (PrintStream out = new PrintStream(getSocket().getOutputStream())) {
            out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createChannel(String receptorName) {
        sendMessage("CREATE;" + receptorName);
    }
    public void sendTextMessage(String receptorName, String textMessage) {
        sendMessage("SEND;" + receptorName + ";"+textMessage);
    }


    public void receive() {

    }

    public List<ChatRoom> getChatRooms() {
        return chatRooms;
    }

    public void addChatRoom(ChatRoom chatRoom) {
        chatRooms.add(chatRoom);
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setChatRooms(List<ChatRoom> chatRooms) {
        this.chatRooms = chatRooms;
    }


}
