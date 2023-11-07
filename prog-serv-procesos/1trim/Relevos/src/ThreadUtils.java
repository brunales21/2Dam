public class ThreadUtils {
    public static void esperarSegundos(int n) {
        try {
            Thread.sleep(n*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
