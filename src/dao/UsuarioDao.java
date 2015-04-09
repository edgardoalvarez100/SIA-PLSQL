package dao;

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
public class UsuarioDao extends DataBaseOracle {
    Connection con;
    CallableStatement cst;
    String sql;
    ResultSet rs;

    public boolean loguear(String usuario, String pass) {
        boolean respuesta = false;
        String pass1 = "";
        con = conectar();
        sql = "{call loguear(?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, usuario);
            cst.setString(2, pass);
            cst.registerOutParameter(3, OracleTypes.VARCHAR);
            cst.executeUpdate();
            pass1 = cst.getString(3);
            
            if (pass1 !=null) {              
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                desconectarBD(con);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
}
