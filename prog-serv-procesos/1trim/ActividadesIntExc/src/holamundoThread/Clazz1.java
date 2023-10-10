package holamundoThread;

public class Clazz1 extends Thread {
    @Override
    public void run() {
        System.out.println("hola mundo "+threadId());
    }
}
