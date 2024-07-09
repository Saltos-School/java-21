enum TipoEmpleado {
    FIJO,
    AUTONOMO,
    BECARIO
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

class Pagos {

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
        }
    }

}

public class SistemaEmpresa {

    public static void main(String[] args) {
        var fijo = new Fijo();
        var autonomo = new Autonomo();
        var becario = new Becario();
        Pagos.pagar(fijo);
        Pagos.pagar(autonomo);
        Pagos.pagar(becario);
    }

}
