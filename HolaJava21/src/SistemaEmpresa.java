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
        if (empleado instanceof Fijo fijo) {
            System.out.println("Pago de " + 5000 + " a " + fijo.nombre());
        } else if (empleado instanceof Autonomo autonomo) {
            System.out.println("Pago de " + 4000 + " a " + autonomo.nombre());
        } else if (empleado instanceof Becario becario) {
            System.out.println("Pago de " + 15000 + " a " + becario.nombre());
        } else {
            throw new IllegalArgumentException(
                    "Tipo de empleado no soportado " + empleado.getClass().getSimpleName());
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
