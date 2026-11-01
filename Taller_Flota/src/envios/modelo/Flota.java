package envios.modelo;

import java.util.ArrayList;
/**
 *
 * @author kiara
 */
public class Flota {
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Flota(String nombre) {
        this.nombre = nombre;
        vehiculos = new ArrayList<Vehiculo>();
    }

    public boolean agregar(Vehiculo vehiculo) {
        if (vehiculo == null || vehiculos.contains(vehiculo)) {
            return false;
        }

        vehiculos.add(vehiculo);
        return true;
    }

    public void mostrar() {
        System.out.println(nombre + ":");
        for (Vehiculo v : vehiculos) {
            System.out.println("- " + v.describir());
        }
    }

    public int cantidadCamiones() {
        int cantidad = 0;
        for (Vehiculo v : vehiculos) {
            if (v instanceof Camion) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Vehiculo masEconomico(int pesoKg) {
        Vehiculo economico = null;

        for (Vehiculo v : vehiculos) {
            if (v.getCapacidadKg() >= pesoKg) {
                if (economico == null ||
                    v.tarifaPorKm() < economico.tarifaPorKm()) {
                    economico = v;
                }
            }
        }
        return economico;
    }

    public double totalSeguros() {
        double total = 0;

        for (Vehiculo v : vehiculos) {
            if (v instanceof Asegurable) {
                Asegurable asegurable = (Asegurable) v;
                total = total + asegurable.valorSeguro();
            }
        }
        return total;
    }
}
