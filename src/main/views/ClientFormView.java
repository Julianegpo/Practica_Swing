package main.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julian.egea on 26/2/16.
 */
public class ClientFormView extends JFrame{
    //frame variables
    private static JPanel addClient;
    private static JMenuBar menuBar;
    private static JMenuItem addFactoryItem;
    private static JMenuItem addClientItem;
    private static JMenuItem visItem;
    private static JMenuItem exitItem;
    private static SpringLayout layout;
    private static Container contentPane;
    private int respuesta;

    //variables formulario
    //form labels
    private static Component nameLabel;
    private static Component surnameLabel;
    private static Component dniLabel;
    private static Component poblationLabel;
    private static Component postalCodeLabel;
    private static Component phoneLabel;
    //form textfields
    private static Component nameTextField;
    private static Component surnameTextField;
    private static Component dniTextField;
    private static Component poblationTextField;
    private static Component postalCodeTextField;
    private static Component phoneTextField;

    public void setMenu() {
        menuBar = new JMenuBar();
        addFactoryItem = new JMenuItem("Añadir fábrica");
        addClientItem = new JMenuItem("Añadir cliente");
        visItem = new JMenuItem("Ver clientes");
        exitItem = new JMenuItem("Exit");
        menuBar.add(addFactoryItem);
        menuBar.add(addClientItem);
        menuBar.add(visItem);
        menuBar.add(exitItem);
        this.setJMenuBar(menuBar);

        //listeners de botones
        visItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cambiar de pestaña actual?\n"+"Se cerrará la ventana por completo y será dirigido a la vista principal." , "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    ClientFormView.this.dispose();
                    new MainView();
                }

            }
        });
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir de la pestaña actual?\n"+"Se cerrará la ventana por completo y será dirigido a la vista principal." , "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    ClientFormView.this.dispose();
                    new MainView();
                }
            }
        });
    }

    public void desplegarFormulario() {
        nameLabel = new JLabel("Primer nombre:");
        nameTextField = new JTextField(15);
        //constraints a la derecha para el label
        layout.putConstraint(SpringLayout.WEST, nameLabel, 200, SpringLayout.WEST, contentPane);
        //constraints hacia abajo para el label
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 120, SpringLayout.NORTH, contentPane);
        //constraints para el textfield hacia abajo
        layout.putConstraint(SpringLayout.NORTH, nameTextField, 120, SpringLayout.NORTH, contentPane);
        //constraints para el textfield hacia la derecha con respecto al label
        layout.putConstraint(SpringLayout.WEST, nameTextField, 15, SpringLayout.EAST, nameLabel);

        surnameLabel = new JLabel("Apellidos:");
        surnameTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, surnameLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, surnameLabel, 150, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, surnameTextField, 150, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, surnameTextField, 15, SpringLayout.EAST, surnameLabel);

        dniLabel = new JLabel("DNI/NIF:");
        dniTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, dniLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, dniLabel, 180, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, dniTextField, 180, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, dniTextField, 15, SpringLayout.EAST, dniLabel);

        poblationLabel = new JLabel("Población:");
        poblationTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, poblationLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, poblationLabel, 210, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, poblationTextField, 210, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, poblationTextField, 15, SpringLayout.EAST, poblationLabel);

        postalCodeLabel = new JLabel("Código postal:");
        postalCodeTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, postalCodeLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, postalCodeLabel, 240, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, postalCodeTextField, 240, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, postalCodeTextField, 15, SpringLayout.EAST, postalCodeLabel);

        phoneLabel = new JLabel("Teléfono:");
        phoneTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, phoneLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, phoneLabel, 270, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, phoneTextField, 270, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, phoneTextField, 15, SpringLayout.EAST, phoneLabel);

        JLabel formLabel = new JLabel("En este formulario puedes registrar un cliente nuevo:");
        layout.putConstraint(SpringLayout.WEST, formLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, formLabel, 70, SpringLayout.NORTH, contentPane);

        JButton submit = new JButton("Crear cliente");
        layout.putConstraint(SpringLayout.WEST, submit, 290, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, submit, 310, SpringLayout.NORTH, contentPane);

        contentPane.add(nameLabel);
        contentPane.add(nameTextField);
        contentPane.add(surnameLabel);
        contentPane.add(surnameTextField);
        contentPane.add(dniLabel);
        contentPane.add(dniTextField);
        contentPane.add(poblationLabel);
        contentPane.add(poblationTextField);
        contentPane.add(postalCodeLabel);
        contentPane.add(postalCodeTextField);
        contentPane.add(phoneLabel);
        contentPane.add(phoneTextField);
        contentPane.add(formLabel);
        contentPane.add(submit);
    }
    //constructor de la view
    public ClientFormView() {
        super("Test - Añadir cliente");
        addClient = new JPanel();
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout = new SpringLayout();
        contentPane = this.getContentPane();
        this.setLayout(layout);
        contentPane.setLayout(layout);
        this.add(addClient);
        setMenu();
        desplegarFormulario();
    }
}
