import java.util.ArrayList;

public class Ejercicio1 {

    public static void main(String[] args) {
        var listaNumeros = new ArrayList<Integer>();
        var numeroEnTexto = """
                1
                2
                3
                -5
                20
                80
                -100""";
        var lista = numeroEnTexto.lines().toList();
        var resultado = lista.stream()
                .map(s -> {
                    var i = Integer.parseInt(s);
                    listaNumeros.add(i);
                    return i;
                })
                //.filter(i -> i >= 0)
                .count();
        System.out.println("Resultado: " + resultado);
        System.out.println("listaNumeros: " + listaNumeros);
    }

}
