package dao;

import beans.Estudiante;
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
public class EstudianteDao extends DataBaseOracle {

    Connection con = null;
    CallableStatement cst;
    String sql = "";
    ResultSet rs;

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

    public int actualizar(Estudiante estudiante) {
        int respuesta = 0;
        con = conectar();
        sql = "{call ACTUALIZAR_ESTUDIANTE(?,?,?,?,?,?,?)}";
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

     public int eliminar(int codigo) {
        int respuesta = 0;
        con = conectar();
        sql = "{call ELIMINAR_ESTUDIANTE(?,?)}";
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
      public int cantidadPorNombre(String nombre) {
        int respuesta = 0;
        con = conectar();
        sql = "{call CANTIDAD_ESTUDIANTE_NOMBRE(?,?)}";
        try {
            cst = con.prepareCall(sql);            
            cst.setString(1, nombre);
            cst.registerOutParameter(2, OracleTypes.INTEGER);
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
    public Estudiante buscarPorCodigo(int codigo) {
        ResultSet rs = null;
        con = conectar();
        sql = "{call BUSCAR_ESTUDIANTE_COD(?,?)}";
        Estudiante est = null;
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.setInt(1, codigo);
            cst.executeUpdate();
            rs = ((OracleCallableStatement) cst).getCursor(2);
            while (rs.next()) {
                est = new Estudiante();
                est.setIdEstudiante(rs.getInt("est_codigo"));
                est.setNombres(rs.getString("est_nombres"));
                est.setApellidos(rs.getString("est_apellidos"));
                est.setTelefono(rs.getInt("est_telefono"));
                est.setDireccion(rs.getString("est_direccion"));
                est.setCod_matricula(rs.getInt("est_cod_matricula"));
                est.setIdentificacion(rs.getInt("est_identificacion"));
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

        return est;
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        List<Estudiante> lista=null;
        Estudiante as = null;
        con = conectar();
        sql = "{call BUSCAR_ESTUDIANTE_NOMBRE(?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, nombre);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.executeUpdate();
            rs = ((OracleCallableStatement) cst).getCursor(2);
            lista= new ArrayList<Estudiante>();
            while (rs.next()) {
                as = new Estudiante();
                as.setCod_matricula(rs.getInt("est_cod_matricula"));                
                as.setNombres(rs.getString("est_nombres"));
                as.setApellidos(rs.getString("est_apellidos"));
                as.setTelefono(rs.getInt(4));//contador de tuplas, usado para grilla de busqueda
                lista.add(as);
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
        return lista;
    }
    
}
