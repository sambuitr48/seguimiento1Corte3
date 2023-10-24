package seguimiento1Corte3;

import seguimiento1Corte3.SimulacionAtencionClientes;

import java.util.concurrent.Semaphore;

public class AtencionMain {
    public static void main(String[] args) {
        Semaphore semaforoPreferencia = new Semaphore(1);
        Semaphore semaforoSinPreferencia = new Semaphore(1);
        for (int i = 1; i <= 10; i++) {
            SimulacionAtencionClientes cliente = new SimulacionAtencionClientes(i, semaforoPreferencia, semaforoSinPreferencia);
            Thread thread = new Thread(cliente);
            thread.start();
        }
    }
}
