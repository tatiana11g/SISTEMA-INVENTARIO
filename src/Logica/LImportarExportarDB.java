/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author kikin
 */
public class LImportarExportarDB {
    
    public void exportarDB(String hora){
        System.out.println(hora);
        String usuario = "Quike";
        String pass = "123";
        String db = "dbalmacen";
        try {
            Process p = Runtime.getRuntime().exec("C://xampp//mysql//bin//mysqldump -u " + usuario + " -p" + pass + " --routines -B " + db);
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\kikin\\Documents\\Reportes\\dbalmacen"+hora+".sql");
            // FileOutputStream fos = new FileOutputStream(nombredb);
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            fos.close();

            JOptionPane.showMessageDialog(null, "Se respaldo de forma correcta");

        } catch (IOException ex) {
            ex.printStackTrace();
        }        
    }
    public void importarDB(){
        String usuario = "Quike";
        String pass = "123";
        String db = "dbalmacen";

        try {
            Process p = Runtime.getRuntime().exec("C://xampp//mysql//bin//mysql -u " + usuario + " -p" + pass + " " + db);
            OutputStream is = p.getOutputStream();
            FileInputStream fos = new FileInputStream("C:\\Users\\kikin\\Documents\\Reportes\\dbalmacen.sql");

            byte[] buffer = new byte[1000];
            int leido = fos.read(buffer);
            while (leido > 0) {
                is.write(buffer, 0, leido);
                leido = fos.read(buffer);
            }
            is.flush();
            is.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Se restauro de forma correcta");
        } catch (IOException ex) {
             ex.printStackTrace();
        }        
        
    }
    
}
