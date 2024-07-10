import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// Use with JVM options -XX:+UseZGC -Xms16g -Xmx16g
public class HolaGarbageCollectors {

    private static Map<String, String> stringContainer = new HashMap<>();

    public static void main(String[] args) {
        var sb = new StringBuilder();

        for (int i = 0; i < 1_000_000; i++) {
            sb.append(i % 10);
        }

        var muestra = sb.toString();

        var max = 10_000;

        Supplier<String> generarNuevaCadena = () -> {
            var sbNuevaCadena = new StringBuilder();
            sbNuevaCadena.append(muestra);
            sbNuevaCadena.append(Math.round(Math.random() * max));
            return sbNuevaCadena.toString();
        };

        var runtime = Runtime.getRuntime();

        while(true) {

            var start = System.currentTimeMillis();
            for (int i = 0; i < max ; i++) {
                var nuevaCadena = generarNuevaCadena.get();
                stringContainer.put(nuevaCadena, nuevaCadena);
            }

            for (int i = 0; i < max; i++) {
                var nuevaCadena = generarNuevaCadena.get();
                stringContainer.remove(nuevaCadena);
            }

            var end = System.currentTimeMillis();

            System.out.printf("Memoria total %dm, libre %dm, max %dm, ", runtime.totalMemory() / 1024 / 1024, runtime.freeMemory() / 1024 / 1024, runtime.maxMemory() / 1024 / 1024);
            System.out.printf("total de cadenas %s en %dms\n", stringContainer.size(), end - start);
        }
    }

}
