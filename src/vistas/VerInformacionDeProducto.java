
package Vistas;

import Logica.*;
import conexion.buscar;
import conexion.listar;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class VerInformacionDeProducto extends javax.swing.JFrame {
    
    buscar bu = new buscar();    
    listar lis = new listar();
    DefaultTreeModel arbol_categorias;
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorias");
    
    public VerInformacionDeProducto() {
        initComponents();
        this.cargarCategorias();
       
        this.setLocationRelativeTo(null);
    }
    
    private void cargarCategorias() {
        ArrayList<CatPadre> cate = bu.categoriaPadre();
        for (CatPadre Categ:cate) {
            DefaultMutableTreeNode cat = new DefaultMutableTreeNode();
            String nom = Categ.getNombre();
            cat.setUserObject(Categ);
            root.add(cat);
            this.traerCategoriasHijas(cat, nom);
            }
        arbol_categorias = new DefaultTreeModel(root);
        catArbol.setModel(arbol_categorias);
        catArbol.setVisible(true);
    }
    
    private void traerCategoriasHijas(DefaultMutableTreeNode nodo, String pad){
        ArrayList<CatHija> catego = bu.categoriasHijas(pad); 
        if(catego.size()>0){
            for(CatHija Ca: catego){
            String padr = Ca.getNombre();
            DefaultMutableTreeNode com = new DefaultMutableTreeNode();
            com.setUserObject(Ca);
            nodo.add(com);
            traerCategoriasHijas(com, padr);
            }
        }
    }                                                                       
   
    
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catArbol = new javax.swing.JTree();
        Cancelar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar categorías");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        catArbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catArbolMouseClicked(evt);
            }
        });
        catArbol.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                catArbolValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(catArbol);

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cancelar)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void catArbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catArbolMouseClicked
       
    }//GEN-LAST:event_catArbolMouseClicked

    private void catArbolValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_catArbolValueChanged
         DefaultMutableTreeNode def=(DefaultMutableTreeNode)catArbol.getLastSelectedPathComponent();
        if(def==null){
            return; }
        if(def.getLevel()==0){
            return; }
        else{
            try{
                CatHija prod=(CatHija)def.getUserObject();
                if (lis.getListaProductosCat(prod.getNombre()).size()>0){
                    CtrlCategoria cc = CtrlCategoria.getInstance();
                    cc.setCategoria(prod.getNombre());
                    this.dispose();
                    ListarProductos view;
                    view = new ListarProductos();
                    view.setVisible(true); }
                else { 
                    JOptionPane.showMessageDialog(null, "La categoria no contiene productos"); 
                    }
                }catch(Exception ex) { 
                CatPadre prod=(CatPadre)def.getUserObject();
                if (lis.getListaProductosCat(prod.getNombre()).size()>0) {
                    CtrlCategoria cc = CtrlCategoria.getInstance();
                    cc.setCategoria(prod.getNombre());
                    this.dispose();
                    ListarProductos view;
                    view = new ListarProductos();
                    view.setVisible(true); }
                else {
                    JOptionPane.showMessageDialog(null, "La categoria no contiene productos");
                }
          }
        }
    }//GEN-LAST:event_catArbolValueChanged

    
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
            java.util.logging.Logger.getLogger(VerInformacionDeProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerInformacionDeProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerInformacionDeProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerInformacionDeProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerInformacionDeProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JTree catArbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
