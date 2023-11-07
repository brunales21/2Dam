public class ThreadUtils {
    public static void esperarSegundos(int s) {
        try {
            Thread.sleep(s*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
