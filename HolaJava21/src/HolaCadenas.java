public class HolaCadenas {

    public static void main(String[] args) {
        String cadena1 = "Hola";
        int numero1 = 1;
        System.out.println("Cadena1: " + cadena1 + ", Numero1: " + numero1);
        System.out.println(STR."Cadena1: \{cadena1}, Numero1: \{numero1}");
        System.out.printf("Cadena1: %s, Numero1: %d\n", cadena1, numero1);
        String cadenaConcatenada1 = "Cadena1: " + cadena1 + ", Numero1: " + numero1;
        String cadenaConcatenada2 = STR."Cadena1: \{cadena1}, Numero1: \{numero1}";
        String cadenaConcatenada3 = String.format("Cadena1: %s, Numero1: %d\n", cadena1, numero1);
        String cadenaSimple = "Hola2\n    Paul  \n\"Erica\"\nCarlos";
        String cadenaEnBloque = """
                Hola2
                    Paul \s
                "Erica"
                Carlos""";
        System.out.println(cadenaSimple);
        System.out.println(cadenaEnBloque);
        boolean iguales = cadenaSimple.equals(cadenaEnBloque);
        boolean iguales2 = cadenaSimple == cadenaEnBloque;
        System.out.println("Son iguales: " + iguales);
        System.out.println("Son iguales2: " + iguales2);
        System.out.println("Nueva linea");
    }

}
