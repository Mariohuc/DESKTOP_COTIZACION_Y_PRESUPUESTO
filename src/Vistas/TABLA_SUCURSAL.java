package Vistas;

import DB.Generator.CodeGenerate;
import Datos.PG_L13002_Mantenim_de_Cia;
import Datos.PG_L13004_Mantenim_de_Suc;
import DB.Generator.CustomDefaultTableModel;
import DB.Generator.Entities;
import DB.Generator.FileGeneradorCodigos;
import DB.Generator.GeneradorCodigos;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Vargas
 */
public class TABLA_SUCURSAL extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddInforme
     */
    private final PG_L13004_Mantenim_de_Suc PREPARAR_DECLARACION;
    Object [][] dbSucursales;
    CustomDefaultTableModel modelo;
    private int filaSeleccionada;
    private GeneradorCodigos nuevo;
    Border BorderCajaNoEditable;
    Border BorderCajaEditable;
    
    private final PG_L13002_Mantenim_de_Cia EXTRACTOR_CIAS;
    Object [][] dbCias;
    
    public TABLA_SUCURSAL() {
        
        initComponents();
        PREPARAR_DECLARACION = new PG_L13004_Mantenim_de_Suc();
        BorderCajaNoEditable = this.CajaCodigoSuc.getBorder();
        BorderCajaEditable = this.CajaDescripcionSuc.getBorder();
        
        dbSucursales = PREPARAR_DECLARACION.obtenerTodasLasSucursalesActivas("A");
        String[] columNames = {"CODIGO","DESCRIPCION","EMPRESA"}; 
        modelo = new CustomDefaultTableModel(dbSucursales, columNames);
        TABLA_MOSTRAR_CIAS.setModel(modelo);
        // obtenemos las CIAS para poder mostrar al usuario al momento de introducir la CiaCod
        EXTRACTOR_CIAS = new PG_L13002_Mantenim_de_Cia();
        dbCias = EXTRACTOR_CIAS.obtenerTodasLasCiasQueEsten("A");
        
        for( int i=0;i<dbCias.length; i++)
           ComboBoxNombreCias.addItem( dbCias[i][1] );
        
        
    }

    void limpiar(){
        CajaCodigoSuc.setText("");
        CajaDescripcionSuc.setText("");
        CajaCiaCodigo.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLA_MOSTRAR_CIAS = new javax.swing.JTable();
        BotonActualizarSuc = new javax.swing.JButton();
        BotonGuardarSuc = new javax.swing.JButton();
        CajaDescripcionSuc = new javax.swing.JTextField();
        ComboBoxNombreCias = new javax.swing.JComboBox();
        CajaCiaCodigo = new javax.swing.JTextField();
        CajaCodigoSuc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jMenuItem1.setText("MODIFICAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("ELIMINAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SUCURSAL");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("ATRAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        TABLA_MOSTRAR_CIAS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TABLA_MOSTRAR_CIAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TABLA_MOSTRAR_CIAS.setComponentPopupMenu(jPopupMenu1);
        TABLA_MOSTRAR_CIAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLA_MOSTRAR_CIASMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TABLA_MOSTRAR_CIAS);

        BotonActualizarSuc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonActualizarSuc.setText("ACTUALIZAR");
        BotonActualizarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarSucActionPerformed(evt);
            }
        });

        BotonGuardarSuc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonGuardarSuc.setText("GUARDAR");
        BotonGuardarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarSucActionPerformed(evt);
            }
        });

        CajaDescripcionSuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaDescripcionSucMouseClicked(evt);
            }
        });

        ComboBoxNombreCias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxNombreCiasActionPerformed(evt);
            }
        });

        CajaCiaCodigo.setEditable(false);
        CajaCiaCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaCiaCodigoMouseClicked(evt);
            }
        });
        CajaCiaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaCiaCodigoActionPerformed(evt);
            }
        });

        CajaCodigoSuc.setEditable(false);
        CajaCodigoSuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaCodigoSucMouseClicked(evt);
            }
        });
        CajaCodigoSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaCodigoSucActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel10.setText("CÓDIGO");

        jLabel11.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel11.setText("DESCRIPCION");

        jLabel12.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel12.setText("EMPRESA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CajaCodigoSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CajaDescripcionSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(BotonGuardarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonActualizarSuc))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(CajaCiaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxNombreCias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(131, 131, 131)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardarSuc)
                    .addComponent(CajaCodigoSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonActualizarSuc)
                    .addComponent(jLabel11)
                    .addComponent(CajaDescripcionSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBoxNombreCias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CajaCiaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();        // BOTON ATRAS
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TABLA_MOSTRAR_CIASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_MOSTRAR_CIASMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLA_MOSTRAR_CIASMouseClicked

    private void BotonActualizarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarSucActionPerformed
        // TODO add your handling code here:
        if( !DatosValidos() )
        return;
        PREPARAR_DECLARACION.ActualizarSucursal(Integer.parseInt( this.CajaCodigoSuc.getText()),
            this.CajaDescripcionSuc.getText(),
            "A",
            Integer.parseInt( this.CajaCiaCodigo.getText() ));

        modelo.setValueAt(CajaDescripcionSuc.getText(), getFilaSeleccionada(), 1 );
        modelo.setValueAt(CajaCiaCodigo.getText(), getFilaSeleccionada(), 2 );
        limpiar();
        CajaCodigoSuc.setEnabled(true);
        BotonGuardarSuc.setEnabled(true);
        BotonActualizarSuc.setEnabled(false);
    }//GEN-LAST:event_BotonActualizarSucActionPerformed

    private void BotonGuardarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarSucActionPerformed
        // TODO add your handling code here:
        if( !DatosValidos() )
        return;
        FileGeneradorCodigos file = new FileGeneradorCodigos();
        file.escribir(nuevo);

        PREPARAR_DECLARACION.agregarSucursal(Integer.parseInt( this.CajaCodigoSuc.getText()),
            this.CajaDescripcionSuc.getText(),
            "A",
            Integer.parseInt( this.CajaCiaCodigo.getText() ));

        String [] datos = new String[4];
        datos[0] = CajaCodigoSuc.getText();
        datos[1] = CajaDescripcionSuc.getText();
        datos[2] = CajaCiaCodigo.getText();

        limpiar();
        modelo.addRow(datos);

    }//GEN-LAST:event_BotonGuardarSucActionPerformed

    private void CajaDescripcionSucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaDescripcionSucMouseClicked
        // TODO add your handling code here:
        CajaDescripcionSuc.setBorder(BorderCajaEditable);
    }//GEN-LAST:event_CajaDescripcionSucMouseClicked

    private void ComboBoxNombreCiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxNombreCiasActionPerformed
        // TODO add your handling code here:
        int registerRow = ComboBoxNombreCias.getSelectedIndex();
        CajaCiaCodigo.setText( dbCias[registerRow][0].toString() );
    }//GEN-LAST:event_ComboBoxNombreCiasActionPerformed

    private void CajaCiaCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaCiaCodigoMouseClicked
        // TODO add your handling code here:
        CajaCiaCodigo.setBorder(BorderCajaNoEditable);
    }//GEN-LAST:event_CajaCiaCodigoMouseClicked

    private void CajaCiaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaCiaCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaCiaCodigoActionPerformed

    private void CajaCodigoSucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaCodigoSucMouseClicked
        // TODO add your handling code here:
        CajaCodigoSuc.setBorder(BorderCajaNoEditable );
        
        CajaCodigoSuc.setText( String.valueOf( CodeGenerate.getCode(Entities.SUCURSALES) )  );
    }//GEN-LAST:event_CajaCodigoSucMouseClicked

    private void CajaCodigoSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaCodigoSucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaCodigoSucActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila = TABLA_MOSTRAR_CIAS.getSelectedRow();
        if(fila >= 0){
            CajaCodigoSuc.setText(TABLA_MOSTRAR_CIAS.getValueAt(fila, 0).toString());
            CajaDescripcionSuc.setText(TABLA_MOSTRAR_CIAS.getValueAt(fila, 1).toString());
            CajaCiaCodigo.setText(TABLA_MOSTRAR_CIAS.getValueAt(fila, 2).toString());
            ComboBoxNombreCias.setSelectedItem("");
            CajaCodigoSuc.setEnabled(false);
            BotonGuardarSuc.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "No se selecciono fila");
        }
        setFilaSeleccionada( fila );
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila = TABLA_MOSTRAR_CIAS.getSelectedRow();
        if(fila >= 0){
            PREPARAR_DECLARACION.EliminarSucursal(Integer.parseInt( TABLA_MOSTRAR_CIAS.getValueAt(fila, 0).toString() ) );
        }
        else{
            JOptionPane.showMessageDialog(null, "No se selecciono fila");
        }
        modelo.removeRow(fila);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
 /*
    *Funciones de validacion de elementos
    *
    */
    public void setFilaSeleccionada( int row ){
        filaSeleccionada = row;
    }
    public int getFilaSeleccionada(){
        return filaSeleccionada;
    }
    
    
    public boolean DatosValidos( ){
        boolean flag1, flag2,flag3;
        flag1 = flag2 = flag3 = true;
        if( !checkNum(CajaCodigoSuc.getText()) ){ 
            CajaCodigoSuc.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            flag1 = false;
        }
        if( !checkAlphayNumber(CajaDescripcionSuc.getText()) ){
            CajaDescripcionSuc.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            flag2 =  false;
        }
        if( !checkNum(CajaCiaCodigo.getText())  ){
            CajaCiaCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            flag3 = false;    
        }
        return ( flag1 && flag2 && flag3);
    }
    
    public boolean checkAlpha(String cadena) {
	boolean respuesta = false;
	if ((cadena).matches("([a-z]|[A-Z]|\\s)+")) {
            respuesta = true;
	}
        return respuesta;	
    }
    public boolean checkAlphayNumber(String cadena) {
	boolean respuesta = false;
	if ((cadena).matches("([a-z]|[A-Z]|[0-9]|\\s|\\.|\\-)+")) {
            respuesta = true;
	}
	return respuesta;
    }
    public boolean checkNum(String str){ 
        boolean respuesta = false; 
        if ((str).matches("([0-9])+")) { 
            respuesta = true; 
        } 
        return respuesta; 
    }
    
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonActualizarSuc;
    private javax.swing.JButton BotonGuardarSuc;
    private javax.swing.JTextField CajaCiaCodigo;
    private javax.swing.JTextField CajaCodigoSuc;
    private javax.swing.JTextField CajaDescripcionSuc;
    private javax.swing.JComboBox ComboBoxNombreCias;
    private javax.swing.JTable TABLA_MOSTRAR_CIAS;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
