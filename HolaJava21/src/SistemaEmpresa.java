interface Empleado {
    String nombre();
}

class Fijo implements Empleado {
    public String nombre() {
        return "Pepe Fijo";
    }
}

class Autonomo implements Empleado {
    public String nombre() {
        return "María Autonoma";
    }
}

class Pagos {

    public static void pagar(Empleado empleado) {
        System.out.println("Pagando a " + empleado.nombre());
        if (empleado instanceof Fijo) {
            var fijo = (Fijo) empleado;
            System.out.println("Pago de " + 5000 + " a " + fijo.nombre());
        } else if (empleado instanceof Autonomo) {
            var autonomo = (Autonomo) empleado;
            System.out.println("Pago de " + 4000 + " a " + autonomo.nombre());
        }
    }

}

public class SistemaEmpresa {

    public static void main(String[] args) {
        var fijo = new Fijo();
        var autonomo = new Autonomo();
        Pagos.pagar(fijo);
        Pagos.pagar(autonomo);
    }

}
