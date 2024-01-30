import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    private int port;
    private List<ChatRoom> chatRooms;
    private Map<User, Socket> usersMap;


    public Server(int port) {
        this.port = port;
        this.chatRooms = new ArrayList<>();
        this.usersMap = new HashMap<>();
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        do {
            Socket socket = serverSocket.accept();
            User user = new User();
            usersMap.put(user, socket);

        } while (true);
    }

    public void addChatRoomToUser(ChatRoom chatRoom, User user) {
        chatRooms.add(chatRoom);
        if (!user.getChatRooms().contains(chatRoom)) {
            user.addChatRoom(chatRoom);
        }
    }

    public void addUserToChatRoom(User user, ChatRoom chatRoom) {
        if (!chatRoom.getUsers().contains(user)) {
            chatRoom.addUser(user);
        }
    }

    private void sendMessage(User sender, ChatRoom chatRoom, String text) {
        chatRoom.addMessage(new Message(text, sender, chatRoom));
    }

    public void receiveCommand() {
        for (Socket socket: usersMap.values()) {
            try (Scanner in = new Scanner(socket.getInputStream())) {
                String commandLine = in.nextLine();
                if (commandLine != null) {
                    solveCommand(commandLine);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void solveCommand(String commandLine) {
        String [] parts = commandLine.split(";");
        switch (parts[0]) {
            case "CREATE":

                addChatRoomToUser(new ChatRoom(parts[2], getUserByNickName(parts[1]), Integer.parseInt(parts[3])), getUserByNickName(parts[1]));
            case "JOIN": addUserToChatRoom(getUserByNickName(parts[1]), getChatRoomById(parts[2]));
            case "SEND": sendMessage(getUserByNickName(parts[1]), getChatRoomById(parts[2]), parts[3]);
        }
    }

    private User getUserByNickName(String nickName) {
        return usersMap.keySet().stream()
                .filter(u -> Objects.equals(u.getNickname(), nickName))
                .toList()
                .getFirst();
    }

    private ChatRoom getChatRoomById(String id) {
        return chatRooms.stream()
                .filter(cr -> Objects.equals(cr.getId(), id))
                .toList()
                .getFirst();
    }

    private Message buildMessage(String commandLine) {
        String [] parts = commandLine.split(";");
        String senderId = parts[1];
        String chatRoomId = parts[2];
        String text = parts[3];

        return new Message(text, getUserByNickName(senderId), getChatRoomById(chatRoomId));
    }
}
