/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kokekui
 */
public class Precio {

    private Map<String, Double> precioTiposPizzas = new HashMap<>();
    private Map<String, Double> precioMasa = new HashMap<>();
    private Map<String, Double> precioIngrediente = new HashMap<>();

    public Precio() {
        cargaMasa();
        cargaIngredientes();
        cargaTipoPizzas();
    }

    private void cargaMasa() {
        precioMasa.put("Normal", 9.00);
        precioMasa.put("Integral", 9.50);
    }

    private  void cargaIngredientes() {
        precioIngrediente.put("Queso", 0.5);
        precioIngrediente.put("Jamon", 0.75);
        precioIngrediente.put("Tomate", 1.5);
        precioIngrediente.put("Cebolla", 2.5);
        precioIngrediente.put("Oliva", 1.0);
    }

    private  void cargaTipoPizzas() {
        precioTiposPizzas.put("Basica", 3.00);
        precioTiposPizzas.put("Mexicana", 7.00);
        precioTiposPizzas.put("Barbacoa", 8.50);
        precioTiposPizzas.put("Cuatro Quesos", 5.00);
    }

    public double precioIngrediente(String ingrediente) {
        double precio = precioIngrediente.get(ingrediente);
        return precio;
    }

    public Map<String, Double> getPrecioTiposPizzas() {
        return precioTiposPizzas;
    }

    public void setPrecioTiposPizzas(Map<String, Double> precioTiposPizzas) {
        this.precioTiposPizzas = precioTiposPizzas;
    }

    public Map<String, Double> getPrecioMasa() {
        return precioMasa;
    }

    public void setPrecioMasa(Map<String, Double> precioMasa) {
        this.precioMasa = precioMasa;
    }

    public Map<String, Double> getPrecioIngrediente() {
        return precioIngrediente;
    }

    public void setPrecioIngrediente(Map<String, Double> precioIngrediente) {
        this.precioIngrediente = precioIngrediente;
    }
}
