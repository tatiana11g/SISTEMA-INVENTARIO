/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.DProveedores;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
/**
 *
 * @author kikin
 */
public class LProveedores {
    
    Connection cn = LConexion.getConnection();
    
    public DefaultTableModel mostrarProveedores(DProveedores miProveedor){
        DefaultTableModel miModelo = null;
        try{
            String titulos[] = {"ID","NOMBRE/RS","DOMICILIO","TELEFONO"};
            String dts [] = new String[4];
            miModelo = new DefaultTableModel(null,titulos);
            CallableStatement  cst = cn.prepareCall("{call sp_mostrarbuscar_proveedores(?)}");
            cst.setString(1,miProveedor.getNombre());
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("IdProveedores");
                dts[1] = rs.getString("NombreRS");
                dts[2] = rs.getString("Domicilio");
                dts[3] = rs.getString("Telefono");
                miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;        
    }
    
    public String insertarProveedores(DProveedores miProveedor){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{Call sp_insertar_proveedores(?,?,?)}");
            cst.setString(1,miProveedor.getNombre());
            cst.setString(2,miProveedor.getDomicilio());
            cst.setString(3,miProveedor.getTelefono());
            cst.executeUpdate();
            msg = "Se registro de forma correcta";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }
    public String editarProveedores(DProveedores miProveedor){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{Call sp_editar_proveedores(?,?,?,?)}");
            cst.setInt(1,miProveedor.getIdProveedores());
            cst.setString(2,miProveedor.getNombre());
            cst.setString(3,miProveedor.getDomicilio());
            cst.setString(4,miProveedor.getTelefono());
            cst.executeUpdate();
            msg = "Se actualizo de forma correcta";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }  
    public String eliminarProveedores(DProveedores miProveedor){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{Call sp_eliminar_proveedores(?)}");
            cst.setInt(1,miProveedor.getIdProveedores());
            cst.executeUpdate();
            msg = "Se elimino de forma correcta";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }     
}
