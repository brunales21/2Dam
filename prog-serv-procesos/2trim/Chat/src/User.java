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

    public User() {
        super();
    }


    private void buildCommand() {

    }

    private void sendCommand() {
        try (PrintStream out = new PrintStream(socket.getOutputStream())) {
            out.println(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}
