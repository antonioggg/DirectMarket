/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;
import Logica.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author nando
 */
public class frmRegistrarUsuario extends javax.swing.JFrame {
    CtrlUsuario clu=new CtrlUsuario();
 int longitudBytes;
FileInputStream fis;   

    /**
     * Creates new form frmRegistrarUsuario
     */
    public frmRegistrarUsuario() {
        initComponents();
        setTitle("Registrar Usuarios");
        nombrefoto.setVisible(false);
        lblRuta.setVisible(false);
        setLocationRelativeTo(null);
        lblcompania.setVisible(false);
        lbllink.setVisible(false);
        txtcompania.setVisible(false);
        txtlink.setVisible(false);
    }
    
   public void limpiar(){
    txtapelido.setText("");
    txtcompania.setText("");
    txtlink.setText("");
    txtmail.setText("");
    txtnick.setText("");
    txtnombre.setText("");
    lblRuta.setText("");
    nombrefoto.setText("");
    Foto.setIcon(null);
    }
    
    public void existeNick(){
    String nick=txtnick.getText();//capturo nick
    boolean si=clu.existenick(nick);//pregunto al controlador
    if(si){JOptionPane.showMessageDialog(null, "El nick yá está en uso.\nIngrese un nuevo nick ", "Error..!!", JOptionPane.ERROR_MESSAGE);
    txtnick.setText("");
    txtnick.requestFocus();
    }
    }
    public void existeEmail(){
    String mail=txtmail.getText();//capturo mail
    boolean si=clu.existemail(mail);//pregunto al controlador
    if(si){JOptionPane.showMessageDialog(null, "El email pertenece a otro usuario.\nIngrese un nuevo email ", "Error..!!", JOptionPane.ERROR_MESSAGE);
    txtmail.setText("");
    txtmail.requestFocus();
    }
    }
    
    
    
    
    public void guardarPerfil(){
        String fecha="";
        String vac="";
        String prov="proveedor";
       String clie="cliente";
       String nic,nom,ape,ima,tip,mail,nomcom="",lincom="";
       nom=txtnombre.getText();
       nic=txtnick.getText();
       mail=txtmail.getText();
       ape=txtapelido.getText();
       ima=nombrefoto.getText();
       
       //dia=txtfecha.getToolTipText();
       try {
String formato = jDateChooser1.getDateFormatString();
Date date = jDateChooser1.getDate();
SimpleDateFormat sdf = new SimpleDateFormat(formato);
 fecha=String.valueOf(sdf.format(date));
} catch (Exception e) {
JOptionPane.showMessageDialog(null, "Elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);
}
       if(txtnick.getText().equals(vac)||txtnombre.getText().equals(vac)||txtmail.getText().equals(vac)||txtapelido.getText().equals(vac)||fecha.equals(vac)||Foto.getIcon()==null){
   JOptionPane.showMessageDialog(null, "Complete todos los campos ", "Error..!!", JOptionPane.ERROR_MESSAGE);    
       }else{
       if(botonprovedor.isSelected()){
           nomcom=txtcompania.getText();
           lincom=txtlink.getText();
       Proveedor pro=new Proveedor(nic, nom, ape, fecha, ima, prov, mail,nomcom, lincom);
       clu.guardarProvedor(pro);
       Menu men=new Menu();
       limpiar();
       men.setVisible(true);
      this.dispose();
       }
       else{
       Cliente cli=new Cliente(nic, nom, ape, fecha, ima ,clie,mail);
       clu.guardarCliente(cli);
        Menu men=new Menu();
       limpiar();
       men.setVisible(true);
      this.dispose();
       }
       
       
       }
       
       
       
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnick = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtapelido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcompania = new javax.swing.JTextField();
        txtlink = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        guargar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Foto = new javax.swing.JLabel();
        botoncliente = new javax.swing.JRadioButton();
        botonprovedor = new javax.swing.JRadioButton();
        txtmail = new javax.swing.JTextField();
        lblcompania = new javax.swing.JLabel();
        lbllink = new javax.swing.JLabel();
        nombrefoto = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Registrar Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nick");

        txtnick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnickFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Fecha nacimiento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Email");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        guargar.setText("Guardar");
        guargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guargarActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Foto.setText("Click");
        Foto.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));
        Foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FotoMouseClicked(evt);
            }
        });

        buttonGroup1.add(botoncliente);
        botoncliente.setText("Cliente");
        botoncliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonclienteActionPerformed(evt);
            }
        });

        buttonGroup1.add(botonprovedor);
        botonprovedor.setText("Proveedor");
        botonprovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonprovedorActionPerformed(evt);
            }
        });

        txtmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmailFocusLost(evt);
            }
        });

        lblcompania.setText("Nombre Compania :");

        lbllink.setText("Link");

        nombrefoto.setText("jLabel11");

        lblRuta.setText("jLabel11");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(nombrefoto)
                .addGap(40, 40, 40)
                .addComponent(lblRuta))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(98, 98, 98)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(98, 98, 98)
                .addComponent(txtapelido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(botoncliente)
                .addGap(21, 21, 21)
                .addComponent(botonprovedor))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblcompania, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtcompania, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbllink, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(txtlink, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jButton3)
                .addGap(5, 5, 5)
                .addComponent(guargar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombrefoto)
                            .addComponent(lblRuta))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(botoncliente)
                    .addComponent(botonprovedor))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcompania, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtcompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbllink, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(guargar)
                    .addComponent(jButton1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void guargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guargarActionPerformed
guardarPerfil();        // TODO add your handling code here:
        frmRegistrarUsuario ru = new frmRegistrarUsuario();
      
        
        
    }//GEN-LAST:event_guargarActionPerformed

    private void FotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FotoMouseClicked
     JFileChooser se = new JFileChooser("E:\\Ejercicios Java\\DirectMarket\\src\\imagenes");//donde quiero que abra
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);//que me muestre solo archivos
        int estado = se.showOpenDialog(null);//si esta abierta la ventana de seleccion
        if(estado == JFileChooser.APPROVE_OPTION)//si esta abierta
        {
           String ruta = se.getSelectedFile().getAbsolutePath();//me quedo con la ruta para despues copiar el archivo a otra carpeta
           String nombre = se.getSelectedFile().getName();//me quedo con el nombre
           String rutaNueva="E:\\Escritorio\\foto\\"+nombre;//donde voya a guardar
           lblRuta.setText(ruta);
           nombrefoto.setText(nombre);
           File entrada=new File(CorregirRuta(ruta));//creo el archivo y agrego barras a la direccion
           File salida=new File(rutaNueva);//creo el archivo en la carpeta de salida
            try {
                fis =  new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int)se.getSelectedFile().length();

                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(Foto.getWidth(), Foto.getHeight(), Image.SCALE_DEFAULT);
                Foto.setIcon(new ImageIcon(icono));
                Foto.updateUI();
                
            
                
                InputStream in = new FileInputStream(entrada);
                        OutputStream out = new FileOutputStream(salida);
                                
                        byte[] buf = new byte[1024];
                        int len;

                        while ((len = in.read(buf)) > 0) {
                                out.write(buf, 0, len);
                        }
                   
                        in.close();
                        out.close();
                

            } catch (FileNotFoundException ex) {
                Logger.getLogger(frmRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(frmRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
// TODO add your handling code here:
    
    }//GEN-LAST:event_FotoMouseClicked

    private void botonprovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonprovedorActionPerformed
   botoncliente.setVisible(false); //al precionar el radio provedor hago visible los campos que son del provedor
   lblcompania.setVisible(true);
lbllink.setVisible(true);
txtcompania.setVisible(true);
txtlink.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_botonprovedorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  System.exit(0);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Menu men=new Menu();//al precionar cancelar lo debuelvo al menu principal
men.setVisible(true);//hago visible el menu
this.dispose();//cierro esta ventana
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtnickFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnickFocusLost
existeNick();        // TODO add your handling code here:
    }//GEN-LAST:event_txtnickFocusLost

    private void txtmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmailFocusLost
existeEmail();        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailFocusLost

    private void botonclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonclienteActionPerformed
botonprovedor.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_botonclienteActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Foto;
    private javax.swing.JRadioButton botoncliente;
    private javax.swing.JRadioButton botonprovedor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton guargar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblcompania;
    private javax.swing.JLabel lbllink;
    private javax.swing.JLabel nombrefoto;
    private javax.swing.JTextField txtapelido;
    private javax.swing.JTextField txtcompania;
    private javax.swing.JTextField txtlink;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtnick;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

public String CorregirRuta(String ruta){
  String separador="\\", nuevoSeparador="\\\\"; 
         StringTokenizer tokens=new StringTokenizer(ruta, separador);
         //Para guardar la ruta corregida
         String rutaCorregida = new String();
         //Contar los tokens (en este caso las carpetas, contado tambien
         // el nombre del archivo seleccionado).
         int noTokens = tokens.countTokens();
         int i = 1;
         do
         {      //Agregar el nuevo separador
            rutaCorregida += tokens.nextToken()+nuevoSeparador;
            i++;
         }while(i<noTokens);
         //Agregar a la ruta corregida el ultimo token, (nombre del archivo)
         rutaCorregida += tokens.nextToken();      
         //Mostrar la ruta corregida en la consola
         System.out.println(rutaCorregida+"\n"+noTokens+ " tokens");
         return rutaCorregida;
    }

}
