import java.util.ArrayList;

public class Ejercicio1 {

    public static void main(String[] args) {
        var numeroEnTexto = """
                1
                2
                3
                -5
                20
                80
                -100""";
        var lista = numeroEnTexto.lines().toList();
        var intermedio = lista.stream()
                .map(Integer::parseInt).toList();
        var resultado = intermedio.stream()
                .filter(i -> i >= 0)
                .count();
        System.out.println("Resultado: " + resultado);
        System.out.println("listaNumeros: " + intermedio);
    }

}
