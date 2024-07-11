import java.util.Optional;

record Punto(int x, int y) {

    Punto {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Solo se aceptan coordenadas positivas");
        }
    }

    Punto() {
        this(0, 0);
    }

    double distancia(Punto otro) {
        return Math.sqrt(
                Math.pow(this.x - otro.x, 2) +
                        Math.pow(this.y - otro.y, 2));
    }
}

public class HolaRegistros {

    static double distancia(Punto p1, Punto p2) {
        return Math.sqrt(
                Math.pow(p1.x() - p2.x(), 2) +
                        Math.pow(p1.y() - p2.y(), 2));
    }

    public static void main(String[] args) {
        var origen = new Punto();
        var punto = new Punto(10, 20);
        System.out.println(origen);
        System.out.println(punto);
        System.out.printf("Origen %d, %d\n", origen.x(), origen.y());
        System.out.printf("Punto %d, %d\n", punto.x(), punto.y());
        System.out.printf("Distancia al origen %s\n", punto.distancia(origen));
        System.out.printf("Distancia al origen %s\n", distancia(punto, origen));

        var PUNTO = StringTemplate.Processor.of(
                (StringTemplate st) -> {
                    var cadena = st.interpolate();
                    var partes = cadena.split(" ");
                    if (partes.length != 2) {
                        throw new IllegalArgumentException("Formato inválido");
                    }
                    try {
                        var x = Integer.parseInt(partes[0].trim());
                        var y = Integer.parseInt(partes[1].trim());
                        return new Punto(x, y);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Las coordenadas del punto tienen que ser numeros enteros");
                    }
                }
        );

        var puntoNuevo = PUNTO."20 30";
        System.out.println(puntoNuevo);

    }

}
