package ec.edu.espol.juego1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {

    @FXML
    private AnchorPane lblPerdidos;
    @FXML
    private Label lblEstado;
    @FXML
    private Label f1;
    @FXML
    private Label f2;
    @FXML
    private Label f3;
    @FXML
    private Label f4;
    @FXML
    private Label f5;
    @FXML
    private Label f6;
    @FXML
    private Label f7;
    @FXML
    private Label f8;
    @FXML
    private Label f9;
    @FXML
    private Label Tablero;
    @FXML
    private Label lblGanados;
    @FXML
    private Label lblEmpatados;
    @FXML
    private Label lblIcono;
    @FXML
    private Label lblGanados2;
    @FXML
    private Label lblPerdidos2;
    @FXML
    private Label lblEmpatados2;
    @FXML
    private Label lblIcono2;
    @FXML
    private Label lblPlayer;
    @FXML
    private Label lblPlayer2;
    @FXML
    private Button mnuIniciar;
    @FXML
    private Button mnuSuspender;
    @FXML
    private Button mnuEstadisticas;
    @FXML
    private Label Fondo;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
