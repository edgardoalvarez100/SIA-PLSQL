package dao;

import beans.Nota;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author EAlvarez
 */
public class NotaDao extends DataBaseOracle{
    Connection con = null;
    CallableStatement cst;
    String sql = "";
    ResultSet rs=null;
    
  public int guardar(Nota nota) {
        int respuesta = 0;
        con = conectar();
        sql = "{call GUARDAR_NOTAS(?,?,?,?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(5, nota.getIdNota());
            cst.setDouble(4, nota.getDefinitiva());
            cst.setDouble(1, nota.getPrimer_corte());
            cst.setDouble(2, nota.getSegundo_corte());
            cst.setDouble(3, nota.getTercer_corte());            
            cst.registerOutParameter(6, OracleTypes.INTEGER);                      
            cst.executeUpdate();
            respuesta = cst.getInt(6);

        } catch (SQLException ex) {
            Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
  
  public Nota obtenerNotasPorMatricula(int codigo){
      Nota respuesta=null;
      conectar();
      sql = "{call OBTENER_NOTA_MATRIC(?,?)}";
      try {
            cst = con.prepareCall(sql);            
            cst.setInt(1, codigo);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.executeUpdate();
            rs = ((OracleCallableStatement) cst).getCursor(2);
            while(rs.next()){
                respuesta.setPrimer_corte(rs.getDouble(""));
                respuesta.setSegundo_corte(rs.getDouble(""));
                respuesta.setTercer_corte(rs.getDouble(""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      return respuesta;
  }
  
}
