/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriav4;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
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
    private Button bTicket;
    @FXML
    private Button bCargarPrecios;
    private ImageView iv1;
    private Image imagen;
    @FXML
    private Label lImagen;
    @FXML
    private Button bLimpiar;

    public PizzaController() {
        this.iv1 = new ImageView();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File sonido = new File("src/Sonidos/pizza.mp3");
        final AudioClip cancion = new AudioClip(sonido.toURI().toString());
        cancion.play();
        inicializar();
    }

    private void inicializar() {
        this.iv1 = new ImageView();
        FileChooser fileChooser = new FileChooser();
        Window ventana = null;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion sobre precios");
        alert.setContentText("Seleccione una carta de precios, en caso contrario se cargaran unos precios predeterminados.");
        alert.showAndWait();
        File ticketGener = fileChooser.showOpenDialog(ventana);
        pizza.cargarPrecios(ticketGener);
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
    private void tipoPizza(ActionEvent event) throws MalformedURLException, IOException {
        String tipo = cbTipoPizza.getValue();
        if (tipo != null) {
            if (tipo.equalsIgnoreCase("Basica")) {
                File imagenArchivo = new File("src/Imagenes/pizzaBasica.jpg");
                imagen = new Image(imagenArchivo.toURI().toString());//me aseguro que la direccion sea correcta
                iv1 = new ImageView(imagen);
                lImagen.setGraphic(iv1);
                iv1.setFitHeight(300);
                iv1.setFitWidth(150);
                iv1.setPreserveRatio(true);
                pizza.setTipo("Basica");
            }
            if (tipo.equalsIgnoreCase("Mexicana")) {
                File imagenArchivo = new File("src/Imagenes/pizzaMexicana.jpg");
                imagen = new Image(imagenArchivo.toURI().toString());//me aseguro que la direccion sea correcta
                iv1 = new ImageView(imagen);
                lImagen.setGraphic(iv1);
                iv1.setFitHeight(300);
                iv1.setFitWidth(150);
                iv1.setPreserveRatio(true);
                pizza.setTipo("Mexicana");
            }
            if (tipo.equalsIgnoreCase("Cuatro Quesos")) {
                File imagenArchivo = new File("src/Imagenes/pizzaCuatroQuesos.jpg");
                imagen = new Image(imagenArchivo.toURI().toString());//me aseguro que la direccion sea correcta
                iv1 = new ImageView(imagen);
                lImagen.setGraphic(iv1);
                iv1.setFitHeight(300);
                iv1.setFitWidth(150);
                iv1.setPreserveRatio(true);
                pizza.setTipo("Cuatro Quesos");
            }
            if (tipo.equalsIgnoreCase("Barbacoa")) {
                File imagenArchivo = new File("src/Imagenes/pizzaBarbacoa.jpg");
                imagen = new Image(imagenArchivo.toURI().toString());//me aseguro que la direccion sea correcta
                iv1 = new ImageView(imagen);
                lImagen.setGraphic(iv1);
                iv1.setFitHeight(300);
                iv1.setFitWidth(150);
                iv1.setPreserveRatio(true);
                pizza.setTipo("Barbacoa");
            }
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
        pizza.setConjIngredientes(ingredientesSeleccionados);
        taComposicion.setText(pizza.composicion());
    }

    @FXML
    private void generarTicket(ActionEvent event) throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Window ventana = null;
        File ticketGener = directoryChooser.showDialog(ventana);
        pizza.generarTicket(ticketGener);
    }

    @FXML
    private void cargarPrecios(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Window ventana = null;
        File ticketGener = fileChooser.showOpenDialog(ventana);
        pizza.cargarPrecios(ticketGener);
        cargaDatos();
    }

    @FXML
    private void Limpiar(ActionEvent event) {
        taComposicion.setText("");
    }

}
