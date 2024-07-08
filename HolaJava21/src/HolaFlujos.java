import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HolaFlujos {

    static Stream<String> abrirFlujo1() {
        return Stream.of("a", "b", "c");
    }

    public static void main(String[] args) {
        System.out.println("Flujo1: " + abrirFlujo1());
        List<String> list1 = abrirFlujo1().toList();
        List<String> list1ConCollect = abrirFlujo1().collect(Collectors.toList());
        System.out.println("Flujo1 como lista: " + list1);
        System.out.println("Flujo1 como lista con collect: " + list1ConCollect);
        abrirFlujo1().forEach(new Consumer<String>() {
            @Override
            public void accept(String elemento) {
                System.out.println(elemento);
            }
        });
        abrirFlujo1().forEach(elemento -> System.out.println(elemento));

        Stream<String> flujo1Resultado = abrirFlujo1().map(elemento -> elemento.toUpperCase());
        Stream<String> flujo1Resultado2 = abrirFlujo1().map(String::toUpperCase);
        System.out.println("Flujo1 resultado: " + flujo1Resultado.toList());
        System.out.println("Flujo1 resultado2: " + flujo1Resultado2.toList());

    }

}
