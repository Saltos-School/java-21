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
        var flujo = numeroEnTexto.lines();
        var resultado = flujo
                .map(Integer::parseInt)
                .filter(i -> i >= 0).toList();
        System.out.println("Resultado: " + resultado);
    }

}
