package dao;

import beans.Estudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author EAlvarez
 */
public class EstudianteDao extends DataBaseOracle {

    Connection con = null;
    CallableStatement cst;
    String sql = "";

    public int ultima_secuencia() {
        int respuesta = 0;
        con = conectar();
        sql = "{?=call ULTIMO_ESTUDIANTE()}";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.NUMERIC);
            cst.executeUpdate();
            respuesta = cst.getInt(1);

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

    public int guardar(Estudiante estudiante) {
        int respuesta = 0;
        con = conectar();
        sql = "{call GUARDAR_ESTUDIANTE(?,?,?,?,?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(7, OracleTypes.INTEGER);
            cst.setString(1, estudiante.getNombres());
            cst.setString(2, estudiante.getApellidos());
            cst.setInt(3, estudiante.getTelefono());
            cst.setInt(4, estudiante.getIdentificacion());
            cst.setString(5, estudiante.getDireccion());
            cst.setInt(6, estudiante.getCod_matricula());            
            cst.executeUpdate();
            respuesta = cst.getInt(7);

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
