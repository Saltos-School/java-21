import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class HolaVirtualThreads {

    public static void hilosTradicionales() {
        var inicio = System.currentTimeMillis();
        var hilos = new Vector<Thread>(5);
        final int j = 20;
        final AtomicLong total = new AtomicLong(0);
        final AtomicLong total2 = new AtomicLong(0);
        for (int i = 0; i < 5; i++) {
            final var mensaje = "Ejecutando hilo numero " + i + " (" + j + ")";
            final var iCopia = i;
            var thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    total.addAndGet(iCopia);
                    total2.incrementAndGet();
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
        System.out.println("El total es " + total);
        System.out.println("El total2 es " + total2);
        var fin = System.currentTimeMillis();
        System.out.printf("Tiempo total %dms", fin - inicio);
    }

    public static void hilosConStreams() {
        var inicio = System.currentTimeMillis();
        var hilos = IntStream.rangeClosed(1, 5).boxed().map(i -> {
           var thread = new Thread(() -> {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Ejecutando hilo " + i);
           });
           thread.start();
           return thread;
        }).toList();
        hilos.forEach(t -> {
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Continuando");
        var fin = System.currentTimeMillis();
        System.out.printf("Tiempo total %dms", fin - inicio);
    }

    public static void main(String[] args) {
        var inicio = System.currentTimeMillis();
        var hilos = IntStream.range(0, 50000)
                .boxed()
                .map(i -> Thread.ofPlatform().start(() -> Math.sqrt(Math.pow(Math.random(), i))))
                .toList();
        for (var hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        var fin = System.currentTimeMillis();
        System.out.printf("Tiempo total %dms", fin - inicio);
    }

}
