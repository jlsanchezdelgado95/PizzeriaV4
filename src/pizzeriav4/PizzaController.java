/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriav4;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import modelo.Pizza;

/**
 *
 * @author Kokekui
 */
public class PizzaController implements Initializable {

    Pizza pizza = new Pizza();
    @FXML
    private RadioButton rbNormal;
    @FXML
    private RadioButton rbIntegral;
    @FXML
    private ComboBox<String> cbTipoPizza;
    @FXML
    private Spinner<String> sTamaño;
    @FXML
    private ToggleGroup masa;
    @FXML
    private TextArea taComposicion;
    List<String> listaIngredientesController = FXCollections.observableArrayList(pizza.getPrecioPizza().getPrecioIngrediente().keySet());
    @FXML
    private CheckBox cBox1;
    @FXML
    private CheckBox cBox2;
    @FXML
    private CheckBox cBox3;
    @FXML
    private CheckBox cBox4;
    @FXML
    private CheckBox cBox5;
    @FXML
    private Button bTicket;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargaDatos();
    }

    private void cargaDatos() {
        ObservableList<String> tamanyos = FXCollections.observableArrayList(
                "Pequeña", "Mediana", "Familiar");
        ListSpinnerValueFactory<String> valores = new SpinnerValueFactory.ListSpinnerValueFactory<>(tamanyos);
        sTamaño.setValueFactory(valores);
        cbTipoPizza.setItems(FXCollections.observableArrayList(pizza.getPrecioPizza().getPrecioTiposPizzas().keySet()));
        cBox1.setUserData(listaIngredientesController.get(0));
        cBox2.setUserData(listaIngredientesController.get(1));
        cBox3.setUserData(listaIngredientesController.get(2));
        cBox4.setUserData(listaIngredientesController.get(3));
        cbTipoPizza.getSelectionModel().selectFirst();
        rbNormal.setSelected(true);
    }

    @FXML
    private void masa(ActionEvent event) {
        if (rbNormal.isSelected()) {
            rbNormal.setSelected(true);
            pizza.setMasa("Normal");
            taComposicion.setText(pizza.composicion());
        }
        if (rbIntegral.isSelected()) {
            rbIntegral.setSelected(true);
            pizza.setMasa("Integral");
            taComposicion.setText(pizza.composicion());
        }
    }

    @FXML
    private void tipoPizza(ActionEvent event) {
        String tipo = cbTipoPizza.getValue();
        if (tipo.equalsIgnoreCase("Basica")) {
            pizza.setTipo("Basica");
        }
        if (tipo.equalsIgnoreCase("Mexicana")) {
            pizza.setTipo("Mexicana");
        }
        if (tipo.equalsIgnoreCase("Cuatro Quesos")) {
            pizza.setTipo("Cuatro Quesos");
        }
        if (tipo.equalsIgnoreCase("Barbacoa")) {
            pizza.setTipo("Barbacoa");
        }
        taComposicion.setText(pizza.composicion());
    }

    @FXML
    private void cambiarTamaño(MouseEvent event) {
        String seleccionado = sTamaño.getValue();
        if (seleccionado.equalsIgnoreCase("Pequeña")) {
            pizza.setTamanyo("Pequeña");
        }
        if (seleccionado.equalsIgnoreCase("Mediana")) {
            pizza.setTamanyo("Mediana");
        }
        if (seleccionado.equalsIgnoreCase("Familiar")) {
            pizza.setTamanyo("Familiar");
        }
        taComposicion.setText(pizza.composicion());
    }

    @FXML
    private void listIngredientes(ActionEvent event) {
        List<String> ingredientesSeleccionados = new ArrayList<>();
        if (cBox1.isSelected()) {
            ingredientesSeleccionados.add(listaIngredientesController.get(0));//Jamon
        } 
        if (cBox2.isSelected()) {
            ingredientesSeleccionados.add(listaIngredientesController.get(1));//Queso
        }
        if (cBox3.isSelected()) {
            ingredientesSeleccionados.add(listaIngredientesController.get(2));//Tomate
        }
        if (cBox4.isSelected()) {
            ingredientesSeleccionados.add(listaIngredientesController.get(3));//Cebolla
        }
        if (cBox5.isSelected()) {
            ingredientesSeleccionados.add(listaIngredientesController.get(4));//Oliva
        }
        pizza.setConjIngredientes(ingredientesSeleccionados);
        taComposicion.setText(pizza.composicion());
    }

    @FXML
    private void generarTicket(ActionEvent event) {
        if (pizza.generarTicket()) {
            System.out.println("Se ha generado correctamente");
        } else {
            System.out.println("No se ha podido generar");
        }
        
        
    }

}
