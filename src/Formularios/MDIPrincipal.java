/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Logica.LImportarExportarDB;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author kikin
 */
public class MDIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MDIPrincipal
     */
    String hora = "";

    public MDIPrincipal() {
        initComponents();

        TimerTask tiempotarea = new TimerTask() {
            public void run() {
                Date fecha = new Date();
                DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
                lblfecha.setText(formatofecha.format(fecha));

                DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                lblhora.setText(formatoHora.format(fecha));

                Calendar dt = Calendar.getInstance();
                int hh = dt.get(Calendar.HOUR_OF_DAY);
                int mm = dt.get(Calendar.MINUTE);
                int ss = dt.get(Calendar.SECOND);
                hora = String.valueOf(""+hh+""+mm+""+ss);
            }
        };

        Timer tiempo = new Timer();
        tiempo.scheduleAtFixedRate(tiempotarea, 0, 1000);

        //  opciones rapidas
        ImageIcon imFacturas = new ImageIcon(getClass().getResource("/Imagenes/Facturas.png"));
        Icon iconoFacturas = new ImageIcon(imFacturas.getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT));
        btnFacturas.setIcon(iconoFacturas);

        ImageIcon imRecibos = new ImageIcon(getClass().getResource("/Imagenes/Recibos.png"));
        Icon iconoRecibos = new ImageIcon(imRecibos.getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT));
        btnRecibos.setIcon(iconoRecibos);

        ImageIcon imAlmacen = new ImageIcon(getClass().getResource("/Imagenes/Almacen.png"));
        Icon iconoAlmacen = new ImageIcon(imAlmacen.getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT));
        btnAlmacen.setIcon(iconoAlmacen);

        //menu consultas
        ImageIcon imMConsultas = new ImageIcon(getClass().getResource("/Imagenes/Consultas.png"));
        Icon iconoMConsultas = new ImageIcon(imMConsultas.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        menuConsultas.setIcon(iconoMConsultas);

        ImageIcon imDetalleFacturas = new ImageIcon(getClass().getResource("/Imagenes/Facturas.png"));
        Icon iconDetFact = new ImageIcon(imDetalleFacturas.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        itemReportes.setIcon(iconDetFact);

        ImageIcon imDetalleRecibos = new ImageIcon(getClass().getResource("/Imagenes/Recibos.png"));
        Icon iconDetRec = new ImageIcon(imDetalleRecibos.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        itemDetFact.setIcon(iconDetRec);

        ImageIcon imReportes = new ImageIcon(getClass().getResource("/Imagenes/Almacen.png"));
        Icon iconReportes = new ImageIcon(imReportes.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        itemDetRec.setIcon(iconReportes);

        //menu base de datos
        ImageIcon imMBD = new ImageIcon(getClass().getResource("/Imagenes/Base de datos.png"));
        Icon iconoMDB = new ImageIcon(imMBD.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        menuDB.setIcon(iconoMDB);

        ImageIcon imMResDB = new ImageIcon(getClass().getResource("/Imagenes/DB.png"));
        Icon iconResDB = new ImageIcon(imMResDB.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        ItemDB.setIcon(iconResDB);

        //  menu herramientas
        ImageIcon imMHerramientas = new ImageIcon(getClass().getResource("/Imagenes/Herramientas.png"));
        Icon iconoHerramientas = new ImageIcon(imMHerramientas.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        menuHerramientas.setIcon(iconoHerramientas);

        ImageIcon imMUsuarios = new ImageIcon(getClass().getResource("/Imagenes/Usuarios.png"));
        Icon iconItemUs = new ImageIcon(imMUsuarios.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        ItemUsuarios.setIcon(iconItemUs);

        ImageIcon imMLinea = new ImageIcon(getClass().getResource("/Imagenes/Lineas.png"));
        Icon IconoLinea = new ImageIcon(imMLinea.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        ItemLinea.setIcon(IconoLinea);

        ImageIcon imMProveedores = new ImageIcon(getClass().getResource("/Imagenes/Porveedores.png"));
        Icon iconoProveedor = new ImageIcon(imMProveedores.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        ItemProveedores.setIcon(iconoProveedor);

        ImageIcon imMInfo = new ImageIcon(getClass().getResource("/Imagenes/Informacion.png"));
        Icon iconoInfo = new ImageIcon(imMInfo.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        ItemInfo.setIcon(iconoInfo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnPrincipal = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        btnFacturas = new javax.swing.JButton();
        btnRecibos = new javax.swing.JButton();
        btnAlmacen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuConsultas = new javax.swing.JMenu();
        itemReportes = new javax.swing.JMenuItem();
        itemDetFact = new javax.swing.JMenuItem();
        itemDetRec = new javax.swing.JMenuItem();
        menuDB = new javax.swing.JMenu();
        ItemDB = new javax.swing.JMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        ItemUsuarios = new javax.swing.JMenuItem();
        ItemLinea = new javax.swing.JMenuItem();
        ItemProveedores = new javax.swing.JMenuItem();
        ItemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones rapidas"));

        btnFacturas.setText("Facturas");
        btnFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturasActionPerformed(evt);
            }
        });

        btnRecibos.setText("Recibos");
        btnRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibosActionPerformed(evt);
            }
        });

        btnAlmacen.setText("Almacen");
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecibos, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(btnFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Usuario:");

        jLabel2.setText("Hora:");

        jLabel3.setText("Fecha:");

        menuConsultas.setText("Consultas");

        itemReportes.setText("Reportes");
        menuConsultas.add(itemReportes);

        itemDetFact.setText("Detalle de facturas");
        itemDetFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDetFactActionPerformed(evt);
            }
        });
        menuConsultas.add(itemDetFact);

        itemDetRec.setText("Detalle de recibos");
        itemDetRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDetRecActionPerformed(evt);
            }
        });
        menuConsultas.add(itemDetRec);

        menuBar.add(menuConsultas);

        menuDB.setMnemonic('h');
        menuDB.setText("Base de datos");

        ItemDB.setMnemonic('c');
        ItemDB.setText("Respaldar / Restaurar");
        ItemDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemDBActionPerformed(evt);
            }
        });
        menuDB.add(ItemDB);

        menuBar.add(menuDB);

        menuHerramientas.setMnemonic('e');
        menuHerramientas.setText("Herramientas");

        ItemUsuarios.setMnemonic('t');
        ItemUsuarios.setText("Usuario");
        ItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemUsuariosActionPerformed(evt);
            }
        });
        menuHerramientas.add(ItemUsuarios);

        ItemLinea.setText("Lineas");
        ItemLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemLineaActionPerformed(evt);
            }
        });
        menuHerramientas.add(ItemLinea);

        ItemProveedores.setText("Proveedores");
        ItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemProveedoresActionPerformed(evt);
            }
        });
        menuHerramientas.add(ItemProveedores);

        ItemInfo.setMnemonic('y');
        ItemInfo.setText("Información");
        menuHerramientas.add(ItemInfo);

        menuBar.add(menuHerramientas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblusuario)
                            .addComponent(lblhora)
                            .addComponent(lblfecha))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(dpnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblusuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblhora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblfecha)))
                .addGap(17, 17, 17))
            .addComponent(dpnPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemUsuariosActionPerformed
        // TODO add your handling code here:
        FrmUsuarios miUs = new FrmUsuarios();
        dpnPrincipal.add(miUs);
        miUs.show();
    }//GEN-LAST:event_ItemUsuariosActionPerformed

    private void ItemLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemLineaActionPerformed
        // TODO add your handling code here:
        FrmLineas miLin = new FrmLineas();
        dpnPrincipal.add(miLin);
        miLin.show();
    }//GEN-LAST:event_ItemLineaActionPerformed

    private void ItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemProveedoresActionPerformed
        // TODO add your handling code here:
        FrmProveedores miProveedor = new FrmProveedores();
        dpnPrincipal.add(miProveedor);
        miProveedor.show();
    }//GEN-LAST:event_ItemProveedoresActionPerformed

    private void btnFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturasActionPerformed
        // TODO add your handling code here:
        FrmFacturas miFactura = new FrmFacturas();
        dpnPrincipal.add(miFactura);
        miFactura.show();
    }//GEN-LAST:event_btnFacturasActionPerformed

    private void itemDetFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDetFactActionPerformed
        // TODO add your handling code here:
        FrmDetFacturas miFactura = new FrmDetFacturas();
        dpnPrincipal.add(miFactura);
        miFactura.show();
    }//GEN-LAST:event_itemDetFactActionPerformed

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        // TODO add your handling code here:
        FrmInventario miProducto = new FrmInventario();
        dpnPrincipal.add(miProducto);
        miProducto.show();
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibosActionPerformed
        // TODO add your handling code here:
        FrmRecibos miRecib = new FrmRecibos();
        dpnPrincipal.add(miRecib);
        miRecib.setUsuario(lblusuario.getText());
        miRecib.show();
    }//GEN-LAST:event_btnRecibosActionPerformed

    private void itemDetRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDetRecActionPerformed
        // TODO add your handling code here:
        FrmDetRecibos miFactura = new FrmDetRecibos();
        dpnPrincipal.add(miFactura);
        miFactura.show();
    }//GEN-LAST:event_itemDetRecActionPerformed

    private void ItemDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDBActionPerformed
        // TODO add your handling code here:
        FrmExportarImportarDB miDB = new FrmExportarImportarDB();
        dpnPrincipal.add(miDB);
        miDB.show();
    }//GEN-LAST:event_ItemDBActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        LImportarExportarDB db = new LImportarExportarDB();
        db.exportarDB(hora);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemDB;
    private javax.swing.JMenuItem ItemInfo;
    private javax.swing.JMenuItem ItemLinea;
    private javax.swing.JMenuItem ItemProveedores;
    private javax.swing.JMenuItem ItemUsuarios;
    private javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnFacturas;
    private javax.swing.JButton btnRecibos;
    private javax.swing.JDesktopPane dpnPrincipal;
    private javax.swing.JMenuItem itemDetFact;
    private javax.swing.JMenuItem itemDetRec;
    private javax.swing.JMenuItem itemReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuDB;
    private javax.swing.JMenu menuHerramientas;
    // End of variables declaration//GEN-END:variables

    public void setDatos(String usuario, String perfil) {
        lblusuario.setText(usuario);
        if (perfil.equals("Personal")) {
            menuDB.setVisible(false);
            ItemUsuarios.setVisible(false);
        } else {

            menuDB.setVisible(true);
            ItemUsuarios.setVisible(true);
        }
    }

}
