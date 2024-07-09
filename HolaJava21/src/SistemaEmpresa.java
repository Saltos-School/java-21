enum TipoEmpleado {
    FIJO,
    AUTONOMO,
    BECARIO,
    MEDIO_TIEMPO,
    TIEMPO_EXTRA
}

interface Empleado {
    String nombre();
    TipoEmpleado tipoEmpleado();
}

class Fijo implements Empleado {
    public String nombre() {
        return "Pepe Fijo";
    }

    @Override
    public TipoEmpleado tipoEmpleado() {
        return TipoEmpleado.FIJO;
    }
}

class Autonomo implements Empleado {
    public String nombre() {
        return "María Autonoma";
    }

    @Override
    public TipoEmpleado tipoEmpleado() {
        return TipoEmpleado.AUTONOMO;
    }
}

class Becario implements Empleado {
    public String nombre() {
        return "Andrés Becario";
    }

    @Override
    public TipoEmpleado tipoEmpleado() {
        return TipoEmpleado.BECARIO;
    }
}

class MedioTiempo implements Empleado {
    public String nombre() {
        return "Susana Medio Tiempo";
    }

    @Override
    public TipoEmpleado tipoEmpleado() {
        return TipoEmpleado.MEDIO_TIEMPO;
    }
}

class Pagos {

    public static int calcularMontoAPagar(TipoEmpleado tipoEmpleado) {
        return switch (tipoEmpleado) {
            case FIJO -> 5000;
            case AUTONOMO -> 4000;
            case BECARIO -> 15000;
            case MEDIO_TIEMPO -> 7000;
            case TIEMPO_EXTRA -> 20000;
        };
    }

    public static void pagar(Empleado empleado) {
        System.out.println("Pagando a " + empleado.nombre());
        switch (empleado.tipoEmpleado()) {
            case FIJO -> {
                var fijo = (Fijo) empleado;
                System.out.println("Pago de " + 5000 + " a " + fijo.nombre());
            }
            case AUTONOMO -> {
                var autonomo = (Autonomo) empleado;
                System.out.println("Pago de " + 4000 + " a " + autonomo.nombre());
            }
            case BECARIO -> {
                var becario = (Becario) empleado;
                System.out.println("Pago de " + 15000 + " a " + becario.nombre());
            }
            case MEDIO_TIEMPO -> {
                var medioTiempo = (MedioTiempo) empleado;
                System.out.println("Pago de " + 7000 + " a " + medioTiempo.nombre());
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
        Pagos.pagar(fijo);
        Pagos.pagar(autonomo);
        Pagos.pagar(becario);
        Pagos.pagar(medioTiempo);
    }

}
