package Vistas;

import DB.Generator.CodeGenerate;
import OAD.PG_L13005_Mantenim_de_Cli;
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
public class TABLA_CLIENTES extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddInforme
     */
    private final PG_L13005_Mantenim_de_Cli PREPARAR_DECLARACION;
    Object [][] dbClientes;
    CustomDefaultTableModel modelo;
    private int filaSeleccionada;
    private GeneradorCodigos nuevo;
    Border BorderCajaNoEditable;
    Border BorderCajaEditable;
    
    public TABLA_CLIENTES() {
        
        initComponents();
        PREPARAR_DECLARACION = new PG_L13005_Mantenim_de_Cli();
        BorderCajaNoEditable = this.CajaCodigoCli.getBorder();
        BorderCajaEditable = this.CajaNomCli.getBorder();
                
        dbClientes = PREPARAR_DECLARACION.obtenerTodasLosClientesQueEsten("A");
        String[] columNames = {"CODIGO","NOMBRE","DIRECCION"}; 
        modelo = new CustomDefaultTableModel(dbClientes, columNames);
        TABLA_MOSTRAR_CIAS.setModel(modelo);
    }

    void limpiar(){
        CajaCodigoCli.setText("");
        CajaDirec.setText("");
        CajaNomCli.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        bGroup_Preg_01 = new javax.swing.ButtonGroup();
        bGroup_Preg_02 = new javax.swing.ButtonGroup();
        bGroup_Preg_03 = new javax.swing.ButtonGroup();
        bGroup_Preg_04 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CajaCodigoCli = new javax.swing.JTextField();
        CajaNomCli = new javax.swing.JTextField();
        CajaDirec = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLA_MOSTRAR_CIAS = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        BotonActualizarCli = new javax.swing.JButton();
        BotonGuardarCli = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

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
        setTitle("CLIENTES");

        jLabel7.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel7.setText("CÓDIGO");

        jLabel8.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel8.setText("NOMBRE");

        jLabel9.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel9.setText("DIREC");

        CajaCodigoCli.setEditable(false);
        CajaCodigoCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaCodigoCliMouseClicked(evt);
            }
        });
        CajaCodigoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaCodigoCliActionPerformed(evt);
            }
        });

        CajaNomCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaNomCliMouseClicked(evt);
            }
        });

        CajaDirec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaDirecMouseClicked(evt);
            }
        });

        TABLA_MOSTRAR_CIAS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TABLA_MOSTRAR_CIAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
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

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("ATRAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        BotonActualizarCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonActualizarCli.setText("ACTUALIZAR");
        BotonActualizarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarCliActionPerformed(evt);
            }
        });

        BotonGuardarCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonGuardarCli.setText("GUARDAR");
        BotonGuardarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CajaCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CajaNomCli, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(CajaDirec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonGuardarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonActualizarCli))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonGuardarCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonActualizarCli))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(CajaCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(CajaNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CajaDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CajaCodigoCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaCodigoCliMouseClicked
        // TODO add your handling code here:
        CajaCodigoCli.setBorder(BorderCajaNoEditable);

        CajaCodigoCli.setText( String.valueOf( CodeGenerate.getCode(Entities.CLIENTES) )  );
    }//GEN-LAST:event_CajaCodigoCliMouseClicked

    private void CajaCodigoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaCodigoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaCodigoCliActionPerformed

    private void CajaNomCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaNomCliMouseClicked
        // TODO add your handling code here:
        CajaNomCli.setBorder(BorderCajaEditable);
    }//GEN-LAST:event_CajaNomCliMouseClicked

    private void CajaDirecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaDirecMouseClicked
        // TODO add your handling code here:
        CajaDirec.setBorder(BorderCajaEditable);
    }//GEN-LAST:event_CajaDirecMouseClicked

    private void TABLA_MOSTRAR_CIASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_MOSTRAR_CIASMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLA_MOSTRAR_CIASMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();        // BOTON ATRAS

    }//GEN-LAST:event_jButton5ActionPerformed

    private void BotonActualizarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarCliActionPerformed
        if( !DatosValidos() )
        return;
        // TODO add your handling code here:
        PREPARAR_DECLARACION.ActualizarClientes(Integer.parseInt( this.CajaCodigoCli.getText()),
            this.CajaNomCli.getText(),
            this.CajaDirec.getText(),
            "A");
        modelo.setValueAt(CajaNomCli.getText(), getFilaSeleccionada(), 1 );
        modelo.setValueAt(CajaDirec.getText(), getFilaSeleccionada(), 2 );
        limpiar();
        CajaCodigoCli.setEnabled(true);
        BotonGuardarCli.setEnabled(true);
        BotonActualizarCli.setEnabled(false);
    }//GEN-LAST:event_BotonActualizarCliActionPerformed

    private void BotonGuardarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarCliActionPerformed
        if( !DatosValidos() )
        return;
        FileGeneradorCodigos file = new FileGeneradorCodigos();
        file.escribir(nuevo);

        PREPARAR_DECLARACION.agregarClientes( Integer.parseInt( this.CajaCodigoCli.getText()),
            this.CajaNomCli.getText(),
            this.CajaDirec.getText(),
            "A");

        String [] datos = new String[4];
        datos[0] = CajaCodigoCli.getText();
        datos[1] = CajaNomCli.getText();
        datos[2] = CajaDirec.getText();

        limpiar();
        modelo.addRow(datos);

    }//GEN-LAST:event_BotonGuardarCliActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila = TABLA_MOSTRAR_CIAS.getSelectedRow();
        if(fila >= 0){
            CajaCodigoCli.setText(TABLA_MOSTRAR_CIAS.getValueAt(fila, 0).toString());
            CajaNomCli.setText(TABLA_MOSTRAR_CIAS.getValueAt(fila, 1).toString());
            CajaDirec.setText(TABLA_MOSTRAR_CIAS.getValueAt(fila, 2).toString());
            CajaCodigoCli.setEnabled(false);
            BotonGuardarCli.setEnabled(false);
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
            PREPARAR_DECLARACION.EliminarClientes( Integer.parseInt( TABLA_MOSTRAR_CIAS.getValueAt(fila, 0).toString() ) );
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
        if( !checkNum(CajaCodigoCli.getText()) ){ 
            CajaCodigoCli.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            flag1 = false;
        }
        if( !checkAlpha(CajaNomCli.getText()) ){
            CajaNomCli.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            flag2 =  false;
        }
        if( !checkAlphayNumber(CajaDirec.getText())  ){
            CajaDirec.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
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
    private javax.swing.JButton BotonActualizarCli;
    private javax.swing.JButton BotonGuardarCli;
    private javax.swing.JTextField CajaCodigoCli;
    private javax.swing.JTextField CajaDirec;
    private javax.swing.JTextField CajaNomCli;
    private javax.swing.JTable TABLA_MOSTRAR_CIAS;
    private javax.swing.ButtonGroup bGroup_Preg_01;
    private javax.swing.ButtonGroup bGroup_Preg_02;
    private javax.swing.ButtonGroup bGroup_Preg_03;
    private javax.swing.ButtonGroup bGroup_Preg_04;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
