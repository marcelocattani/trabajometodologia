/*
 * Ventana principal 
 */
package matrices;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Cattani
 * @version 1
 */
public class VentanaPrincipal extends JFrame {

    public JPanel panel;
    public Font fuente1, fuenteLink, fuenteNormal;
    public JTextField cajaCantidad;
    public JTable tabla;
    public JButton btn_crear, btn_analizar, btn_reset;
    public JLabel encabezado, aleatorio;
    public JRadioButton binario, decimal;
    public ButtonGroup grupo;
    public final int TIPO_DECIMAL = 0;
    public final int TIPO_BINARIO = 1;
    public int tipo;

    public VentanaPrincipal() {

        //Instanciación de Objetos Globales
        panel = new JPanel();
        fuente1 = new Font("Arial", Font.BOLD, 20);
        fuenteLink = new Font("Arial", Font.ITALIC, 15);
        fuenteNormal = new Font("Arial", Font.PLAIN, 15);
        tabla = new JTable();
        grupo = new ButtonGroup();

        //Propiedades de la ventana
        this.setSize(1000, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Trabajo Grupal De Metodologìa");

        //Colocación de Objetos
        colocarPanel();
        colocarJButton();
        colocarTextField();
        colocarJLabel();
        colocarRadioButton();
    }

    private void colocarRadioButton() {

        //boton binario
        binario = new JRadioButton("Binario", false);
        binario.setFont(fuenteNormal);
        binario.setSize(75, 25);
        binario.setLocation(440, 110);
        binario.setBackground(panel.getBackground());
        binario.setForeground(Color.white);
        binario.setEnabled(false);

        //Boton Decimal
        decimal = new JRadioButton("Decimal", true);
        decimal.setFont(fuenteNormal);
        decimal.setSize(80, 25);
        decimal.setLocation(360, 110);
        decimal.setBackground(panel.getBackground());
        decimal.setForeground(Color.white);
        decimal.setEnabled(false);

        //Agrupar Botones
        grupo.add(binario);
        grupo.add(decimal);

        //ACCION 
        MouseListener seleccionarDecimal = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipo = TIPO_DECIMAL;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                tipo = TIPO_DECIMAL;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        MouseListener seleccionarBinario = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipo = TIPO_BINARIO;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                tipo = TIPO_BINARIO;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        //Agregar Escuchadores
        decimal.addMouseListener(seleccionarDecimal);
        binario.addMouseListener(seleccionarBinario);

        //Colocación
        panel.add(binario);
        panel.add(decimal);
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        this.getContentPane().add(panel);

    }

    private void colocarJLabel() {
        //Etiqueta Encabezado
        encabezado = new JLabel("Analisis Matricial", JLabel.CENTER);
        encabezado.setLocation(0, 0);
        encabezado.setSize(this.getWidth(), 40);
        encabezado.setFont(new Font("Arial Black", Font.ITALIC, 20));
        encabezado.setForeground(Color.WHITE);
        encabezado.setOpaque(true);
        encabezado.setBackground(Color.BLACK);

        //aleatorio
        aleatorio = new JLabel("Llenar aleatoriamente");
        aleatorio.setLocation(200, 110);
        aleatorio.setFont(fuenteLink);
        aleatorio.setSize(150, 25);
        aleatorio.setEnabled(false);
        aleatorio.setForeground(Color.white);

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                llenadoAleatorio();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aleatorio.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aleatorio.setForeground(Color.white);
            }
        };

        aleatorio.addMouseListener(mouseListener);

        //Agregar etiquetas al penel
        panel.add(encabezado);
        panel.add(aleatorio);
    }

    private void colocarJButton() {

        //Instanciación del boton calcular
        btn_crear = new JButton("CREAR");
        btn_crear.setFont(fuente1);
        btn_crear.setBounds(200, 50, 150, 50);

        //Instanciación boton Analizar
        btn_analizar = new JButton("Analizar");
        btn_analizar.setFont(fuente1);
        btn_analizar.setBounds(380, 50, 150, 50);
        btn_analizar.setEnabled(false);

        //Instanciación boton reset
        btn_reset = new JButton();

        //ImageIcon reset = new ImageIcon("\reset.png");
        ImageIcon reset = new ImageIcon(getClass().getResource("/imagenes/reset.png"));
        btn_reset.setLocation(900, 50);
        btn_reset.setSize(50, 50);
        btn_reset.setOpaque(false);

        btn_reset.setIcon(new ImageIcon(reset.getImage().getScaledInstance(btn_reset.getWidth(), btn_reset.getHeight(), Image.SCALE_SMOOTH)));

        //agregar al Panel
        panel.add(btn_crear);
        panel.add(btn_analizar);
        panel.add(btn_reset);

        //Acciones
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(cajaCantidad.getText());
                if (n < 2 || n > 12) {
                    JOptionPane.showMessageDialog(null, "ingrese valores entre 2 y 12");
                    habilitarElementos(false);
                    colocarJTable(0);
                } else {
                    colocarJTable(n);
                    habilitarElementos(true);
                }
                panel.repaint();
            }
        };
        ActionListener oyenteReset = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitarElementos(false);
                colocarJTable(0);
            }
        };

        //Agregar escuchadores
        btn_crear.addActionListener(oyente);
        btn_reset.addActionListener(oyenteReset);
    }

    private void colocarTextField() {
        cajaCantidad = new JTextField("12");
        cajaCantidad.setBounds(25, 50, 150, 50);
        cajaCantidad.setFont(fuente1);
        //agregar al panel
        panel.add(cajaCantidad);
    }

    private void colocarJTable(int tamaño) {

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(tamaño);
        model.setColumnCount(tamaño);

        tabla.setSize(tamaño * 75, tamaño * 25);//Denifir el tamaño de la tabla
        tabla.setRowHeight(25);
        tabla.setLocation(25, 150); //Localización de la Tabla

        //Agregamos a panel
        panel.add(tabla);

    }

    private void habilitarElementos(boolean enabled) {
        btn_analizar.setEnabled(enabled);
        aleatorio.setEnabled(enabled);
        binario.setEnabled(enabled);
        decimal.setEnabled(enabled);

    }

    private void llenadoAleatorio() {
        int limite = 0;
        if (tipo == TIPO_BINARIO) {
            limite = 2;
        } else if (tipo == TIPO_DECIMAL) {
            limite = 100;
        }

        Random numero = new Random();

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            for (int j = 0; j < tabla.getRowCount(); j++) {
                tabla.setValueAt(numero.nextInt(limite), i, j);
            }
        }
    }
}
