package dao;

import beans.Nota;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author EAlvarez
 */
public class NotaDao extends DataBaseOracle{
    Connection con = null;
    CallableStatement cst;
    String sql = "";
    ResultSet rs;
    
  public int guardar(Nota nota) {
        int respuesta = 0;
        con = conectar();
        sql = "{call GUARDAR_NOTA(?,?,?,?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, nota.getProyeccion().getEstudiante().getCod_matricula());
            cst.setDouble(2, nota.getDefinitiva());
            cst.setDouble(3, nota.getPrimer_corte());
            cst.setDouble(4, nota.getSegundo_corte());
            cst.setDouble(5, nota.getTercer_corte());            
            cst.registerOutParameter(6, OracleTypes.INTEGER);
                      
            cst.executeUpdate();
            respuesta = cst.getInt(6);

        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return respuesta;
    }
}
