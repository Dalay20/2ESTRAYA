/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.juego1;

/**
 *
 * @author danie
 * @author Dalay20
 * @author RaulLeon
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ModeloController implements Initializable {

    @FXML
    private TextField txtJugador1;
    @FXML
    private TextField txtJugador2;
    @FXML
    private Label jugador1;
    @FXML
    private Label jugador2;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private RadioButton inip1;
    @FXML
    private RadioButton inipc1;
    @FXML
    private RadioButton inip2;
    @FXML
    private RadioButton inipc2;
    @FXML
    private ImageView imgp1;
    @FXML
    private ImageView imgp2;
    @FXML
    private Button btnCambiarficha;
    public ImageView imagen11;
    public ImageView imagen22;
    private TablaController tabla;  
    private static ModeloController instanciaModelo;
    public final int HOMBREvsHOMBRE = 1;
    public final int HOMBREvsCOMPUTADORA = 2;
    public final int COMPUTADORAvsCOMPUTADORA = 3;
    public String nombre1, nombre2;
    public int tipo_juego = 0;
    public int primerTurno = 0;
    boolean estadoActual = false; 
  
    ModosController modo = ModosController.getInstancia();
    boolean modoPVP = modo.isPvp();
    boolean modoPVI = modo.isPvi();
    boolean modoIVI = modo.isIvi();
    
    public static ModeloController getInstancia() {
        if (instanciaModelo == null) {
            instanciaModelo = new ModeloController();
        }
        return instanciaModelo;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println(modoPVP);
         System.out.println(modoPVI);
         System.out.println(modoIVI);
         initComponents();
         cargarImg();
         
    }  
    
    public ModeloController() {
    }
    
    public void setTablaController(TablaController TablaController) {
        this.tabla = TablaController;
        System.out.println("TABLAController recibido en MODELOController");
    }
    public void cargarImg(){
        imgp1.setImage(new Image(getClass().getResourceAsStream("/images/circulo3.png")));
        imgp2.setImage(new Image(getClass().getResourceAsStream("/images/cruz.png")));
    }
    public boolean recojer(){
            if( (this.txtJugador1.getText().equals("")&& this.txtJugador2.getText().equals(""))&&modoPVP == true){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Llene el nombre de los jugadores por favor.");
                alert.show();
                return false;   
            }
            if( this.txtJugador1.getText().equals("")&& modoPVI == true){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Llene el nombre del jugador 1 por favor.");
                alert.show();
                return false;   
            } 
        
        this.tipo_juego = (modoPVP == true) ? HOMBREvsHOMBRE :
                  (modoIVI == true) ? COMPUTADORAvsCOMPUTADORA:
                  HOMBREvsCOMPUTADORA;
        
        this.nombre1 = this.txtJugador1.getText();
        this.nombre2 = this.txtJugador2.getText();
        if (estadoActual) {
         this.imagen11=new ImageView( new Image(getClass().getResourceAsStream("/images/cruz.png")));
         this.imagen22=new ImageView( new Image(getClass().getResourceAsStream("/images/circulo3.png")));
    } else {
       this.imagen11=new ImageView( new Image(getClass().getResourceAsStream("/images/circulo3.png")));
       this.imagen22=new ImageView( new Image(getClass().getResourceAsStream("/images/cruz.png"))); 
    }
        System.out.println("modifcaa"+this.tipo_juego);
        return true;
    }
      
    public boolean quienempieza(){
        ModeloController modelo = ModeloController.getInstancia();
        System.out.println("El tipo de juego es: " + tipo_juego);
        switch (tipo_juego) {
            case 1:
                if( (!this.inip1.isSelected() && !this.inip2.isSelected() )){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Selecione quien inicia primero por favor.");
                    alert.show();
                    return false;
                }   if(this.inip2.isSelected()){
                    modelo.primerTurno = 2;
                }else{
                    modelo.primerTurno = 1;
                }   break;
            case 2:
                if( (!this.inip1.isSelected() && !this.inipc1.isSelected() )){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Selecione quien inicia primero por favor.");
                    alert.show();
                    return false;
                }   if(this.inip1.isSelected()){
                    modelo.primerTurno = 1;
                }else{
                    modelo.primerTurno = 2;
                }   break;
            case 3:
                if( (!this.inipc1.isSelected() && !this.inipc2.isSelected() )){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Selecione quien inicia primero por favor.");
                    alert.show();
                    return false;
                }   if(this.inipc1.isSelected()){
                    modelo.primerTurno = 1;
                }else{
                    modelo.primerTurno = 2;
                }   break;
            default:
                break;
        }
        return true;
    }
       
    private void initComponents() {
 
            if (modoPVP == true) {
                 hvshActionPerformed();  
               System.out.println("PERSONAVSPERSONA");
            }
          
            if (modoPVI == true) {
                hvpcActionPerformed();  
                System.out.println("PERSONAVSPC");
            }
         
            if (modoIVI == true) {
                pcvpcActionPerformed();  
                System.out.println("PCVSPC");
            }
          
          btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    btnAceptarActionPerformed();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
          
          btnCambiarficha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnCambiarfichaPerformed();  
            }
        });
    
    }
    private void btnCambiarfichaPerformed(){
        estadoActual = !estadoActual;
        if (estadoActual) {
        imgp1.setImage(new Image(getClass().getResourceAsStream("/images/cruz.png")));
        imgp2.setImage(new Image(getClass().getResourceAsStream("/images/circulo3.png")));
    } else {
        imgp1.setImage(new Image(getClass().getResourceAsStream("/images/circulo3.png"))); 
        imgp2.setImage(new Image(getClass().getResourceAsStream("/images/cruz.png"))); 
    }
    }
    
    @FXML
    private void btnCancelar(ActionEvent event) throws IOException {
         ModosController modo = ModosController.getInstancia();
         modo.setPvp(false);
         modo.setPvi(false);
         modo.setIvi(false);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Modos.fxml"));
         Parent root = loader.load();
         Scene scene = new Scene(root, 615, 348);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         stage.show();
     }
    
    private void btnAceptarActionPerformed() throws IOException {                                           
        if( recojer() && quienempieza()){
         enviarModelo();
        }
    }  
   
    private void hvshActionPerformed() {   
        txtJugador2.setDisable(false);
        jugador2.setDisable(false);
        txtJugador1.setDisable(false);
        jugador1.setDisable(false);
        inip2.setDisable(false);
        inipc2.setDisable(true);
        inip1.setDisable(false);
        inipc1.setDisable(true);
       
    } 
    
    private void hvpcActionPerformed() {                                     
        txtJugador2.setDisable(true);
        jugador2.setDisable(true);
        txtJugador1.setDisable(false);
        jugador1.setDisable(false);
        inip2.setDisable(true);
        inipc2.setDisable(true);
        inip1.setDisable(false);
        inipc1.setDisable(false);
    }  
     
     private void pcvpcActionPerformed() {                                     
        txtJugador2.setDisable(true);
        jugador2.setDisable(true);
        txtJugador1.setDisable(true);
        jugador1.setDisable(true);
        inip2.setDisable(true);
        inipc2.setDisable(false);
        inip1.setDisable(true);
        inipc1.setDisable(false);
    }  

   public void enviarModelo() {
    TablaController tablaController = new TablaController();
    tablaController.setModeloController(this);
    abrirVentana(tablaController);
    Stage stage = (Stage) btnAceptar.getScene().getWindow();
    stage.close();
}

    private void abrirVentana(TablaController tablaController) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Tabla.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 761, 499));
            TablaController controller = loader.getController();
            controller.setModeloController(tablaController.getModeloController());
            controller.someMethod(); 
            controller.iniciarJuego();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ModeloController getModeloController() {
        return this;
    }
}
