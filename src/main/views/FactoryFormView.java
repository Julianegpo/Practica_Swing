package main.views;

import main.db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julian.egea on 26/2/16.
 * Esta View despliega un formulario de registro para fábricas
 */
public class FactoryFormView extends JFrame{
    //conexion
    DBConnection con = new DBConnection();
    //variables de la ventana
    private static JPanel segundaVentana;
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
    private static JLabel ownerLabel;
    private static JLabel dniLabel;
    private static JLabel poblationLabel;
    private static JLabel postalCodeLabel;
    private static JLabel phoneLabel;
    private static JLabel comissionLabel;
    //form textfields
    private static JTextField ownerTextField;
    private static JTextField dniTextField;
    private static JTextField poblationTextField;
    private static JTextField postalCodeTextField;
    private static JTextField phoneTextField;
    private static JTextField comissionTextField;

    public void setMenu(){
        menuBar = new JMenuBar();
        addFactoryItem = new JMenuItem("Añadir fábrica");
        addClientItem = new JMenuItem("Añadir cliente");
        visItem = new JMenuItem("Ver Clientes");
        exitItem = new JMenuItem("Exit");
        menuBar.add(addFactoryItem);
        menuBar.add(addClientItem);
        menuBar.add(visItem);
        menuBar.add(exitItem);

        //listeners de botones del JMenuBar anclado al JFrame
        visItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cambiar de pestaña actual?\n"+"Se cerrará la ventana por completo y será dirigido a la vista principal." , "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    FactoryFormView.this.dispose();
                    new MainView();
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir de la pestaña actual?\n"+"Se cerrará la ventana por completo y será dirigido a la vista principal." , "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    FactoryFormView.this.dispose();
                    new MainView();
                }
            }
        });
        this.setJMenuBar(menuBar);
    }

    //esto desplegará el formulario y establece las reglas(constraints) para colocar los elementos en el frame
    public void desplegarFormulario(){
        ownerLabel = new JLabel("Propietario:");
        ownerTextField = new JTextField(15);
        //constraints a la derecha para el label
        layout.putConstraint(SpringLayout.WEST, ownerLabel, 200, SpringLayout.WEST, contentPane);
        //constraints hacia abajo para el label
        layout.putConstraint(SpringLayout.NORTH, ownerLabel, 120, SpringLayout.NORTH, contentPane);
        //constraints para el textfield hacia abajo
        layout.putConstraint(SpringLayout.NORTH, ownerTextField, 120, SpringLayout.NORTH, contentPane);
        //constraints para el textfield hacia la derecha
        layout.putConstraint(SpringLayout.WEST, ownerTextField, 15, SpringLayout.EAST, ownerLabel);

        dniLabel = new JLabel("DNI/NIF:");
        dniTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, dniLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, dniLabel, 150, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, dniTextField, 150, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, dniTextField, 15, SpringLayout.EAST, dniLabel);

        poblationLabel = new JLabel("Población:");
        poblationTextField=new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, poblationLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, poblationLabel, 180, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, poblationTextField, 180, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, poblationTextField, 15, SpringLayout.EAST, poblationLabel);

        postalCodeLabel=new JLabel("Código postal:");
        postalCodeTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, postalCodeLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, postalCodeLabel, 210, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, postalCodeTextField, 210, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, postalCodeTextField, 15, SpringLayout.EAST, postalCodeLabel);

        phoneLabel = new JLabel("Teléfono");
        phoneTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, phoneLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, phoneLabel, 240, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, phoneTextField, 240, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, phoneTextField, 15, SpringLayout.EAST, phoneLabel);

        comissionLabel= new JLabel("Comisión (%):");
        comissionTextField = new JTextField(15);
        layout.putConstraint(SpringLayout.WEST, comissionLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, comissionLabel, 270, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, comissionTextField, 270, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, comissionTextField, 15, SpringLayout.EAST, comissionLabel);

        JLabel formLabel = new JLabel("En este formulario puedes registrar una fábrica nueva:");
        layout.putConstraint(SpringLayout.WEST, formLabel, 200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, formLabel, 70, SpringLayout.NORTH, contentPane);

        contentPane.add(ownerLabel);
        contentPane.add(ownerTextField);
        contentPane.add(dniLabel);
        contentPane.add(dniTextField);
        contentPane.add(poblationLabel);
        contentPane.add(poblationTextField);
        contentPane.add(postalCodeLabel);
        contentPane.add(postalCodeTextField);
        contentPane.add(phoneLabel);
        contentPane.add(phoneTextField);
        contentPane.add(comissionLabel);
        contentPane.add(comissionTextField);
        contentPane.add(formLabel);

        JButton submit = new JButton("Crear fábrica");
        layout.putConstraint(SpringLayout.WEST, submit, 290, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, submit, 310, SpringLayout.NORTH, contentPane);

        contentPane.add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                con.addFactory(ownerTextField.getText(), dniTextField.getText(), poblationTextField.getText(),  Integer.parseInt(postalCodeTextField.getText()), Integer.parseInt(phoneTextField.getText()), Float.parseFloat(comissionTextField.getText()));
            }
        });
    }
    //constructor de la view
    public FactoryFormView(){
        super("Test - Añadir fábrica");
        segundaVentana = new JPanel();
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout = new SpringLayout();
        contentPane = this.getContentPane();
        this.setLayout(layout);
        contentPane.setLayout(layout);
        this.add(segundaVentana);
        setMenu();
        desplegarFormulario();
    }
}
