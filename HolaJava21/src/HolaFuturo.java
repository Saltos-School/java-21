import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HolaFuturo {

    static void imprimir() {
        System.out.println(Math.random());
    }

    static double calcular() {
        return Math.random();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var f1 = CompletableFuture.runAsync(() -> System.out.println("Hola Futuro"));
        Thread.sleep(100);
        System.out.println(f1.get());

        var resultado = CompletableFuture.supplyAsync(() -> {
            var numero = Math.random();
            if (numero < 0.5) {
                return numero;
            } else {
                throw new IllegalStateException("Numero muy grande");
            }
        }).exceptionallyAsync(e -> {
            System.err.println("El futuro 2 ha fallado por: " + e.getMessage());
            return 0.0;
        }).thenApplyAsync(valor -> valor * 10);

        Thread.sleep(100);
        switch (resultado.state()) {
            case RUNNING -> {
                System.out.println("No se ha completado el futuro todavía");
            }
            case SUCCESS -> {
                System.out.println(resultado.get());
            }
            case FAILED -> {
                System.err.println("El futuro ha fallado");
            }
            case CANCELLED -> {
                System.err.println("El futuro ha sido cancelado");
            }
        }
    }

}
