
package vistas;

//@author Francis

import Logica.*;

import vistas.*;
import conexion.buscar;
import conexion.guardar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class GenerarOrdenCompra extends javax.swing.JFrame {
        CtrlUsuario crtlu = new CtrlUsuario();
        CtrlCompra ctrlcomp = new CtrlCompra();
        CtrlProductos ctrlp = new CtrlProductos();
        LinkedList<Object> Cliente= new LinkedList();
        LinkedList<OrdenDeCompra> ordenCompra= new LinkedList();
        LinkedList<Object> compras= new LinkedList();
        DefaultTableModel datos;
       
        String value;
        String value2;
        DefaultTableModel tabla;
        buscar bu = new buscar();
        guardar gu = new guardar();
        ResultSet rs;
        ArrayList Catprod = new ArrayList();
        DefaultListModel listaProd = new DefaultListModel();
        int refprod;
    
     
    
        
    public GenerarOrdenCompra() {
        initComponents();
        cargarcliente();
        mostrarCategoriasP();
        setLocationRelativeTo(null);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        //this.ProductosCategoria();
        this.Lista_productos.setModel(listaProd);
                
    }
    
    private void ProductosCategoria() {
       
       CtrlCategoria cc = CtrlCategoria.getInstance(); 
       String nombre = cc.getCategoria();
       ArrayList pro = new ArrayList();
       pro = ctrlp.verProductosPorCategoria(nombre);
       
       Iterator it = pro.iterator();
       
       while (it.hasNext()) {
           String producto = (String)it.next();
           listaProd.addElement(producto);
           
       }
       Lista_productos.setModel(listaProd);
 }
    
    
    void cargarcliente(){
    String[] titulos={"Nick","email"};
    String[] registros=new String[2];
    
    datos= new DefaultTableModel(null, titulos);
    
        
  
        for (int i=0;i<crtlu.listarUsuarios().size();i++) {
           
            registros[0]= crtlu.listarUsuarios().get(i).getNick();
            registros[1]= crtlu.listarUsuarios().get(i).getE_mail();
            datos.addRow(registros);
    }
        tablaCliente.setModel(datos);
    }

    public void mostrarCategoriasP(){
       
   String[] titulos={"Nombre"};
   String[] registro=new String[1];
   tabla=new DefaultTableModel(null, titulos);
    try {
          rs=bu.mostrarCategoriasP();
        while(rs.next()){
      String nombre=rs.getString("nombre");
      registro[0]=nombre;
    
      tabla.addRow(registro);   
        }
         mitabla.setModel(tabla);
    } catch (SQLException ex) {
        Logger.getLogger(VerCompra.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 }

    
 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        mitabla = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Lista_productos = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        cantprod = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Orden De Compra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccione Productos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seleccione Categoria");

        jButton1.setText("Cancelar");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        mitabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        mitabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mitablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mitabla);

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        Lista_productos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        Lista_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lista_productosMouseClicked(evt);
            }
        });
        Lista_productos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_productosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(Lista_productos);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Seleccione Cliente");

        jlabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jlabel7.setText("Cantidad");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cantprod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(agregar))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabel7)
                        .addComponent(cantprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(aceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        
        //llamar a al funcion mostrar 
        int j =tablaCliente.getSelectedRow(); 
        value=tablaCliente.getValueAt(j, 0).toString();
        jLabel4.setText(value);             

    }//GEN-LAST:event_tablaClienteMouseClicked

    private void mitablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mitablaMouseClicked
        
         ProductosCategoria();
         
         //llamar a al funcion mostrar Cli 
        int j =tablaCliente.getSelectedRow(); 
        value=tablaCliente.getValueAt(j, 0).toString();
               
        
        //llamar a al funcion mostrar cat
        int a =mitabla.getSelectedRow();
        value2=mitabla.getValueAt(a, 0).toString();
        
        CtrlCategoria cat=CtrlCategoria.getInstance();
        cat.setCategoria(value2);
       
             
      
    }//GEN-LAST:event_mitablaMouseClicked

    private void Lista_productosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_productosValueChanged
        if (!evt.getValueIsAdjusting()) {
            try {
                int pselec = this.Lista_productos.getSelectedIndex();
                refprod = (int) Catprod.get(pselec);
                //botones de opcion> ver informacion o modificar producto
                //.........
            }catch(Exception ex) {
                System.out.println("error cat"+ex.toString());
            }
        }
    }//GEN-LAST:event_Lista_productosValueChanged

    private void Lista_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lista_productosMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_Lista_productosMouseClicked

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // Agregar producto a la lista
        String selected = Lista_productos.getSelectedValue().toString();
        
        String refp = ctrlp.getrefprod(selected);
        int cant = Integer.getInteger(cantprod.getText());
       
        Compra nuevacompra = new Compra(cant, refp);
        compras.add(nuevacompra);
    
    }//GEN-LAST:event_agregarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        //LLama a la funcion del Copntrol
        ctrlcomp.guardarcompras(compras, value);
    }//GEN-LAST:event_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(GenerarOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarOrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarOrdenCompra().setVisible(true);
            }
        });
    }

   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Lista_productos;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton agregar;
    private javax.swing.JTextField cantprod;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JTable mitabla;
    private javax.swing.JTable tablaCliente;
    // End of variables declaration//GEN-END:variables
}

