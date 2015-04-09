package dao;

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
public class AsignaturaDao extends DataBaseOracle {

    Connection con = null;
    CallableStatement cst;

    public String actualizar() {
        con = conectar();
        String sql = "{call }";
        try {
            cst = con.prepareCall(sql);
            cst.setString(sql, sql);

        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int guardar(String descripcion, int creditos,
            int hr_teorica, int hr_practica, int hr_indepen, String tipo) {
        int respuesta = 0;
        con = conectar();
        String sql = "{call GUARDAR_ASIGNATURA(?,?,?,?,?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(7, OracleTypes.INTEGER);
            cst.setString(1, descripcion);
            cst.setInt(2, creditos);
            cst.setInt(3, hr_teorica);
            cst.setInt(4, hr_practica);
            cst.setInt(5, hr_indepen);
            cst.setString(6, tipo);
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

    public int ultima_secuencia(){
              int respuesta = 0;
        con = conectar();
        String sql = "{?=call ULTIMA_ASIGNATURA()}";
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
    
}
