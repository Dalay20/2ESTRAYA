
package Clases;

//import java.awt.Button;


import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Tablero extends JPanel implements ActionListener {

    private static final long serialVersionUID = -6025639950351265124L;
   
    //Botonera que representa el tablero
    final Button botonesCasillas[][] = new Button[3][3];
    //Estructura de memoria con las casillas del juego
    int matrizTablero[][] = new int[3][3];
    //Implementación del algoritmo minimax
    final MiniMax minimax;
    //Indicador de turno de jugador
    boolean turnoHumano;

    /**
     * Constructor del panel
     */
    public Tablero() {

        //Define el contenido del panel
        setBackground(UIManager.getColor("info"));
        setLayout(new GridLayout(3, 3, 0, 0));
        for (int i=0; i<3; i++) {
            for (int j=0; j <3; j++) {
                botonesCasillas[i][j] = new Button();
                botonesCasillas[i][j].setBackground(SystemColor.control);
                botonesCasillas[i][j].setFont(new Font("Arial",Font.BOLD,60));
                botonesCasillas[i][j].addActionListener(this);
                this.add(botonesCasillas[i][j]);
            }
        }

        //Inicializamos variables de la partida
        turnoHumano = true;

        //Limpia los botones del tablero
        limpiaBotones();

        //Iniciamos el minimax
        minimax = new MiniMax(3,3);
    }

    /**
     * Interprete de las acciones del usuario.
     */
    public void actionPerformed(ActionEvent e){

        //Movimiento decidido por el ordenador
        Movimiento mov;
       
        //Si el turno era del humano
        if(turnoHumano==true){

            //Quitamos el turno al humano
            turnoHumano = false;
           
            //Revisa qué casilla ha pulsado
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {

                    //Mira si la casilla pulsada por el humaon estaba libre
                    if ((e.getSource()==botonesCasillas[i][j]) && (botonesCasillas[i][j].getLabel().equals(""))){

                        //Pone en la casilla una P
                        botonesCasillas[i][j].setLabel("P");
                        matrizTablero[i][j] = MiniMax.CASILLA_PERSONA;
                       
                        //Lanza el algoritmo minimax y recoge el movimiento elegido
                        mov = minimax.minimax(matrizTablero);
                        if (mov.getPosX()!=-1 && mov.getPosY()!=-1) {

                            //Introducimos un retardo
                            retarda(500);
                           
                            //Dibujamos el movimiento del ordenador
                            botonesCasillas[mov.getPosX()][mov.getPosY()].setLabel("O");
                            matrizTablero[mov.getPosX()][mov.getPosY()]=MiniMax.CASILLA_ORDENADOR;
                           
                            //Si hay ganador quito el turno al humano para que no pueda mover mas
                            if(minimax.haGanadoJugador(MiniMax.CASILLA_PERSONA)) {
                                turnoHumano=false;
                                JOptionPane.showMessageDialog(null, "ME HAS GANADO");
                            } else if (minimax.haGanadoJugador(MiniMax.CASILLA_ORDENADOR)) {
                                turnoHumano = false;
                                JOptionPane.showMessageDialog(null, "JE JE JE, SIEMPRE GANO YO...");
                            } else {
                                turnoHumano = true;
                            }
                           
                        } else {
                            turnoHumano = false;
                            JOptionPane.showMessageDialog(null, "HEMOS VUELTO A EMPATAR");
                        }
                    }
                }
            }
        }
    }

    private void retarda(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
   
    /**
     * Limpia los botones del tablero
     */
    private void limpiaBotones(){
        for (int i=0; i<3; i++) {
            for (int j=0; j <3; j++) {
                botonesCasillas[i][j].setLabel("");
            }
        }
    }
}