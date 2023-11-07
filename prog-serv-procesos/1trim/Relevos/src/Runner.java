public class Runner extends Thread {
    private Runner prevRunner;
    private Runner nxtRunner;
    private boolean active;
    private boolean finished;

    public Runner() {
        this(false, false);
    }

    public Runner(Runner prevRunner) {
        this.prevRunner = prevRunner;
    }

    public Runner(boolean active, boolean corrio) {
        this.active = active;
        this.finished = corrio;
    }

    public void correr() {
        if () {
            System.out.println("Corriendo..");
            ThreadUtils.esperarSegundos(1);
            this.finished = true;

        } else {
            System.out.println("Esperando..");
        }

    }

    @Override
    public void run() {
        do {
            correr();
        } while (true);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean corrio() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Runner getPrevRunner() {
        return prevRunner;
    }

    public void setPrevRunner(Runner prevRunner) {
        this.prevRunner = prevRunner;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isFirst() {
        return prevRunner == null && nxtRunner != null;
    }

    public boolean isLast() {
        return prevRunner != null && nxtRunner == null;
    }
}
