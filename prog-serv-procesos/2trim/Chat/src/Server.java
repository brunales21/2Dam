import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    private int port;
    private List<Channel> channels;
    private List<PrivateChat> privateChats;
    private Map<Socket, User> socketUserMap;
    private Map<User, Socket> userSocketMap;



    public Server(int port) {
        this.port = port;
        this.privateChats = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.socketUserMap = new HashMap<>();
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        do {
            Socket socket = serverSocket.accept();
            User user = new User();
            socketUserMap.put(socket, user);
            userSocketMap.put(user, socket);

            Thread clientThread = new Thread(user);
            clientThread.start();

            Thread serverThread = new Thread(this::receiveCommand);
            serverThread.start();
        } while (true);
    }


    public void receiveCommand() {
        do {
            for (Socket socket: socketUserMap.keySet()) {
                try (Scanner in = new Scanner(socket.getInputStream())) {
                    String commandLine = in.nextLine();
                    if (commandLine != null) {
                        processCommand(socket, commandLine);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (true);

    }

    private void create(String autor, String chatRoomName) {
        channels.add(new Channel(chatRoomName, getUserByNickName(autor)));
    }

    private void send(String senderNickName, String receptorNickName, String text) {
        User sender = getUserByNickName(senderNickName);
        Message message = new Message(sender, receptorNickName, text);
        try (PrintWriter out = new PrintWriter(userSocketMap.get(sender).getOutputStream())) {
            out.print(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void join() {

    }


    private void processCommand(Socket socket, String commandLine) {
        String [] parts = commandLine.split(";");
        switch (parts[0]) {
            case "CREATE":
                create(socketUserMap.get(socket).getNickname(), parts[1]);
            case "SEND":
                send(socketUserMap.get(socket).getNickname(), parts[1], parts[2]);
            case "JOIN":
                join();
        }
    }

    private User getUserByNickName(String nickName) {
        return socketUserMap.values().stream()
                .filter(u -> Objects.equals(u.getNickname(), nickName))
                .toList()
                .getFirst();
    }

    private ChatRoom getChatRoomById(String id) {
        return channels.stream()
                .filter(cr -> Objects.equals(cr.getId(), id))
                .toList()
                .getFirst();
    }

}
