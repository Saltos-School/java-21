import java.util.Vector;

public class HolaVirtualThreads {

    public static void main(String[] args) {
        var inicio = System.currentTimeMillis();
        var hilos = new Vector<Thread>(5);
        final int j = 20;
        for (int i = 0; i < 5; i++) {
            final var mensaje = "Ejecutando hilo numero " + i + " (" + j + ")";
            var thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(mensaje);
                }
            });
            hilos.add(thread);
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                var thread = hilos.get(i);
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Continuando main");
        var fin = System.currentTimeMillis();
        System.out.printf("Tiempo total %dms", fin - inicio);
    }
}
