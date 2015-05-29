package dao;

import beans.Asignatura;
import beans.Proyeccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
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
            Logger.getLogger(ProyeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(ProyeccionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return respuesta;

    }

    public List<Proyeccion> buscarPorEstudiante(int cod_estudiante) {
        List<Proyeccion> lista = null;
        Proyeccion pro=null;
        
        Asignatura as = null;
        con = conectar();
        sql = "{call BUSCAR_PROYECCION(?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cod_estudiante);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.executeUpdate();
            rs = ((OracleCallableStatement) cst).getCursor(2);
            lista = new ArrayList<Proyeccion>();
            
            while (rs.next()) {
                pro = new Proyeccion();
                as = new Asignatura();
                as.setIdAsigntaura(rs.getInt("asi_codigo"));
                as.setNombre(rs.getString("asi_nombre"));
                as.setCreditos(rs.getInt("asi_creditos"));
                pro.setIdProyeccion(rs.getInt("pro_codigo"));                
                pro.setAsigntura(as);
                lista.add(pro);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ProyeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(ProyeccionDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return lista;

    }

    public int eliminar(int idProyeccion) {
          int respuesta = 0;
        con = conectar();
        sql = "{call ELIMINAR_PROYECCION(?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(2, OracleTypes.INTEGER);
            cst.setInt(1, idProyeccion);                  
            cst.executeUpdate();
            respuesta = cst.getInt(2);

        } catch (SQLException ex) {
            Logger.getLogger(ProyeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(ProyeccionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;

    }

}
