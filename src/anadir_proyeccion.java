import javax.swing.table.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class anadir_proyeccion extends javax.swing.JFrame {

    /** Creates new form anadir_proyeccion */
    public anadir_proyeccion() {
        initComponents();
    }

   public boolean validar(){
      
   
    if(txt_codigo_asignatura.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Error debe ingresar codigo asignatura", "Error",1);
        return false;
    }
     if(txt_codigo_estudiante.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Error debe ingresar el codigo del estudiante", "Error",1);
        return false;
    }
      
    return true;
    }
    public void buscarDatosAsignatura(String SQL)
    {
       String titulos[]={"Codigo","Asignatura"};

        int j,total1=0;
        ResultSet con;
        try
        {

            con=DataBaseOracle.Query("SELECT COUNT(*) FROM  sia_asignaturas a WHERE a.asi_estado=1");
            if(con.next())
            {
              total1=con.getInt(1);
            }
            Object [][] data = new Object[total1][4];

            con=DataBaseOracle.Query(SQL);
            j=0;
            while(con.next())
            {
                data[j][0]=con.getString(1);//codigo
                data[j][1]=con.getString(2);//Nombre
                

                j++;
            }//end while
           // DefaultTableModel ob =new DefaultTableModel();
            DefaultTableModel dtm = new DefaultTableModel(data,titulos);
            tabla.setModel(dtm);
            con.close();
        }
        catch(SQLException exc)
        {
           System.err.println(exc.getMessage());
         }
    }
    
    public void buscarDatosEstudiantes(String SQL)
    {
       String titulos[]={"Codigo","Nombres","Apellidos"};

        int j,total1=0;
        ResultSet con;
        try
        {

            con=DataBaseOracle.Query("SELECT COUNT(*) FROM sia_estudiantes where est_estado=1");
            if(con.next())
            {
              total1=con.getInt(1);
            }
            Object [][] data = new Object[total1][4];

            con=DataBaseOracle.Query(SQL);
            j=0;
            while(con.next())
            {
                data[j][0]=con.getString("est_cod_matricula");//codigo
                data[j][1]=con.getString(2);//Nombre
                data[j][2]=con.getString(3);//Apellidos

                j++;
            }//end while
           // DefaultTableModel ob =new DefaultTableModel();
            DefaultTableModel dtm = new DefaultTableModel(data,titulos);
            tabla_estudiantes.setModel(dtm);
            con.close();
        }
        catch(SQLException exc)
        {
           System.err.println(exc.getMessage());
         }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fr_asignatura = new javax.swing.JFrame();
        btaceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fr_estudiantes = new javax.swing.JFrame();
        bt_aceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_estudiantes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_buscar_est = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo_asignatura = new javax.swing.JTextField();
        txt_codigo_estudiante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bt_anadir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bt_buscar_est = new javax.swing.JButton();

        btaceptar.setText("Aceptar");
        btaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaceptarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel7.setText("Buscar");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24));
        jLabel8.setText("Asignaturas");

        javax.swing.GroupLayout fr_asignaturaLayout = new javax.swing.GroupLayout(fr_asignatura.getContentPane());
        fr_asignatura.getContentPane().setLayout(fr_asignaturaLayout);
        fr_asignaturaLayout.setHorizontalGroup(
            fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fr_asignaturaLayout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(btaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(fr_asignaturaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fr_asignaturaLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        fr_asignaturaLayout.setVerticalGroup(
            fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
            .addGroup(fr_asignaturaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btaceptar)
                .addGap(36, 36, 36))
        );

        bt_aceptar.setText("Aceptar");
        bt_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aceptarActionPerformed(evt);
            }
        });

        tabla_estudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_estudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_estudiantesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_estudiantes);

        jLabel9.setText("Buscar");

        txt_buscar_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscar_estActionPerformed(evt);
            }
        });
        txt_buscar_est.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscar_estKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 24));
        jLabel10.setText("Estudiantes");

        javax.swing.GroupLayout fr_estudiantesLayout = new javax.swing.GroupLayout(fr_estudiantes.getContentPane());
        fr_estudiantes.getContentPane().setLayout(fr_estudiantesLayout);
        fr_estudiantesLayout.setHorizontalGroup(
            fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fr_estudiantesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fr_estudiantesLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar_est, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fr_estudiantesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                        .addComponent(bt_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        fr_estudiantesLayout.setVerticalGroup(
            fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fr_estudiantesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_buscar_est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_aceptar)
                .addGap(35, 35, 35))
        );

        txt_codigo_asignatura.setEditable(false);

        txt_codigo_estudiante.setEditable(false);

        jLabel1.setText("Codigo Estudiante");

        jLabel2.setText("Codigo Asignatura");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel3.setText("Nueva Proyección");

        bt_anadir.setText("Añadir");
        bt_anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anadirActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bt_buscar_est.setText("...");
        bt_buscar_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscar_estActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_codigo_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_buscar_est, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_anadir)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_codigo_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigo_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_buscar_est)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_codigo_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(bt_anadir))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaceptarActionPerformed
        // TODO add your handling code here:
        fr_asignatura.setVisible(false);
}//GEN-LAST:event_btaceptarActionPerformed

private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
       
        int i=tabla.getSelectedRow();
        String dato=(String)tabla.getValueAt(i,0);//codigo
        txt_codigo_asignatura.setText(dato);
        
}//GEN-LAST:event_tablaMousePressed

private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txt_buscarActionPerformed

private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
       
        String sql;
        if(!txt_buscar.getText().equals("")){
            sql="SELECT asi_codigo,  UPPER(asi_nombre) FROM sia_asignaturas WHERE asi_nombre LIKE '"+txt_buscar.getText()+"%' AND asi_estado=1";
        } else
            sql="SELECT asi_codigo,  UPPER(asi_nombre) FROM sia_asignaturas WHERE asi_estado=1";
        buscarDatosAsignatura(sql);
}//GEN-LAST:event_txt_buscarKeyPressed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  fr_asignatura.setLocationRelativeTo(null);
  fr_asignatura.setSize(400, 301);
  fr_asignatura.setVisible(true);
  String sql;
        if(!txt_buscar.getText().equals("")){
            sql="SELECT asi_codigo,  UPPER(asi_nombre) FROM sia_asignaturas WHERE asi_nombre LIKE '"+txt_buscar.getText()+"%' AND asi_estado=1";
        } else
            sql="SELECT asi_codigo,  UPPER(asi_nombre) FROM sia_asignaturas WHERE asi_estado=1";
        buscarDatosAsignatura(sql);
}//GEN-LAST:event_jButton1ActionPerformed

private void bt_anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anadirActionPerformed

    try{
       if (validar()){
           String sql ="INSERT INTO sia_proyecciones values("+txt_codigo_asignatura.getText()+", INC_PROYECCION_PK.NextVal, 1, (SELECT est_codigo FROM sia_estudiantes WHERE est_cod_matricula="+txt_codigo_estudiante.getText() +" AND est_estado=1))";
        DataBaseOracle.Execute(sql);
         
        sql="INSERT INTO sia_notas VALUES(INC_NOTAS_PK.NextVal, NULL, NULL, NULL, (SELECT LAST_NUMBER-1 FROM user_sequences WHERE SEQUENCE_NAME = 'INC_PROYECCION_PK'), NULL)";
        DataBaseOracle.Execute(sql);
        JOptionPane.showMessageDialog(this, "Asignatura Añadida");
        this.hide();
        
        
        
    } 
    }catch (Exception de) {
            System.err.println(de.getMessage());
        }
}//GEN-LAST:event_bt_anadirActionPerformed

private void bt_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aceptarActionPerformed
fr_estudiantes.setVisible(false);
}//GEN-LAST:event_bt_aceptarActionPerformed

private void tabla_estudiantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_estudiantesMousePressed
  int i=tabla_estudiantes.getSelectedRow();
        String dato=(String)tabla_estudiantes.getValueAt(i,0);//codigo
        txt_codigo_estudiante.setText(dato);
}//GEN-LAST:event_tabla_estudiantesMousePressed

private void txt_buscar_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscar_estActionPerformed
 
}//GEN-LAST:event_txt_buscar_estActionPerformed

private void txt_buscar_estKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_estKeyPressed
 String sql;
        if(!txt_buscar_est.getText().equals("")){
            sql="SELECT est_cod_matricula, UPPER(est_nombres), UPPER(est_apellidos) FROM sia_estudiantes WHERE est_nombres LIKE '%"+txt_buscar_est.getText()+"%' AND est_estado=1";
        } else
            sql="SELECT est_cod_matricula, UPPER(est_nombres), UPPER(est_apellidos) FROM sia_estudiantes WHERE est_estado=1";
        buscarDatosEstudiantes(sql);
}//GEN-LAST:event_txt_buscar_estKeyPressed

private void bt_buscar_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscar_estActionPerformed
fr_estudiantes.setLocationRelativeTo(null);
  fr_estudiantes.setSize(495, 300);
  fr_estudiantes.setVisible(true);
}//GEN-LAST:event_bt_buscar_estActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(anadir_proyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anadir_proyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anadir_proyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anadir_proyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new anadir_proyeccion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_anadir;
    private javax.swing.JButton bt_buscar_est;
    private javax.swing.JButton btaceptar;
    private javax.swing.JFrame fr_asignatura;
    private javax.swing.JFrame fr_estudiantes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla_estudiantes;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_buscar_est;
    private javax.swing.JTextField txt_codigo_asignatura;
    private javax.swing.JTextField txt_codigo_estudiante;
    // End of variables declaration//GEN-END:variables
}
