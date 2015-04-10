package dao;


import java.sql.*;
import javax.swing.JOptionPane;

public class DataBaseOracle {

    private static String url; //ubicacin del ODBC
    private static String usuario; //usuario de la Base de datos
    private static String password; //Contrasea de la Base de Datos
    private static String database; //Nombre d ela Base de datos

    // Funcion que Abre la base de Datos
    public synchronized Connection conectar() {
        Connection conexion = null;

        try {
            //Carga del driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //for one of Oracle drivers
            url = "192.168.56.101";
            database = "XE";
            int port = 1521;
            String oracleURL = "jdbc:oracle:thin:@" + url + ":" + port + ":" + database;

            usuario = "SIA";
            password = "trew2345";
            conexion = DriverManager.getConnection(oracleURL, usuario, password);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Conexión Fallida", 2);
        } catch (java.lang.ClassNotFoundException ex) {
            System.err.print("Problemas al cargar el driver ");
            System.err.println(ex.getMessage());
        }

        return conexion;
    }
    
 public synchronized void desconectarBD(Connection con) throws SQLException {
                if (con != null) {
            con.close();
        }
    }
}
