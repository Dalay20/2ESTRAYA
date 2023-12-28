


package Clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.lang.ProcessHandle.Info;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class TresR {

    private JFrame frame;

    /**
     * Lanzador de la aplicación tres en raya
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    final TresR tr = new TresR();
                    tr.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor
     */
    public TresR() {

        //Inicializamos entorno grafico
        inicializaPantalla();
    }

    private void inicializaPantalla() {

        //Definimos la pantalla del juego
        frame = new JFrame();
        frame.setBackground(SystemColor.control);
        frame.getContentPane().setBackground(SystemColor.control);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //Definimos el contenedor del tablero
        final JPanel cajaTablero = new JPanel();
        cajaTablero.setBounds(12, 71, 756, 471);
        cajaTablero.setBackground(SystemColor.control);
        frame.getContentPane().add(cajaTablero);
        cajaTablero.setLayout(new BorderLayout(0, 0));

        //Definimos la barra de menú
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.control);
        menuBar.setBounds(0, 0, 780, 21);
        frame.getContentPane().add(menuBar);

        //Definimos el menú Juego
        final JMenu mJuego = new JMenu("Juego");
        final JMenuItem smEmpezar = new JMenuItem("Empezar");
        final JMenuItem smSalir = new JMenuItem("Salir");
        mJuego.add(smEmpezar);
        mJuego.add(smSalir);
        menuBar.add(mJuego);

        //Definimos el menú ayuda
        final JMenu mAyuda = new JMenu("Ayuda");
        final JMenuItem smInfo = new JMenuItem("Info");
        mAyuda.add(smInfo);
        menuBar.add(mAyuda);

        //Definimos la acción de la opción de menú Empezar
        smEmpezar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                //Pintamos el tablero
                final Tablero pTablero = new Tablero();
                cajaTablero.removeAll();
                cajaTablero.add(pTablero);
                frame.setVisible(true);
            }
        });

        //Definimos la acción de la opción de menú Salir
        smSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                //Salimos del juego
                System.exit(0);
            }
        });

        //Definimos la acción de la opción de menú info
        smInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                //Pintamos la pantalla de ayuda
                final Info pInfo = new Info() {
                    @Override
                    public Optional<String> command() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public Optional<String> commandLine() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public Optional<String[]> arguments() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public Optional<Instant> startInstant() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public Optional<Duration> totalCpuDuration() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public Optional<String> user() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
                cajaTablero.removeAll();
                cajaTablero.add((PopupMenu) pInfo);
                frame.setVisible(true);
            }
        });
    }
}