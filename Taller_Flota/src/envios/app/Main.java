package envios.app;

import java.util.ArrayList;
import envios.modelo.*;
/**
 *
 * @author kiara
 */
public class Main {
    public static void main(String[] args) {
        Moto m1 = new Moto("MZL12A", 20, 150);
        Camion c1 = new Camion("WFT345", 8000, 2);
        Moto m2 = new Moto("KJH78B", 25, 200);

        Flota flota = new Flota("Envios Caldas");
        flota.agregar(m1);
        flota.agregar(c1);
        flota.agregar(m2);

        System.out.println(flota.agregar(m1));
        flota.mostrar();
        System.out.println(flota.cantidadCamiones());

        System.out.println(m1.costoEnvio(12));
        System.out.println(c1.costoEnvio(12));

        Bicicleta b1 = new Bicicleta("BIC001", 10);
        flota.agregar(b1);
        flota.mostrar();

        Vehiculo v8 = flota.masEconomico(8);
        Vehiculo v22 = flota.masEconomico(22);
        Vehiculo v500 = flota.masEconomico(500);
        Vehiculo v9000 = flota.masEconomico(9000);

        System.out.println(v8 == null ? null : v8.getPlaca());
        System.out.println(v22 == null ? null : v22.getPlaca());
        System.out.println(v500 == null ? null : v500.getPlaca());
        System.out.println(v9000 == null ? null : v9000.getPlaca());

        System.out.println(m1.valorSeguro());
        System.out.println(c1.valorSeguro());
        System.out.println(flota.totalSeguros());

        ArrayList<Asegurable> asegurables = new ArrayList<Asegurable>();
        asegurables.add(c1);
        asegurables.add(new Bodega("Bodega Chipre", 300));

        double suma = 0;
        for (Asegurable a : asegurables) {
            System.out.println(a.valorSeguro());
            suma = suma + a.valorSeguro();
        }
        System.out.println(suma);

        // Reto 3: se conserva el tipo de la variable como Vehiculo.
        Vehiculo w = c1;
        if (w instanceof Camion) {
            Camion camion = (Camion) w;
            System.out.println(camion.getEjes());
        }

        // Reto 4: costo normal y costo urgente.
        System.out.println(c1.costoEnvio(10, true));
        System.out.println(c1.costoEnvio(10, false));

        // Reto 6: prediccion de salida.
        Vehiculo v = new Moto("AAA11A", 20, 100);
        System.out.println(v.describir());
        System.out.println(v.costoEnvio(10));
        System.out.println(v instanceof Asegurable);
        System.out.println(v instanceof Camion);
        Asegurable a = new Bodega("Bodega Norte", 50);
        System.out.println(a.valorSeguro());
    }
}
