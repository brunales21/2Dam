package holamundoRunnable;

public class Clazz1 implements Runnable {
    private String name;
    private long tid;

    public Clazz1(String name) {
        this.name = name;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tid*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hola mundo "+name+tid);
    }
}
