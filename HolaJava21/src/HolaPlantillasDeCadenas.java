import static java.util.FormatProcessor.FMT;

public class HolaPlantillasDeCadenas {

    public static void main(String[] args) {
        var numero = 5;
        var s1 = STR."Numero: \{numero}";
        var s2 = STR."""
                Numero: \{numero}
                Numero otra vez: \{numero}
                """;
        System.out.println(s1);
        System.out.println(s2);
        var flotante = 3.4215454f;
        var unitario = "test";
        var unitarioEnMayusculas = unitario.toUpperCase();
        var s3 = FMT."""
                numero: %-10d\{numero} x
                flotante: %2.2f\{flotante}
                unitario: %10s\{unitarioEnMayusculas} unidades
                unitario: %10s\{unitario.toUpperCase()} unidades
                """;
        System.out.println(s3);

        var PAUL = StringTemplate.Processor.of(
                (StringTemplate st) -> {
                    var cadena = st.interpolate();
                    return cadena.toUpperCase();
                }
        );

        var s4 = PAUL."Esto es una prueba \{numero}";
        System.out.println(s4);

        record Persona(String nombre, String apellido, int edad) {};

        var P = StringTemplate.Processor.of(
                (StringTemplate st) -> {
                    var cadena = st.interpolate();
                    var partes = cadena.split(",");
                    var nombre = partes[0].trim();
                    var apellido = partes[1].trim();
                    var edad = Integer.parseInt(partes[2].trim());
                    return new Persona(nombre, apellido, edad);
                }
        );

        var paul = P."Paúl, Saltos, 48";
        System.out.println(paul);
    }

}
