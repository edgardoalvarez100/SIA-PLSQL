package dao;

import beans.Proyeccion;
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
public class ProyeccionDao extends DataBaseOracle {

    ResultSet rs;
    Connection con = null;
    CallableStatement cst;
    String sql = "";

    public int guardar(int cod_matricula, int cod_asignatura) {
        int respuesta = 0;
        con = conectar();
        sql = "{call GUARDAR_PROYECCION(?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cod_asignatura);
            cst.setInt(2, cod_matricula);
            cst.registerOutParameter(3, OracleTypes.INTEGER);
            cst.executeUpdate();
            respuesta = cst.getInt(3);

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

    public int actualizar(Proyeccion proyeccion) {
        return 0;

    }

    public int eliminar(int idProyeccion) {
        return 0;

    }
    
}
