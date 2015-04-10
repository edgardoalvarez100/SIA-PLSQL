package dao;

import beans.Asignatura;
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
public class AsignaturaDao extends DataBaseOracle {

    ResultSet rs;
    Connection con = null;
    CallableStatement cst;
    String sql="";

    public Asignatura buscarPorId(int codigo) {
        Asignatura as = null;
        con = conectar();
        sql = "{call BUSCAR_ASIGNATURA(?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, codigo);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.executeUpdate();
            rs = ((OracleCallableStatement) cst).getCursor(2);
            while(rs.next()){
                as = new Asignatura();
                as.setIdAsigntaura(codigo);
                as.setCreditos(rs.getInt("asi_creditos"));
                as.setHoras_independientes(rs.getInt("asi_horas_independientes"));
                as.setHoras_practicas(rs.getInt("asi_horas_practicas"));
                as.setHoras_teoricas(rs.getInt("asi_horas_teoricas"));
                as.setTipo(rs.getString("asi_tipo"));
                as.setNombre(rs.getString("asi_nombre"));                
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return as;
    }

    public int actualizar(int codigo, String descripcion, int creditos,
            int hr_teorica, int hr_practica, int hr_indepen, String tipo) {
        int respuesta = 0;
        con = conectar();
        sql = "{call ACTUALIZAR_ASIGNATURA(?,?,?,?,?,?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, codigo);           
            cst.setString(2, descripcion);
            cst.setInt(3, creditos);
            cst.setInt(4, hr_teorica);
            cst.setInt(5, hr_practica);
            cst.setInt(6, hr_indepen);
            cst.setString(7, tipo);
            cst.registerOutParameter(8, OracleTypes.INTEGER);
            System.out.println("asignatura");
            cst.executeUpdate();
            respuesta = cst.getInt(8);

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

    public int guardar(String descripcion, int creditos,
            int hr_teorica, int hr_practica, int hr_indepen, String tipo) {
        int respuesta = 0;
        con = conectar();
        sql = "{call GUARDAR_ASIGNATURA(?,?,?,?,?,?,?)}";
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
    
    public int eliminar(int codigo) {
        int respuesta = 0;
        con = conectar();
        sql = "{call ELIMINAR_ASIGNATURA(?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(2, OracleTypes.INTEGER);
            cst.setInt(1, codigo);                  
            cst.executeUpdate();
            respuesta = cst.getInt(2);

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

    public int ultima_secuencia() {
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
