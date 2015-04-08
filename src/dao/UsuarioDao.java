/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class UsuarioDao extends DataBaseOracle{
    
    Connection con;
    CallableStatement cst;
    String sql;
    ResultSet rs;
    
    
    public boolean loguear(String usuario, String pass){
        con = conectar();
        sql= "call loguear(?,?,?)";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, usuario);
            cst.setString(2, pass);
            cst.registerOutParameter(3, OracleTypes.INTEGER);
            rs = cst.executeQuery();
            while(rs.next()){
                String pass1=rs.getString("usu_pass");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
