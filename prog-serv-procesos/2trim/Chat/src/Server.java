import java.io.IOException;
import java.io.PrintStream;
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
        this.userSocketMap = new HashMap<>();

    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            do {
                Socket socket = serverSocket.accept();
                Scanner in = new Scanner(socket.getInputStream());
                String nickname = in.nextLine();
                User user = new User(nickname);
                System.out.println(nickname);
                socketUserMap.put(socket, user);
                userSocketMap.put(user, socket);

                Thread clientThread = new Thread(user);
                clientThread.start();

                receiveCommand(socket);

            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void receiveCommand(Socket socket) {
        do {
            try (Scanner in = new Scanner(socket.getInputStream())) {
                String commandLine = in.nextLine();
                if (commandLine != null) {
                    System.out.println(commandLine);
                    processCommand(socket, commandLine);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }

    private void create(String autor, String chatRoomName) {
        channels.add(new Channel(chatRoomName, getUserByNickName(autor)));
    }

    private void send(String senderNickName, String receptorNickName, String text) {
        User sender = getUserByNickName(senderNickName);
        try (PrintStream out = new PrintStream(userSocketMap.get(getUserByNickName(receptorNickName)).getOutputStream())) {
            out.println(sender+" "+text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void join() {

    }


    public static String[] splitParts(String header) {
        int colonIndex = header.indexOf(":");
        String text = header.substring(colonIndex + 1); // +1 para excluir el ':'
        String prefix = header.substring(0, colonIndex);

        List<String> partsList = new ArrayList<>(Arrays.asList(prefix.split(" ")));
        partsList.add(text);

        return partsList.toArray(new String[0]);
    }

    private void processCommand(Socket socket, String commandLine) {
        String [] parts = splitParts(commandLine);
        switch (parts[0]) {
            case "CONNECT":

            case "CREATE":
                create(socketUserMap.get(socket).getNickname(), parts[1]);
            case "SEND":
                send(socketUserMap.get(socket).getNickname(), parts[1], parts[2]);
            case "JOIN":
                join();
        }
    }

    private User getUserByNickName(String nickName) {
        return userSocketMap.keySet().stream()
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

    public static void main(String[] args) {
        Server server = new Server(80);
        server.start();
    }

}
