sealed interface Empleado permits Fijo, Autonomo, Becario, MedioTiempo, TiempoExtra {
    String nombre();
}

final class Fijo implements Empleado {
    public String nombre() {
        return "Pepe Fijo";
    }
}

final class Autonomo implements Empleado {
    public String nombre() {
        return "María Autonoma";
    }
}

final class Becario implements Empleado {
    public String nombre() {
        return "Andrés Becario";
    }
}

final class MedioTiempo implements Empleado {
    public String nombre() {
        return "Susana Medio Tiempo";
    }
}

final class TiempoExtra implements Empleado {
    public String nombre() {
        return "Juanita Tiempo Extra";
    }
}

class Pagos {

    public static void pagar(Empleado empleado) {
        System.out.println("Pagando a " + empleado.nombre());
        switch (empleado) {
            case Fijo fijo -> {
                System.out.println("Pago de " + 5000 + " a " + fijo.nombre());
            }
            case Autonomo autonomo -> {
                System.out.println("Pago de " + 4000 + " a " + autonomo.nombre());
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
        var fijo = new Fijo();
        var autonomo = new Autonomo();
        var becario = new Becario();
        var medioTiempo = new MedioTiempo();
        var tiempoExtra = new TiempoExtra();
        Pagos.pagar(fijo);
        Pagos.pagar(autonomo);
        Pagos.pagar(becario);
        Pagos.pagar(medioTiempo);
        Pagos.pagar(tiempoExtra);
    }

}
