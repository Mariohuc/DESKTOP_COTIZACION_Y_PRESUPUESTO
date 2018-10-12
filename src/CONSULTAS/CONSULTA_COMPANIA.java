package CONSULTAS;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultasClientes.java
 *
 * Created on 15-abr-2013, 8:33:48
 */


import Relaciones.CustomDefaultTableModel;
import claseConectar.Conector;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Administrador
 */
public class CONSULTA_COMPANIA extends javax.swing.JInternalFrame {
 
    private Connection cn = Conector.conexion();
    private String ConsultaSQL;
    
    public CONSULTA_COMPANIA() {
        initComponents();
        txtcodCia.setEnabled(false);
        ResultSet resultado;
        
        try{
            Statement st = cn.createStatement();
            resultado = st.executeQuery(" SHOW TABLES LIKE 'VISTA_CIAS'");
            int rs;
            if ( ! resultado.next() )
                rs = st.executeUpdate("CREATE VIEW VISTA_CIAS AS  SELECT * FROM CIAS ");
            
            ConsultaSQL = "SELECT * FROM VISTA_CIAS";
            CargarlistaCias();
        
        }catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            close();
        } // fin de catch
    }
    void CargarlistaCias()          
    {
        CustomDefaultTableModel modelo= new CustomDefaultTableModel();
        String []Titulos = {"CODIGO","NOMBRE CIA","RUC"};
        modelo.setColumnIdentifiers(Titulos);
         this.tbcias.setModel(modelo);
        try {
        
            String []registros= new String[3];
           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(ConsultaSQL);
            while(rs.next())
            {
                registros[0]=rs.getString("CiaCod");
                registros[1]=rs.getString("CiaNom");
                registros[2]=rs.getString("CiaRUC");  
                modelo.addRow(registros);
                                
            }
            tbcias.setModel(modelo);
            txtcant.setText(""+tbcias.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(CONSULTA_COMPANIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btncodigo = new javax.swing.JRadioButton();
        todo = new javax.swing.JRadioButton();
        txtcodCia = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        activos = new javax.swing.JRadioButton();
        eliminadas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DE COMPAÑIAS");

        buttonGroup1.add(btncodigo);
        btncodigo.setText("Buscar Cias por codigo:");
        btncodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncodigoActionPerformed(evt);
            }
        });

        buttonGroup1.add(todo);
        todo.setText("Mostrar todos las Cias");
        todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoActionPerformed(evt);
            }
        });

        txtcodCia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodCiaActionPerformed(evt);
            }
        });

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(activos);
        activos.setText("Mostrar todas las Cias activas");
        activos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activosActionPerformed(evt);
            }
        });

        buttonGroup1.add(eliminadas);
        eliminadas.setText("Mostrar todas las Cias eliminadas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(eliminadas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(todo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btncodigo)
                                .addGap(38, 38, 38)
                                .addComponent(txtcodCia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(activos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncodigo)
                            .addComponent(txtcodCia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(todo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminadas)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tbcias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbcias);

        jLabel1.setText("Cantidad de Registros");

        txtcant.setEnabled(false);

        jButton2.setText("Generar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
// TODO add your handling code here:
  
  String codigo= txtcodCia.getText();  
  if(activos.isSelected()==true)
   {
        ConsultaSQL = "SELECT * FROM VISTA_CIAS WHERE CiaEstReg = 'A' ";
           CargarlistaCias();
   }
  if(eliminadas.isSelected()==true){
        ConsultaSQL = "SELECT * FROM VISTA_CIAS WHERE CiaEstReg = '*' ";
           CargarlistaCias();     
  }
   if( btncodigo.isSelected()==true)
   {      
        ConsultaSQL = "SELECT * FROM VISTA_CIAS WHERE CiaCod = "+codigo;
           CargarlistaCias();                  
   }
   if(todo.isSelected()==true)
   {
       ConsultaSQL = "SELECT * FROM VISTA_CIAS";
       CargarlistaCias();
   }
   
}//GEN-LAST:event_btnbuscarActionPerformed

private void btncodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncodigoActionPerformed
// TODO add your handling code here:
    if(btncodigo.isSelected()==true)
    {       
        txtcodCia.setEnabled(true);
        txtcodCia.requestFocus();
    }
}//GEN-LAST:event_btncodigoActionPerformed

private void todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoActionPerformed
// TODO add your handling code here:
    CargarlistaCias();
    txtcodCia.setText("");
    txtcodCia.setEnabled(false);
}//GEN-LAST:event_todoActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
//    List lista = new ArrayList();
//    for(int i=0;i<tbclientes.getRowCount();i++)
//    {
//        listaclientes clientes= new listaclientes(tbclientes.getValueAt(i, 0).toString(), 
//                tbclientes.getValueAt(i, 1).toString(), tbclientes.getValueAt(i, 2).toString(), tbclientes.getValueAt(i, 4).toString(), tbclientes.getValueAt(i, 6).toString());
//        lista.add(clientes);
//    }
//        try {
//            JasperReport reporte= (JasperReport) JRLoader.loadObject("reportescliente.jasper");
//            Map parametro = new HashMap();
//            parametro.put("genero", cbogenero.getSelectedItem());
//            
//            JasperPrint jprint= JasperFillManager.fillReport(reporte, parametro,new JRBeanCollectionDataSource(lista));
//            JasperViewer.viewReport(jprint,false);
//        } catch (JRException ex) {
//            Logger.getLogger(CONSULTA_CLIENTES.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
    
}//GEN-LAST:event_jButton2ActionPerformed

    public void close(){
        try{
            cn.close();
        } // fin de try
        catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } // fin de catch
    } // fin del método close
    
    private void txtcodCiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodCiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodCiaActionPerformed

    private void activosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activos;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JRadioButton btncodigo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton eliminadas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbcias;
    private javax.swing.JRadioButton todo;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtcodCia;
    // End of variables declaration//GEN-END:variables



}
