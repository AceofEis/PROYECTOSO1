/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;
import Conectar.Coneccion;//Import de la clase Coneccion que se encuentra en el paquete Conectar
//Inicio de Imports que permiten la manipulación de la información de la base de datos
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Fin de Imports que permiten la manipulación de la información de la base de datos
import java.util.Date;//Import que permite la utilización de fechas
import javax.swing.JOptionPane;//Import que permite mostrar mensajes en pantalla
/**
 *
 * @author Eisner López y Diego Murillo
 */
public class Login extends javax.swing.JFrame {
    /**
     * Variable que se utilizará en esta clase
     */
    Coneccion cc = new Coneccion();
    Connection con = cc.conexion();
    /**
     * Medoto principal en el que se cargan los datos y componentes necesarios para mostrar la ventana
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 390));
        setMinimumSize(new java.awt.Dimension(480, 390));
        setPreferredSize(new java.awt.Dimension(480, 390));
        getContentPane().setLayout(null);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 278, 100, 30);

        txtNombre.setBackground(new java.awt.Color(213, 222, 223));
        txtNombre.setBorder(null);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(230, 110, 200, 30);

        txtPass.setBackground(new java.awt.Color(213, 222, 223));
        txtPass.setBorder(null);
        getContentPane().add(txtPass);
        txtPass.setBounds(230, 170, 200, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Login-Form.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 550, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(acceder(txtNombre.getText(), txtPass.getText())){
            Reproducto1 reproductor = new Reproducto1();
            reproductor.setVisible(true);
            reproductor.pack();
//            reproductorMP3.lblUsuario.setText(usuario);
//                Buscar buscar = new Buscar();
//                buscar.setVisible(true);
//                this.setVisible(false);
//                Buscar.jLabel2.setText(usuario);
        }
        this.dispose();
//        if ((usuario.isEmpty()) || (password.isEmpty())) {
//            JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña");
//        } else {
//            this.setVisible(true);
////            dialogo.setVisible(false);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Metodo que permite realizar la consulta en la base de datos para verificar que el usuario
     * y la contraseña coincidan
     * @param usuario
     * @param pass
     * @return 
     */
    public boolean acceder(String usuario, String pass){
        boolean ingreso=false;
        Date date = new Date();
        Date date_Caducidad = new Date();
        String sql = "Select * from usuarios where nombre_usuario = '" + usuario + "' and palabra_clave = '" + pass + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                date_Caducidad = rs.getDate(5);
            }
            if(date.before(date_Caducidad)){//Verifica si la fecha de cadudidad consultada es mayor a la actual
                JOptionPane.showMessageDialog(null, "Bienvenido");
                ingreso=true;
            }else{
                JOptionPane.showMessageDialog(null, "Lo sentimos, ha finalizado su tiempo para utilizar este sistema.");
            }   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ingreso;
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
