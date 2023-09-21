import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String comando = "java";
        String classpath = "C:\\Users\\bemim\\IdeaProjects\\BuscaMinas\\out\\production\\BuscaMinas"; // Ruta del classpath
        String clase = "Main";

        try {
            ProcessBuilder pb = new ProcessBuilder(comando, "-cp", classpath, clase);
            Process p = pb.start();
            int exitCode = p.waitFor();
            System.out.println("Exit Code = " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
