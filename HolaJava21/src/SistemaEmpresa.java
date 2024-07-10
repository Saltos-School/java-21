sealed interface Empleado permits Fijo, Autonomo, Becario, MedioTiempo, TiempoExtra {
    String nombre();
    int edad();
}

record Fijo(String nombre, int edad) implements Empleado {
}

record Autonomo(String nombre, int edad) implements Empleado {
}

record Becario(String nombre, int edad) implements Empleado {
}

record MedioTiempo(String nombre, int edad) implements Empleado {
}

record TiempoExtra(String nombre, int edad) implements Empleado {
}

class Pagos {

    public static void pagar(Empleado empleado) {
        System.out.println("Pagando a " + empleado.nombre());
        switch (empleado) {
            case Fijo(var nombre, _) when nombre.contains("Pepe") -> {
                System.out.println("Pago de " + 50000 + " a " + nombre);
            }
            case Fijo(String nombre, _) -> {
                System.out.println("Pago de " + 5000 + " a " + nombre);
            }
            case Autonomo(var nombre, var edad) when edad >= 50 -> {
                System.out.println("Pago de " + 8000 + " a " + nombre + " con edad " + edad);
            }
            case Autonomo(var nombre, var edad) -> {
                System.out.println("Pago de " + 4000 + " a " + nombre + " con edad " + edad);
            }
            case Becario becario -> {
                System.out.println("Pago de " + 15000 + " a " + becario.nombre());
            }
            case MedioTiempo medioTiempo -> {
                System.out.println("Pago de " + 7000 + " a " + medioTiempo.nombre());
            }
            case TiempoExtra tiempoExtra -> {
                System.out.println("Pago de " + 10000 + " a " + tiempoExtra.nombre());
            }
        }
    }

}

public class SistemaEmpresa {

    public static void main(String[] args) {
        var fijo = new Fijo("Pepe Fijo", 50);
        var autonomo = new Autonomo("María Autonoma", 20);
        var becario = new Becario("Andrés Becario", 25);
        var medioTiempo = new MedioTiempo("Susana Medio Tiempo", 40);
        var tiempoExtra = new TiempoExtra("Juanita Tiempo Extra", 30);
        Pagos.pagar(fijo);
        Pagos.pagar(autonomo);
        Pagos.pagar(becario);
        Pagos.pagar(medioTiempo);
        Pagos.pagar(tiempoExtra);
    }

}
