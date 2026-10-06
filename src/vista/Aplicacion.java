package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import modelo.Cliente;

public class Aplicacion extends JFrame {

    // Array de clientes
    private Cliente[] clientes;

    // Posicion actual del array
    private int posicion = 0;

    // Etiquetas
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

    // Campos de texto
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;

    // Botones
    private JButton anteriorButton;
    private JButton siguienteButton;


    public Aplicacion() {

        super("Gestion de clientes");

        // Cerrar el programa al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // -----------------------------
        // CLIENTES PRECARGADOS
        // -----------------------------

        clientes = new Cliente[3];

        clientes[0] = new Cliente(1, "Luis", 20, 125.5);
        clientes[1] = new Cliente(2, "Maria", 25, 230.0);
        clientes[2] = new Cliente(3, "Carlos", 32, 98.5);


        // -----------------------------
        // CREAR ETIQUETAS
        // -----------------------------

        numeroLabel = new JLabel("Numero: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");
        puntosLabel = new JLabel("Puntos: ");


        // -----------------------------
        // CREAR CAMPOS DE TEXTO
        // -----------------------------

        numeroField = new JTextField(10);
        nombreField = new JTextField(10);
        edadField = new JTextField(10);
        puntosField = new JTextField(10);

        // Solo queremos mostrar datos
        numeroField.setEditable(false);
        nombreField.setEditable(false);
        edadField.setEditable(false);
        puntosField.setEditable(false);


        // -----------------------------
        // BOTONES
        // -----------------------------

        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");


        // -----------------------------
        // EVENTO BOTON ANTERIOR
        // -----------------------------

        anteriorButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (posicion > 0) {

                    posicion--;

                    mostrarCliente();
                    actualizarBotones();
                }
            }
        });


        // -----------------------------
        // EVENTO BOTON SIGUIENTE
        // -----------------------------

        siguienteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (posicion < clientes.length - 1) {

                    posicion++;

                    mostrarCliente();
                    actualizarBotones();
                }
            }
        });


        // -----------------------------
        // PANEL DE ETIQUETAS
        // -----------------------------

        JPanel labelPane = new JPanel();

        labelPane.setLayout(new GridLayout(0, 1));

        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);


        // -----------------------------
        // PANEL DE CAMPOS
        // -----------------------------

        JPanel fieldPane = new JPanel();

        fieldPane.setLayout(new GridLayout(0, 1));

        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);


        // -----------------------------
        // PANEL DE DATOS
        // -----------------------------

        JPanel datosPane = new JPanel();

        datosPane.setLayout(new BorderLayout());

        datosPane.add(labelPane, BorderLayout.CENTER);
        datosPane.add(fieldPane, BorderLayout.EAST);


        // -----------------------------
        // PANEL DE BOTONES
        // -----------------------------

        JPanel botonesPane = new JPanel();

        botonesPane.setLayout(new FlowLayout());

        botonesPane.add(anteriorButton);
        botonesPane.add(siguienteButton);


        // -----------------------------
        // PANEL PRINCIPAL
        // -----------------------------

        JPanel contentPane = new JPanel();

        contentPane.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        contentPane.setLayout(new BorderLayout());

        contentPane.add(datosPane, BorderLayout.CENTER);
        contentPane.add(botonesPane, BorderLayout.SOUTH);


        // Se coloca el panel principal en el JFrame
        setContentPane(contentPane);


        // Mostrar inicialmente el primer cliente
        mostrarCliente();

        // Actualizar los botones
        actualizarBotones();
    }


    // -----------------------------
    // MOSTRAR CLIENTE
    // -----------------------------

    private void mostrarCliente() {

        Cliente cliente = clientes[posicion];

        numeroField.setText(
                String.valueOf(cliente.getNumero())
        );

        nombreField.setText(
                cliente.getNombre()
        );

        edadField.setText(
                String.valueOf(cliente.getEdad())
        );

        puntosField.setText(
                String.valueOf(cliente.getPuntos())
        );
    }


    // -----------------------------
    // ACTIVAR Y DESACTIVAR BOTONES
    // -----------------------------

    private void actualizarBotones() {

        if (posicion == 0) {

            anteriorButton.setEnabled(false);

        } else {

            anteriorButton.setEnabled(true);
        }


        if (posicion == clientes.length - 1) {

            siguienteButton.setEnabled(false);

        } else {

            siguienteButton.setEnabled(true);
        }
    }


    // -----------------------------
    // MAIN
    // -----------------------------

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                final Aplicacion app = new Aplicacion();

                app.pack();

                app.setVisible(true);
            }
        });
    }
}