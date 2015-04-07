/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19517178
 */
import java.sql.*;



public  class DataBase {
  private static String url; //ubicacin del ODBC
  private static String usuario; //usuario de la Base de datos
  private static String password; //Contrasea de la Base de Datos
  private static String database; //Nombre d ela Base de datos
  private static Statement stmt; //variable para crear la conexion

  // Funcion que Abre la base de Datos
  public static void Open()
  {
  	url="localhost";
    usuario="root";
    password="usbw";
    database ="sia";
    stmt = null;

 // url = new String("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=encuentas.mdb");

    //------------2222222 para errores con el driver---------22222222222222----------
    try
     {
       //Carga del driver
       Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://"+url+":3307/"+database+"?" +
                                   "user="+usuario+"&password="+password;
            Connection conexion = DriverManager.getConnection(connectionUrl);
          stmt = conexion.createStatement();
     }
      catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        }
    catch(java.lang.ClassNotFoundException ex)
    {
      System.err.print("Problemas al cargar el driver ");
      System.err.println(ex.getMessage());
     }
       //--Para  posibles errores con el sql-----------

         //--- 11111111111  ----Para  posibles errores con el sql----11111111111----------
   }//end funcin open
  //----------------------------------------------------------
   // funcion para ejecutar consulta en la base de Datos (Select )
 public static ResultSet Query(String SQLquery)
 {
   try {
      //Creando la conexion a la BD

      ResultSet cursor = stmt.executeQuery(SQLquery);
       return cursor;
  }
  // Si se presenta Un Error
  catch(SQLException exc)
  {
    System.err.println(exc.getMessage());
    return null;
  }
 }
 //--------------------------------------------------------
 // para realizar operacioned de actualizacion como:
 //------ INSERT, DELETE Y UPDATE-------
public static void Execute(String registro)
{
  try
  {
     stmt.executeUpdate(registro);
   }catch(SQLException exc)
    {
        System.err.println(exc.getMessage());
    }
} // end execute
}// en class dtabase



