package main.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julian.egea on 26/2/16.
 * Esta MainView construye las tablas y será la primera vista de la App
 */
public class MainView extends JFrame{
    //variables del Frame
    private static JMenuBar menuBar;
    private static JMenuItem addFactoryItem;
    private static JMenuItem addClientItem;
    private static JMenuItem visItem;
    private static JMenuItem exitItem;
    private static JComboBox clientComboBox;
    private static JLabel titleLabel;
    private static SpringLayout layout;
    private static Container contentPane;
    private static DefaultTableModel factoryModel;
    private static DefaultTableModel clientModel;
    private static JTable factoryTable;
    private static JTable clientTable;
    private static JButton buttonItemSelected;
    private int respuesta;

    //añade el JMenuBar al JFRAME
    public void setMenu(){
        menuBar = new JMenuBar();
        addFactoryItem = new JMenuItem("Añadir fábrica");
        addClientItem = new JMenuItem("Añadir cliente");
        visItem = new JMenuItem("Ver clientes");
        exitItem = new JMenuItem("Exit");
        menuBar.add(addFactoryItem);
        menuBar.add(addClientItem);
        menuBar.add(visItem);
        menuBar.add(exitItem);

        addFactoryItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MainView.this.dispose();
                new FactoryFormView();
            }
        });
        addClientItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MainView.this.dispose();
                new ClientFormView();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n"+"Se cerrará la aplicación por completo.","Confirmación de salida", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        this.setJMenuBar(menuBar);
    }
    //coloca el label junto con el combobox mediante springlayout AL CONTENTPANE
    public void setComboBox(){
        clientComboBox = new JComboBox();
        titleLabel = new JLabel("Elige el tipo de cliente para ver la cantidad registrados de los mismos:");
        buttonItemSelected = new JButton("Elegir");
        clientComboBox.addItem("");
        clientComboBox.addItem("Fábrica");
        clientComboBox.addItem("Cliente");
        layout.putConstraint(SpringLayout.WEST, titleLabel, 70, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, clientComboBox, 5, SpringLayout.EAST, titleLabel);
        layout.putConstraint(SpringLayout.NORTH, clientComboBox, 18, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, buttonItemSelected, 85, SpringLayout.EAST, titleLabel);
        layout.putConstraint(SpringLayout.NORTH, buttonItemSelected, 17, SpringLayout.NORTH, contentPane);
        contentPane.add(titleLabel);
        contentPane.add(clientComboBox);
        contentPane.add(buttonItemSelected);

        //listener del button para mostrar una tabla u otra
        buttonItemSelected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String clientSelected = clientComboBox.getSelectedItem().toString();
                if(clientSelected == "Fábrica"){
                    MainView.this.dispose();
                    new MainView();
                    setFactoryTable();
                    clientComboBox.setSelectedItem(clientSelected);
                }
                else if(clientSelected == "Cliente"){
                    MainView.this.dispose();
                    new MainView();
                    setClientTable();
                    clientComboBox.setSelectedItem(clientSelected);
                }
            }
        });
    }
    //esto establecerá de manera interna la tabla de las fabricas
    public void setFactoryTable(){
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 50, 300, 500);
        layout.putConstraint(SpringLayout.WEST, scrollPane, 110, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, scrollPane, 50, SpringLayout.WEST, contentPane);
        contentPane.add(scrollPane);

        factoryModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        factoryModel.addColumn("Propietario");
        factoryModel.addColumn("DNI/NIF");
        factoryModel.addColumn("Población");
        factoryModel.addColumn("Código postal");
        factoryModel.addColumn("Teléfono");
        factoryModel.addColumn("Comisión (%)");

        factoryTable = new JTable(factoryModel);
        TableColumnModel columnModel = factoryTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(60);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(5).setResizable(false);
        factoryTable.setColumnSelectionAllowed(false);
        scrollPane.setViewportView(factoryTable);
    }
    //esta funcion establece la tabla de clientes
    public void setClientTable(){
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 50, 300, 500);
        layout.putConstraint(SpringLayout.WEST, scrollPane, 110, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, scrollPane, 50, SpringLayout.WEST, contentPane);
        contentPane.add(scrollPane);

        clientModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        clientModel.addColumn("Nombre");
        clientModel.addColumn("Apellidos");
        clientModel.addColumn("DNI/NIF");
        clientModel.addColumn("Población");
        clientModel.addColumn("Código postal");
        clientModel.addColumn("Teléfono");

        clientTable = new JTable(clientModel);
        TableColumnModel columnModel = clientTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(5).setResizable(false);
        clientTable.setColumnSelectionAllowed(false);

        scrollPane.setViewportView(clientTable);
    }
    //construyes la view mediante el constructor de la clase
    public MainView(){
        super("Test - Ver clientes");
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = this.getContentPane();
        layout = new SpringLayout();
        contentPane.setLayout(layout);
        setMenu();
        setComboBox();
        this.setVisible(true);
    }
    //metodo main
    public static void main(String args[]){
        new MainView();
    }
}
