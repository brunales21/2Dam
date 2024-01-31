import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Client {
    private String nickname;
    private String command;
    private List<ChatRoom> chatRooms;
    private List<User> users;
    private List<Channel> channels;



    public User(String nickname, String hostname, int port) {
        super(hostname, port);
        this.nickname = nickname;
        this.channels = new ArrayList<>();
        this.chatRooms = new ArrayList<>();
        this.users = new ArrayList<>();

    }

    public User(String nickname) {
        this.nickname = nickname;
        this.channels = new ArrayList<>();
        this.chatRooms = new ArrayList<>();
        this.users = new ArrayList<>();
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
        sendMessage("CREATE " + receptorName);
    }
    public void sendTextMessage(String receptorName, String textMessage) {
        sendMessage("SEND " + receptorName + " :"+textMessage);
    }


    public void receive() {
        try (Scanner in = new Scanner(getSocket().getInputStream())) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ChatRoom> getChatRooms() {
        return chatRooms;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
