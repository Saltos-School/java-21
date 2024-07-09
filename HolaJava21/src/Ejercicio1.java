import java.util.ArrayList;
import java.util.stream.Stream;

public class Ejercicio1 {

    public static void main(String[] args) {
        var numeroEnTexto = """
                1
                2
                3
                -5
                hola
                20
                80
                -100""";
        var lista = numeroEnTexto.lines().toList();
        var intermedio = lista.stream()
                .<Integer>mapMulti((s, cursor) -> {
                    try {
                        cursor.accept(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                    }
                }).toList();
        var resultado = intermedio.stream()
                .filter(i -> i >= 0)
                .count();
        System.out.println("Resultado: " + resultado);
        System.out.println("listaNumeros: " + intermedio);
    }

}
