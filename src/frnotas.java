import javax.swing.table.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class frnotas extends javax.swing.JFrame {

   static int[ ] notas = new int[20];
    private int cod_nota;
    private double nota_definitiva;
    public frnotas() {
        initComponents();
    }

    public void buscarDatosAsignatura(String SQL)
    {
                String titulos[]={"Cod Proyección","Cod Asignatura", "Asignatura","Nota 1", "Nota 2", "Nota 3"};

        int j,total1=0;
        ResultSet con;
        try
        {

            con=DataBaseOracle.Query("SELECT COUNT(*) FROM  sia_proyecciones p WHERE p.pro_estado=1");
            if(con.next())
            {
              total1=con.getInt(1);
            }
            Object [][] data = new Object[total1][6];
           
            con=DataBaseOracle.Query(SQL);
            j=0;
            while(con.next())
            {
                data[j][0]=con.getString(1);//codigo proyection
                data[j][1]=con.getString(2);//codigo asignatura 
                data[j][2]=con.getString(3);//asignatura
                data[j][3]=con.getString(4);//Corte 1
                data[j][4]=con.getString(5);//Corte 2
                data[j][5]=con.getString(6);//Corte 3
                notas[j]=Integer.parseInt(con.getString(7));//codigo nota

                j++;
            }//end while
           // DefaultTableModel ob =new DefaultTableModel();
            DefaultTableModel dtm = new DefaultTableModel(data,titulos);
            tabla.setModel(dtm);
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
            Object [][] data = new Object[total1+1][4];

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
        jLabel9 = new javax.swing.JLabel();
        fr_estudiantes = new javax.swing.JFrame();
        bt_aceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_estudiantes = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_buscar_est = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigo_estudiante = new javax.swing.JTextField();
        txt_codigo_asignatura = new javax.swing.JTextField();
        txt_codigo_proyeccion = new javax.swing.JTextField();
        txt_1corte = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_2corte = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_3corte = new javax.swing.JTextField();
        bt_guardar = new javax.swing.JButton();
        bt_cancela = new javax.swing.JButton();
        bt_buscar_est = new javax.swing.JButton();
        bt_codigo_asignatura = new javax.swing.JButton();

        btaceptar.setText("Aceptar");
        btaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaceptarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Asignatura", "Nombre", "Codigo Proyección", "corte1", "corte2", "corte3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
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
        tabla.getColumnModel().getColumn(0).setHeaderValue("Codigo Asignatura");
        tabla.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        tabla.getColumnModel().getColumn(2).setHeaderValue("Codigo Proyección");
        tabla.getColumnModel().getColumn(3).setHeaderValue("corte1");
        tabla.getColumnModel().getColumn(4).setHeaderValue("corte2");
        tabla.getColumnModel().getColumn(5).setHeaderValue("corte3");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 24));
        jLabel9.setText("Asignaturas");

        javax.swing.GroupLayout fr_asignaturaLayout = new javax.swing.GroupLayout(fr_asignatura.getContentPane());
        fr_asignatura.getContentPane().setLayout(fr_asignaturaLayout);
        fr_asignaturaLayout.setHorizontalGroup(
            fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fr_asignaturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fr_asignaturaLayout.createSequentialGroup()
                        .addComponent(btaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fr_asignaturaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(fr_asignaturaLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(401, Short.MAX_VALUE))))
        );
        fr_asignaturaLayout.setVerticalGroup(
            fr_asignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fr_asignaturaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
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

        jLabel10.setText("Buscar");

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

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 24));
        jLabel11.setText("Estudiantes");

        javax.swing.GroupLayout fr_estudiantesLayout = new javax.swing.GroupLayout(fr_estudiantes.getContentPane());
        fr_estudiantes.getContentPane().setLayout(fr_estudiantesLayout);
        fr_estudiantesLayout.setHorizontalGroup(
            fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fr_estudiantesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fr_estudiantesLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel10)
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
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fr_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_buscar_est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_aceptar)
                .addGap(35, 35, 35))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Notas Academicas");

        jLabel2.setText("Codigo Estudiante");

        jLabel3.setText("Codigo Proyección");

        jLabel4.setText("Asignatura");

        txt_codigo_estudiante.setEditable(false);

        txt_codigo_asignatura.setEditable(false);

        txt_codigo_proyeccion.setEditable(false);

        jLabel5.setText("1er Corte");

        jLabel6.setText("2do Corte");

        jLabel7.setText("3er Corte");

        bt_guardar.setText("Guardar");
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        bt_cancela.setText("Cancelar");
        bt_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelaActionPerformed(evt);
            }
        });

        bt_buscar_est.setText("...");
        bt_buscar_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscar_estActionPerformed(evt);
            }
        });

        bt_codigo_asignatura.setText("...");
        bt_codigo_asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_codigo_asignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(txt_codigo_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt_buscar_est, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(57, 57, 57)
                        .addComponent(txt_codigo_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_codigo_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_1corte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_2corte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_3corte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_guardar)
                                .addGap(6, 6, 6)
                                .addComponent(bt_cancela))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(21, 21, 21)
                                .addComponent(txt_codigo_proyeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_codigo_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_buscar_est))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(bt_codigo_asignatura)
                    .addComponent(txt_codigo_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(txt_codigo_proyeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_3corte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_1corte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_2corte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_guardar)
                    .addComponent(bt_cancela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bt_buscar_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscar_estActionPerformed
fr_estudiantes.setLocationRelativeTo(null);
fr_estudiantes.setSize(495, 300);
fr_estudiantes.setVisible(true);
  
}//GEN-LAST:event_bt_buscar_estActionPerformed

private void bt_codigo_asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_codigo_asignaturaActionPerformed
  fr_asignatura.setLocationRelativeTo(null);
  fr_asignatura.setSize(500, 301);
  fr_asignatura.setVisible(true);
  String  sql="SELECT p.pro_codigo, a.asi_codigo, a.asi_nombre,  NVL(n.not_1_corte,0), NVL(n.not_2_corte,0), NVL(n.not_3_corte,0), n.not_codigo "+
                "FROM sia_asignaturas a INNER JOIN sia_proyecciones p ON a.asi_codigo=p.asi_codigo "+
                "INNER JOIN sia_estudiantes e ON p.est_codigo=e.est_codigo "+
                "INNER JOIN sia_notas n ON n.pro_codigo=p.pro_codigo "+
                "WHERE e.est_cod_matricula="+txt_codigo_estudiante.getText()+
                " AND a.asi_estado=1 AND p.pro_estado=1 AND e.est_estado=1";
  buscarDatosAsignatura(sql);
}//GEN-LAST:event_bt_codigo_asignaturaActionPerformed

private void btaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaceptarActionPerformed
        // TODO add your handling code here:
        fr_asignatura.setVisible(false);
}//GEN-LAST:event_btaceptarActionPerformed

private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
       
        int i=tabla.getSelectedRow();
        String dato=(String)tabla.getValueAt(i,1);//codigo asignatura
        txt_codigo_asignatura.setText(dato);
        dato=(String)tabla.getValueAt(i,0);//codigo proyeccion
        txt_codigo_proyeccion.setText(dato);
        dato=(String)tabla.getValueAt(i,3);//codigo proyeccion
        txt_1corte.setText(dato);
        dato=(String)tabla.getValueAt(i,4);//codigo proyeccion
        txt_2corte.setText(dato);
        dato=(String)tabla.getValueAt(i,5);//codigo proyeccion
        txt_3corte.setText(dato);
        cod_nota=notas[i];

        
}//GEN-LAST:event_tablaMousePressed

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

private void bt_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelaActionPerformed
this.hide();
}//GEN-LAST:event_bt_cancelaActionPerformed

private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed

     try{
       nota_definitiva = Double.valueOf(txt_1corte.getText())*0.3 + Double.valueOf(txt_2corte.getText())*0.3 + Double.valueOf(txt_3corte.getText())*0.4;
         
        String sql ="UPDATE sia_notas SET not_1_corte="+ Double.parseDouble(txt_1corte.getText())+", not_2_corte="+Double.parseDouble(txt_2corte.getText())+", not_3_corte="+Double.parseDouble(txt_3corte.getText())+ ", not_definitiva="+ nota_definitiva +
                    " WHERE  sia_notas.not_codigo="+cod_nota;
        DataBaseOracle.Execute(sql);
        JOptionPane.showMessageDialog(this, "Notas Guardas");
        this.hide();
        
    
    }catch (Exception de) {
            System.err.println(de.getMessage());
        }
    
    
}//GEN-LAST:event_bt_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(frnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frnotas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_buscar_est;
    private javax.swing.JButton bt_cancela;
    private javax.swing.JButton bt_codigo_asignatura;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton btaceptar;
    private javax.swing.JFrame fr_asignatura;
    private javax.swing.JFrame fr_estudiantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla_estudiantes;
    private javax.swing.JTextField txt_1corte;
    private javax.swing.JTextField txt_2corte;
    private javax.swing.JTextField txt_3corte;
    private javax.swing.JTextField txt_buscar_est;
    private javax.swing.JTextField txt_codigo_asignatura;
    private javax.swing.JTextField txt_codigo_estudiante;
    private javax.swing.JTextField txt_codigo_proyeccion;
    // End of variables declaration//GEN-END:variables
}
