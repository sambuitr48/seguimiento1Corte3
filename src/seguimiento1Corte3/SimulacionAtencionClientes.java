package seguimiento1Corte3;

import java.util.concurrent.Semaphore;

public class SimulacionAtencionClientes implements Runnable{
    private int id;
    private Semaphore semaforoPreferencia;
    private Semaphore semaforoSinPreferencia;

    public SimulacionAtencionClientes(int id, Semaphore semaforoPreferencia, Semaphore semaforoSinPreferencia) {
        this.id = id;
        this.semaforoPreferencia = semaforoPreferencia;
        this.semaforoSinPreferencia = semaforoSinPreferencia;
    }
    public void run(){
        try {
            if (id <= 5) {
                semaforoPreferencia.acquire();
                System.out.println("Cliente preferencial " + id + " está siendo atendido. ");
                Thread.sleep(3000);
                System.out.println("Cliente preferencial " + id + " ha sido atendido.");
                semaforoPreferencia.release();
            } else {
                semaforoSinPreferencia.acquire();
                System.out.println("Cliente sin preferencia " + id + " está siendo atendido.");
                Thread.sleep(5000);
                System.out.println("Cliente sin preferencia " + id + " ha sido atendido");
                semaforoSinPreferencia.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
