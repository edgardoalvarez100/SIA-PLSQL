import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Reporte {
public static String Titulo,SQL,Logo,Archivo;
  public static int ncol;
//Metodo que recibe el nombre del reporte, la consulta sql, el encabezado de titulos de la tabla,
//   numero de columnas, titulo del reporte y el logo
    //
 public static void  ReportHTML(String encabezado[]){
                ResultSet con;
                try{
                   // Se crea el archivo independiente que exista o no
                    FileWriter file=new  FileWriter(Archivo);
                     con=DataBaseOracle.Query(SQL);// se ejecuta la consulta
                    //Para escribir en el archivo
                       file.write("<HTML><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><HEAD><TITLE>"+Titulo+"</TITLE></HEAD>\n");
                    //Para limpiar el buffer
                       file.flush();
                       file.write("<BODY>\n");

                       String enc= " <CENTER>\n <TABLE WIDHT='900'\n>"+
                                  "     <TR>\n" +
                                  "         <TH WIDTH='123'><IMG SRC='" + Logo + "' ></TH>\n" +
                                  "         <TH WIDTH='722' ><FONT SIZE='14'><CENTER>"+Titulo+"</CENTER></FONT></TH>\n"+
                                  "     </TR>\n"+
                                   " </TABLE>\n </CENTER>\n"+
                                 "<HR><BR><CENTER><TABLE BORDER='1'>\n" +
                                  "<TR bgcolor=\"#CCCCCC\">\n";
                      file.write(enc);

                       for(int i=0;i<ncol;i++){
                       file.write("<TH>"+encabezado[i]+"</TH>");

                       }
                       //Recorremos lo que seleccionamos en la consulta
                      while(con.next()){
                              file.write("<TR>\n");
                               for(int i=1;i<=ncol;i++)
                               {
                                        file.write("<TD>"+con.getString(i)+"</TD>\n");

                          }
                            file.write("</TR>\n");

                     }//End While


                                file.write("\n</TABLE></CENTER>\n" +
                                        "<BR><CENTER><INPUT TYPE='BUTTON' VALUE='Imprimir' onClick='window.print();'></CENTER>\n <BR /><BR /> <CENTER>Powered by SIA®2012</CENTER>\n"+
                                        "</BODY>\n" +
                                        "</HTML>");
                                //Para limpiar el buffer
                                JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito");
                file.flush();
                file.close();//cerramos el archivo
                Runtime.getRuntime().exec("cmd /c "+Archivo);

                        }//end try
                        //excepciones que se producen al ejecutar la consulta y al crear un archivo
                        catch(SQLException exc) { System.err.println(exc.getMessage()); }
                        catch(IOException exc1) { System.err.println(exc1.getMessage()); }
          } //end generar repote ///////*************
}
