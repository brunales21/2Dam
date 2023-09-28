package excepciones;

class Prueba {
    int contador = 0;
    void excepcionesAnidadas() throws Exception {
        try {
            contador++;
            try {
                contador++;
                try {
                    contador++;
                    throw new Exception();
                }
                catch(Exception ex) {
                    contador++;
                    throw new Exception();
                }
            }
            catch(Exception ex) {
                contador++;
            }
        }
        catch(Exception ex) {
            contador++;
        }
    }
    void mostrar() {
        System.out.println(contador);
    }
    public static void main(String[] args) throws Exception {
        Prueba objPru = new Prueba();
        objPru.excepcionesAnidadas();
        objPru.mostrar();
    }
}
