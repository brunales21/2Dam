public class Runner extends Thread {
    private Runner prevRunner;
    private Runner nxtRunner;


    public void correr() {
        System.out.println("Hilo " + threadId() + " Corriendo..");
        ThreadUtils.esperarSegundos(1);
        if (!isLast()) {
            System.out.println("Hilo " + threadId() + " entrega testigo a hilo " + nxtRunner.threadId() + ".");
        } else {
            System.out.println("Hilo " + threadId() + " termino el relevo.");
        }

    }

    @Override
    public void run() {
        correr();
        if (!isLast()) {
            nxtRunner.start();
        }
    }


    public void setPrevRunner(Runner prevRunner) {
        this.prevRunner = prevRunner;
    }

    public void setNxtRunner(Runner nxtRunner) {
        this.nxtRunner = nxtRunner;
    }


    public boolean isFirst() {
        return prevRunner == null && nxtRunner != null;
    }

    public boolean isLast() {
        return prevRunner != null && nxtRunner == null;
    }
}
