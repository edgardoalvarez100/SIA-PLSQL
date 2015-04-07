
import javax.swing.JOptionPane;
import java.sql.*;

public class nuevo_asignatura extends javax.swing.JFrame {

    /** Creates new form nuevo_asignatura */
    public nuevo_asignatura() {
        initComponents();
        secuencia_codigo();
    }

    
    
    public void secuencia_codigo(){
    try{
       ResultSet con;
        String sql="SELECT LAST_NUMBER FROM user_sequences WHERE SEQUENCE_NAME = 'INC_ASIGNATURA_PK'";
    con=DataBaseOracle.Query(sql);
      while(con.next()){
          String consulta = con.getString(1);
          int n = Integer.parseInt(consulta);
          consulta = String.valueOf(n);
        lbcodigo.setText(consulta);
    }
      con.close();
    }
     catch (Exception de) {
            System.err.println(de.getMessage());
        }
}
    public boolean validar(){
        if(txt_descripcion.getText().equals("")){
            JOptionPane.showMessageDialog( this, "Escriba una descripción");
            return false;
        }
         if(ht.getText().equals("")){
            JOptionPane.showMessageDialog( this, "Escriba horas teoricas");
            return false;
        }
          if(hp.getText().equals("")){
            JOptionPane.showMessageDialog( this, "Escriba horas practicas");
            return false;
        }
            
        return true;
    }
    
    public void calcular_credito(){
        int resultado, horai, horap, horat;
        
             
        if(validar()){
            if("A".equals(txt_tipo.getSelectedItem())){
                
              horap =Integer.parseInt(hp.getText());
              horat  =Integer.parseInt(ht.getText());
              horai = horat*2;
              hi.setText(Integer.toString(horai));
              resultado = (horat+horap+horai)*16/48;
              txt_credito.setText(Integer.toString(resultado));
            }
            
            if("B".equals(txt_tipo.getSelectedItem())){
                
               horap =Integer.parseInt(hp.getText());
              horat  =Integer.parseInt(ht.getText());
              horai = horat+horap;
              hi.setText(Integer.toString(horai));
              resultado = (horat+horap+horai)*16/48;
              txt_credito.setText(Integer.toString(resultado));
            }
        }            
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbcodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        ht = new javax.swing.JTextField();
        hp = new javax.swing.JTextField();
        hi = new javax.swing.JTextField();
        txt_tipo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txt_credito = new javax.swing.JTextField();
        bt_guardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_calcular = new javax.swing.JButton();

        setTitle("Nueva Asignatura");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Nueva Asignatura");

        jLabel2.setText("Codigo");

        lbcodigo.setFont(new java.awt.Font("Tahoma", 1, 13));
        lbcodigo.setText("0000000");

        jLabel4.setText("Descripción");

        jLabel5.setText("Horas Teorica");

        jLabel6.setText("Horas Practicas");

        jLabel7.setText("Horas Independientes");

        jLabel8.setText("Tipo");

        ht.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                htKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                htKeyTyped(evt);
            }
        });

        hi.setEditable(false);

        txt_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B" }));

        jLabel9.setText("Credito");

        txt_credito.setEditable(false);
        txt_credito.setFont(new java.awt.Font("Tahoma", 1, 11));

        bt_guardar.setText("Guardar");
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bt_calcular.setText("Calcular");
        bt_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_calcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcodigo)
                                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_credito, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hi, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hp, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ht, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_calcular))
                                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(170, Short.MAX_VALUE)
                        .addComponent(bt_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbcodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(ht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_credito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_calcular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(bt_guardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bt_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_calcularActionPerformed
calcular_credito();

}//GEN-LAST:event_bt_calcularActionPerformed

private void htKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_htKeyPressed
  
}//GEN-LAST:event_htKeyPressed

private void htKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_htKeyTyped
 
}//GEN-LAST:event_htKeyTyped

private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
calcular_credito();

 try{
       if (validar()){
                             
        String sql ="INSERT INTO sia_asignaturas VALUES(INC_ASIGNATURA_PK.NextVal, '"+txt_descripcion.getText()+"', 1, "+txt_credito.getText()+", "+ht.getText()+", "+hp.getText()+", "+hi.getText()+", '"+txt_tipo.getSelectedItem()+"')";

        DataBaseOracle.Execute(sql);
        JOptionPane.showMessageDialog(this, "Nueva asignatura guardada");
        this.hide();
        
        
        
    } 
    }catch (Exception de) {
            System.err.println(de.getMessage());
        }
    
    

}//GEN-LAST:event_bt_guardarActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.hide();
}//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(nuevo_asignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevo_asignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevo_asignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevo_asignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new nuevo_asignatura().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_calcular;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JTextField hi;
    private javax.swing.JTextField hp;
    private javax.swing.JTextField ht;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JTextField txt_credito;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JComboBox txt_tipo;
    // End of variables declaration//GEN-END:variables
}
