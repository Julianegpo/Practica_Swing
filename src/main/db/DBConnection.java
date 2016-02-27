package main.db;
import main.entities.Client;
import main.entities.Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
    public Connection connection;
    private Statement s;

    public DBConnection(){
        try{
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Practica_Swing", "root", "1234");
            s = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //para obtener los clientes
    public ArrayList<Client> getClients(){
        Client newClient;
        ArrayList<Client> clientes = new ArrayList<Client>();
        try{
            ResultSet rs = s.executeQuery("select * from Client");

            while(rs.next()){
                int id = (Integer) rs.getObject("id");
                String name = (String) rs.getObject("nombre");
                String surname = (String) rs.getObject("apellidos");
                String dni = (String) rs.getObject("dni");
                String poblation = (String) rs.getObject("poblacion");
                int postal_code = (Integer) rs.getObject("codigo_postal");
                int phone = (Integer) rs.getObject("telefono");

                newClient = new Client(id, name, surname, dni, poblation, postal_code, phone);
                clientes.add(newClient);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientes;
    }
    //para añadir un cliente nuevo
    public void addClient(String name, String surname, String dni, String poblation, int postal_code, int phone){
        try{
            String query = "INSERT INTO Client (nombre, apellidos, dni, poblacion, codigo_postal, telefono)VALUES ('" + name + "', '" + surname + "', '" + dni + "', '" + poblation + "', " + postal_code+ ", "+phone+");";
            System.out.println("Query INSERT: "+query);
            int rs = s.executeUpdate(query);
        }catch(Exception e){}
    }
    //para añadir una fabrica
    public void addFactory(String owner, String dni, String poblation, int postal_code, int phone, float comission){
        try{
            String query = "INSERT INTO FACTORY(propietario, dni, poblacion, codigo_postal, telefono, comision) VALUES ('" + owner + "', '" + dni + "', '" + poblation + "', " + postal_code+ ", "+phone+", "+comission+")";
            System.out.println("Query INSERT: "+query);
            int rs = s.executeUpdate(query);
        }catch(Exception e){}
    }
    //para obtener todas las fabricas
    public ArrayList<Factory> getFactories(){
        Factory newFactory;
        ArrayList<Factory> fabricas = new ArrayList<Factory>();
        try{
            ResultSet rs = s.executeQuery("select * from Factory");

            while(rs.next()){
                int id = (Integer) rs.getObject("id");
                String owner = (String) rs.getObject("propietario");
                String dni = (String) rs.getObject("dni");
                String poblation = (String) rs.getObject("poblacion");
                int postal_code = (Integer) rs.getObject("codigo_postal");
                int phone = (Integer) rs.getObject("telefono");
                float comission = (float) rs.getObject("comision");

                newFactory = new Factory(id, owner, dni, poblation, postal_code, phone, comission);
                fabricas.add(newFactory);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return fabricas;
    }
}