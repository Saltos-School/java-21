import java.util.ArrayList;
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

        var futuros = new ArrayList<CompletableFuture<Double>>();

        for(int i = 0; i < 10; i++) {
            var resultado = calcularResultado();
            futuros.add(resultado);
        }

        var elmasrapido = CompletableFuture.anyOf(futuros.toArray(new CompletableFuture[0]));

        Thread.sleep(100);
        switch (elmasrapido.state()) {
            case RUNNING -> {
                System.out.println("No se ha completado el futuro todavía");
            }
            case SUCCESS -> {
                System.out.println(elmasrapido.get());
            }
            case FAILED -> {
                System.err.println("El futuro ha fallado");
            }
            case CANCELLED -> {
                System.err.println("El futuro ha sido cancelado");
            }
        }
    }

    private static CompletableFuture<Double> calcularResultado() {
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
        return resultado;
    }

}
