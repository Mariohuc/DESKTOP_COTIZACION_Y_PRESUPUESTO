package Vistas.Consultas;

import Datos.PG_L13002_Mantenim_de_Cia;
import Datos.PG_L13003_Mantenim_de_Ven;
import Datos.PG_L13004_Mantenim_de_Suc;
import Datos.PG_L13005_Mantenim_de_Cli;
import DB.Generator.CustomDefaultTableModel;
import DB.Generator.FileGeneradorCodigos;
import DB.Generator.GeneradorCodigos;
import DB.Conector;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Vargas
 */
public class CONSULTA_COTIZACION extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddInforme
     */
    private final PG_L13005_Mantenim_de_Cli EXTRACTOR_CLIENTES;
    Object [][] dbClientes;
    
    CustomDefaultTableModel modelo;
    private int filaSeleccionada;
    private GeneradorCodigos nuevo;
    Border BorderCajaNoEditable;
    Border BorderCajaEditable;
    
    PG_L13002_Mantenim_de_Cia EXTRACTOR_CIAS;
    Object [][] dbCias;
    
    Object [][] dbSucursales;
    
    PG_L13003_Mantenim_de_Ven EXTRACTOR_VENDEDORES; 
    Object [][] dbVendedores;
   
    Connection cn= null;
    public CONSULTA_COTIZACION() {
        
        initComponents();
        EXTRACTOR_CLIENTES = new PG_L13005_Mantenim_de_Cli();
        try {       
            cn= Conector.conexion();
        } catch (SQLException ex) {
            Logger.getLogger(CONSULTA_COTIZACION.class.getName()).log(Level.SEVERE, null, ex);
        }
        // obtenemos las CIAS para poder mostrar al usuario al momento de introducir la CiaCod
        EXTRACTOR_CIAS = new PG_L13002_Mantenim_de_Cia();
        dbCias = EXTRACTOR_CIAS.obtenerTodasLasCiasQueEsten("A");
        
        for( int i=0;i<dbCias.length; i++)
           ComboBoxNombreCias.addItem( dbCias[i][1] );
        
        // obtenemos los Vendedores para poder mostrar al usuario al momento de introducir la CiaCod
        EXTRACTOR_VENDEDORES = new PG_L13003_Mantenim_de_Ven();
        dbVendedores = EXTRACTOR_VENDEDORES.obtenerTodasLosVendedoresQueEsten("A");
        
        for( int i=0;i<dbVendedores.length; i++)
           ComboBoxNombreVen.addItem(dbVendedores[i][1] );
        
        // obtenemos los Vendedores para poder mostrar al usuario al momento de introducir la CiaCod
        dbClientes = EXTRACTOR_CLIENTES.obtenerTodasLosClientesQueEsten("A");
        
        for( int i=0;i<dbClientes.length; i++)
           ComboBoxNombreCli.addItem(dbClientes[i][1] );
        
    }

    void limpiar(){

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
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxCodCotizacion = new javax.swing.JCheckBox();
        ComboBoxNombreVen = new javax.swing.JComboBox();
        txtCodCotizacion = new javax.swing.JTextField();
        ComboBoxNombreCli = new javax.swing.JComboBox();
        fechaI = new com.toedter.calendar.JDateChooser();
        fechaF = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxNombreCias = new javax.swing.JComboBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        ComboBoxNombreSuc = new javax.swing.JComboBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBoxCia = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLA_CONSULTA_CLIENTE = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BotonGuardarCli = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

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

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CLIENTES");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("ATRAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jCheckBoxCodCotizacion.setText("CODIGO");
        jCheckBoxCodCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCodCotizacionActionPerformed(evt);
            }
        });

        jCheckBox1.setText("SUCURSAL");

        jLabel1.setText("---");

        ComboBoxNombreCias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxNombreCiasActionPerformed(evt);
            }
        });

        jCheckBox5.setText("CLIENTE");

        jCheckBox4.setText("VENDEDOR");

        jCheckBoxCia.setText("COMPAÑIAS");
        jCheckBoxCia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCiaActionPerformed(evt);
            }
        });

        jCheckBox2.setText("FECHA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCia)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBoxCodCotizacion))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboBoxNombreCias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxNombreSuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxNombreVen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxNombreCli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCodCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxCodCotizacion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxCia)
                            .addComponent(ComboBoxNombreCias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(ComboBoxNombreSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox4)
                            .addComponent(ComboBoxNombreVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox5)
                            .addComponent(ComboBoxNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox2)
                                .addComponent(fechaF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(fechaI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        TABLA_CONSULTA_CLIENTE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TABLA_CONSULTA_CLIENTE.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLA_CONSULTA_CLIENTE.setComponentPopupMenu(jPopupMenu1);
        TABLA_CONSULTA_CLIENTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLA_CONSULTA_CLIENTEMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TABLA_CONSULTA_CLIENTE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        BotonGuardarCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonGuardarCli.setText("BUSCAR");
        BotonGuardarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonGuardarCli, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonGuardarCli)
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 239, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TABLA_CONSULTA_CLIENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_CONSULTA_CLIENTEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLA_CONSULTA_CLIENTEMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();        // BOTON ATRAS

    }//GEN-LAST:event_jButton5ActionPerformed

    
    private void BotonGuardarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarCliActionPerformed
    
        SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
        String fec1 = formatofecha.format(fechaI.getDate()); 
        System.out.print( "      " + fec1 );
    
    String num=txtCodCotizacion.getText();
    String consulta="";
    if(jCheckBoxCodCotizacion.isSelected()==true)
    {
        consulta= "SELECT * FROM cotizacion_cab WHERE CiaCod='"+num+"'";
    }
//    if(rdbbnfecha.isSelected()==true)
//    {
//           Date fecha=jDateChooser1.getDate();
//   SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
//String fec=""+formatofecha.format(fecha);
//        consulta= "SELECT * FROM factura WHERE fec_fac='"+fec+"'";
//    }
//    if(rdbntodos.isSelected()==true)
//    {
//        consulta= "SELECT * FROM factura ";
//    }
//        DefaultTableModel tabla= new DefaultTableModel();
//        String []titulos={"COD. COTIZACION","COD. CLIENTE","COD. COMPAÑIA","SUBTOTAL","IGV","TOTAL","FECHA"};
//        tabla.setColumnIdentifiers(titulos);
//        this.TABLA_CONSULTA_CLIENTE.setModel(tabla);
//        
//        String []Datos= new String [7];
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs= st.executeQuery(consulta);
//            while(rs.next())
//            {
//                Datos[0]=rs.getString("CotCabNum");
//                Datos[1]=rs.getString("cod_cli");
//                Datos[2]=rs.getString("ruc_cli");
//                Datos[3]=rs.getString("subtotal");
//                Datos[4]=rs.getString("igv");
//                Datos[5]=rs.getString("total");
//                Datos[6]=rs.getString("fec_fac");
//                
//                tabla.addRow(Datos);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CONSULTA_COTIZACION.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//   
//   
    }//GEN-LAST:event_BotonGuardarCliActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila = TABLA_CONSULTA_CLIENTE.getSelectedRow();
        if(fila >= 0){
            EXTRACTOR_CLIENTES.EliminarClientes( Integer.parseInt( TABLA_CONSULTA_CLIENTE.getValueAt(fila, 0).toString() ) );
        }
        else{
            JOptionPane.showMessageDialog(null, "No se selecciono fila");
        }
        modelo.removeRow(fila);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBoxCiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCiaActionPerformed

    private void jCheckBoxCodCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCodCotizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCodCotizacionActionPerformed

    private void ComboBoxNombreCiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxNombreCiasActionPerformed
        // TODO add your handling code here:
         if( ComboBoxNombreCias.getSelectedIndex() == -1 )
            return;
        int registerRow = ComboBoxNombreCias.getSelectedIndex();
        String codCia = dbCias[registerRow][0].toString();
        
        // PARTE DE COMBOBOX DE SUCURSALes
            PG_L13004_Mantenim_de_Suc SUCURSALES = new PG_L13004_Mantenim_de_Suc();
            dbSucursales = SUCURSALES.obtenerSucursalesDeCiaActivas("A", codCia  );
            
            ComboBoxNombreSuc.removeAllItems();
            
            for( int i=0;i<dbSucursales.length; i++)
               ComboBoxNombreSuc.addItem( dbSucursales[i][1] );
            
    }//GEN-LAST:event_ComboBoxNombreCiasActionPerformed
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
    private javax.swing.JButton BotonGuardarCli;
    private javax.swing.JComboBox ComboBoxNombreCias;
    private javax.swing.JComboBox ComboBoxNombreCli;
    private javax.swing.JComboBox ComboBoxNombreSuc;
    private javax.swing.JComboBox ComboBoxNombreVen;
    private javax.swing.JTable TABLA_CONSULTA_CLIENTE;
    private javax.swing.ButtonGroup bGroup_Preg_01;
    private javax.swing.ButtonGroup bGroup_Preg_02;
    private javax.swing.ButtonGroup bGroup_Preg_03;
    private javax.swing.ButtonGroup bGroup_Preg_04;
    private com.toedter.calendar.JDateChooser fechaF;
    private com.toedter.calendar.JDateChooser fechaI;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBoxCia;
    private javax.swing.JCheckBox jCheckBoxCodCotizacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtCodCotizacion;
    // End of variables declaration//GEN-END:variables
}
