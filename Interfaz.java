//Se importan el paquete y la biblioteca necesaria//
package Ventana;
import java.awt.Image;
import java.awt.Toolkit;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
//Icono que se ve durante la ejecución de la aplicación
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono.png"));
        return retValue;
    }

    private void initComponents() {
//Se definen los botones, y los label (se utilizó el JButton y JLabel)//
        SingleButton = new javax.swing.JButton();
        MultiplayerButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//Se define el color, tamaño, fondo y ubicación de los botones en la interfaz//
        SingleButton.setBackground(new java.awt.Color(0, 0, 0));
        SingleButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        SingleButton.setForeground(new java.awt.Color(255, 255, 51));
        SingleButton.setText("Unico");
        SingleButton.addMouseListener(new java.awt.event.MouseAdapter() {
//Capta la pulsación del "mouse"
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SingleButtonMouseClicked(evt);
            }
        });
        getContentPane().add(SingleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 693, 200, 40));
//Definición del botón del multijugador//
        MultiplayerButton.setBackground(new java.awt.Color(0, 0, 0));
        MultiplayerButton.setFont(new java.awt.Font("Tahoma", 3, 14));
        MultiplayerButton.setForeground(new java.awt.Color(102, 255, 102));
        MultiplayerButton.setText("Multijugador");
        MultiplayerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MultiplayerButtonMouseClicked(evt);
            }
        });
        getContentPane().add(MultiplayerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 690, 160, 40));
//Definición del botón de salida//
        ExitButton.setBackground(new java.awt.Color(0, 0, 0));
        ExitButton.setFont(new java.awt.Font("Tahoma", 3, 14));
        ExitButton.setForeground(new java.awt.Color(0, 255, 255));
        ExitButton.setText("Salir");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 690, 100, 40));
//Define en el Label la ubicación de la imagen logo (TRON)//
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.jpg")));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(255, 255, 51));
        jLabelFondo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }
//Define los eventos de los respectivos botones//
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void MultiplayerButtonMouseClicked(java.awt.event.MouseEvent evt) {
Multijugador multijugador = new Multijugador ();
multijugador.setVisible(true);
this.dispose();//
    }
    private void SingleButtonMouseClicked(java.awt.event.MouseEvent evt) {
VentanaJuego ventanajuego = new VentanaJuego ();
ventanajuego.setVisible(true);
VentanaJuego Grid = new VentanaJuego();
Grid.setVisible(true);
this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

//Declaración de variables//
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton MultiplayerButton;
    private javax.swing.JButton SingleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
}
