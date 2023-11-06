public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Filosofo f = new Filosofo();
            System.out.println(f.threadId());
        }
    }
}
