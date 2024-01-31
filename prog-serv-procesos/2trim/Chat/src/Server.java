import java.io.IOException;
import java.io.PrintStream;
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
            while (true) {
                Socket socket = serverSocket.accept();
                Thread clientThread = new Thread(() -> handleClient(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void handleClient(Socket socket) {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("Estas conectado al servidor.");
            String nickname = in.nextLine();
            User user = new User(nickname);
            System.out.println(user.getNickname());
            socketUserMap.put(socket, user);
            userSocketMap.put(user, socket);
            startCommunication(socket);
        } catch (IOException e) {

        }
    }

    private void startCommunication(Socket socket) {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("Puedes comunicarte..");
            while (!socket.isClosed()) {
                String commandLine;
                if (in.hasNextLine()) {
                    commandLine = in.nextLine();
                    Thread thread = new Thread(() -> processCommand(socket, commandLine));
                    thread.start();
                }
            }
        } catch (IOException e) {
        }
    }

    private void create(String autor, String chatRoomName) {
        try {
            channels.add(new Channel(chatRoomName, getUserByNickName(autor)));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void send(String senderNickName, String receptorNickName, String text) {
        PrintStream senderOut = null;
        try {
            senderOut = new PrintStream(userSocketMap.get(getUserByNickName(senderNickName)).getOutputStream());
            User receptor = getUserByNickName(receptorNickName);
            User sender = getUserByNickName(senderNickName);

            if (!sender.getUsers().contains(receptor)) {
                sender.getUsers().add(receptor);
            }

            PrintStream receptorOut = new PrintStream(userSocketMap.get(getUserByNickName(receptorNickName)).getOutputStream());
            receptorOut.println(sender.getNickname() + ": " + text);
        } catch (IOException | UserNotFoundException e) {
            senderOut.println(e.getMessage());
        }


    }

    private void login(String nickname, Socket socket) {
        User user = new User(nickname);
        userSocketMap.put(user, socket);
    }

    private void listUsers(Socket socket) {
        try {
            PrintStream out = new PrintStream(socket.getOutputStream());
            List<User> users = socketUserMap.get(socket).getUsers();
            if (users.isEmpty()) {
                out.println("No users yet.");
            }
            users.forEach(u -> out.println(u.getNickname()));
        } catch (IOException e) {

        }
    }

    private void listChannels(Socket socket) {
        try {
            PrintStream out = new PrintStream(socket.getOutputStream());
            socketUserMap.get(socket).getChannels().forEach(c -> out.println(c.getNickname()));
        } catch (IOException e) {

        }
    }


    private void join() {

    }


    public static String[] splitParts(String header) {
        String[] split = header.split(" ");
        if (split.length == 1) {
            return split;
        }
        int colonIndex = header.indexOf(":");
        String text = header.substring(colonIndex + 1); // +1 para excluir el ':'
        String prefix = header.substring(0, colonIndex);

        List<String> partsList = new ArrayList<>(Arrays.asList(prefix.split(" ")));
        partsList.add(text);

        return partsList.toArray(new String[0]);
    }


    private void processCommand(Socket socket, String commandLine) {
        String[] parts = splitParts(commandLine);
        switch (parts[0]) {
            case "CONNECT":
                login(parts[2], socket);
                break;
            case "CREATE":
                create(socketUserMap.get(socket).getNickname(), parts[1]);
                break;
            case "PRIVMSG":
                send(socketUserMap.get(socket).getNickname(), parts[1], parts[2]);
                break;
            case "JOIN":
                join();
                break;
            case "LU":
                listUsers(socket);
            case "LC":
                listChannels(socket);
        }
    }

    private User getUserByNickName(String nickname) throws UserNotFoundException {
        try {
            return userSocketMap.keySet().stream()
                    .filter(u -> Objects.equals(u.getNickname(), nickname))
                    .toList()
                    .getFirst();
        } catch (NoSuchElementException e) {
            throw new UserNotFoundException(nickname);
        }

    }

    private ChatRoom getChatRoomById(String id) {
        return channels.stream()
                .filter(cr -> Objects.equals(cr.getNickname(), id))
                .toList()
                .getFirst();
    }

    public static void main(String[] args) {
        Server server = new Server(80);
        server.start();
    }

}
