import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class INGRESAR_LOGIN extends javax.swing.JFrame {
    
    public static String user = "jose";
    public static String pass = "jose";
    public static int tiempo_carga = 10;
    
    public INGRESAR_LOGIN() {
        initComponents();
        LOGIN_FONDO F = new LOGIN_FONDO();  
        this.jPanel1.add(F,BorderLayout.CENTER);
        this.pack();   
    }        
    private void cerrar(){
        this.dispose(); 
    }
    public Timer objetotimer;
    public int a;
    public class claseTimer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        a=jProgressBar1.getValue();
        if (a <100){
            a++;
            jProgressBar1.setValue(a);
        }
        else{
            objetotimer.stop();
            MENU_SISTEMA fr2=new MENU_SISTEMA(); 
            fr2.setEnabled(true);
            fr2.show();
            cerrar();
        }                  
          
        }
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cj_usuario = new javax.swing.JTextField();
        cj_pass = new javax.swing.JPasswordField();
        btn_entrar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(382, 501));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cj_usuario.setBackground(new java.awt.Color(110, 216, 145));
        cj_usuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        cj_usuario.setForeground(new java.awt.Color(255, 255, 255));
        cj_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cj_usuario.setText("USER");
        cj_usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cj_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cj_usuarioMouseClicked(evt);
            }
        });
        cj_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cj_usuarioKeyTyped(evt);
            }
        });

        cj_pass.setBackground(new java.awt.Color(110, 216, 145));
        cj_pass.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        cj_pass.setForeground(new java.awt.Color(255, 255, 255));
        cj_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cj_pass.setText("PASSWORD");
        cj_pass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cj_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cj_passMouseClicked(evt);
            }
        });
        cj_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cj_passKeyTyped(evt);
            }
        });

        btn_entrar.setBackground(new java.awt.Color(35, 188, 90));
        btn_entrar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrar.setText("LOGIN");
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });

        jProgressBar1.setForeground(new java.awt.Color(0, 150, 0));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 95, 11), 2));
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cj_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cj_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(cj_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cj_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(398, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        // TODO add your handling code here:        
        String usuario = cj_usuario.getText().trim();        
        String contraseña = new String(cj_pass.getPassword());
        objetotimer = new Timer(tiempo_carga,new INGRESAR_LOGIN.claseTimer());
        if( usuario.equalsIgnoreCase(user) && contraseña.equalsIgnoreCase(pass)){
            objetotimer.start();
//            MENU_SISTEMA b = new MENU_SISTEMA();
//            b.setVisible(true);
//            dispose();
        }
        else if( usuario.isEmpty() && contraseña.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Ingrese Usuario y Contraseña");
        }
        else if( usuario != user && contraseña != pass ){
            JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos", "Error Al Ingresar", JOptionPane.ERROR_MESSAGE);
        }
        else if( usuario != user ){
            JOptionPane.showMessageDialog(null, "Usuario Incorrecto", "Usuario No Existe", JOptionPane.ERROR_MESSAGE);
        }
        else if( contraseña != pass ){
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Contraseña Mal Escrita", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_entrarActionPerformed

    private void cj_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cj_usuarioKeyTyped
        // TODO add your handling code here:
        int c = evt.getKeyChar();
        if ( c == 10 )
            {
            cj_pass.requestFocus();
            }
    }//GEN-LAST:event_cj_usuarioKeyTyped

    private void cj_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cj_passKeyTyped
        // TODO add your handling code here:
        
        int c = evt.getKeyChar();
        if( c==10 )
        {
        String usuario = cj_usuario.getText().trim();        
        String contraseña = new String(cj_pass.getPassword());
        
        if( usuario.equalsIgnoreCase(user) && contraseña.equalsIgnoreCase(pass) )
            {
            MENU_SISTEMA b = new MENU_SISTEMA();
            b.setVisible(true);
            dispose();
            }
        else if( usuario.isEmpty() && contraseña.isEmpty() )
            {
            JOptionPane.showMessageDialog(null, "Ingrese Usuario y Contraseña");
            }
        else if( usuario != user && contraseña != pass )
            {
            JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos", "Error Al Ingresar", JOptionPane.ERROR_MESSAGE);
            }
        else if( usuario != user )
            {
            JOptionPane.showMessageDialog(null, "Usuario Incorrecto", "Usuario No Existe", JOptionPane.ERROR_MESSAGE);
            }
        else if( contraseña != pass )
            {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Contraseña Mal Escrita", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cj_passKeyTyped

    private void cj_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cj_usuarioMouseClicked
        // TODO add your handling code here:
        cj_usuario.setText("");
    }//GEN-LAST:event_cj_usuarioMouseClicked

    private void cj_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cj_passMouseClicked
        // TODO add your handling code here:
        cj_pass.setText("");
    }//GEN-LAST:event_cj_passMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INGRESAR_LOGIN().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JPasswordField cj_pass;
    private javax.swing.JTextField cj_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
