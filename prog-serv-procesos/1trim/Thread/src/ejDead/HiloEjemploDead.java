package ejDead;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enrique
 */
public class HiloEjemploDead extends Thread {
    private boolean stopHilo = false;
    public void pararHilo()  {
        stopHilo = true;
        System.out.println("parar hilo");
    }


    //metodo run
    public void run() {
        while (!stopHilo) {
            System.out.println("Inicio del bucle del hilo y hago mis cositas");

            //en este bloque de cÃ³digo es dÃ³nde estarÃ­an las acciones que no pueden ser interrumpidas
            try {
                sleep(6000);
            } catch (Exception e) {}


            System.out.println("Fin del bucle del hilo... aquÃ­ ya habrÃ­amos terminado de hacer lo necesario y podrÃ­amos parar");
        }
    }


    public static void main(String[] args) {
        HiloEjemploDead h = new HiloEjemploDead ();
        h.start();
        for(int i=0;i<10000; i++)  {
            System.out.println(i);//no hago nada
        }
        h.pararHilo();
    }// main
}//fin clase hilo