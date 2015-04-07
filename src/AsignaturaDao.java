
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EAlvarez
 */
public class AsignaturaDao extends  DataBaseOracle{
    Connection con=null;
    CallableStatement cst;
    public String actualizar(){
         con = conectar();
         String sql="{call }";
        try {
            cst = con.prepareCall(sql);
            cst.setString(sql, sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return null;
    }
    
}
