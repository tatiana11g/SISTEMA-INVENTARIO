/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.DLineas;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
/**
 *
 * @author kikin
 */
public class LLineas {
    Connection cn = LConexion.getConnection();
    
    public DefaultTableModel mostrarLineas(DLineas misLineas){
        DefaultTableModel miModelo = null;
        try{
            String titulos[] = {"ID","LINEA"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null,titulos);
            CallableStatement  cst = cn.prepareCall("{call sp_mostrarbuscar_lineas(?)}");
            cst.setString(1,misLineas.getLineas());
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("IdLineas");
                dts[1] = rs.getString("Nombre");
                miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;        
    }  
    public String insertarLineas(DLineas misLineas){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{Call sp_insertar_lineas(?)}");
            cst.setString(1,misLineas.getLineas());
            cst.executeUpdate();
            msg = "Se registro de forma correcta";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }  
    public String editarLineas(DLineas misLineas){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{Call sp_editar_lineas(?,?)}");
            cst.setInt(1,misLineas.getIdLineas());
            cst.setString(2,misLineas.getLineas());
            cst.executeUpdate();
            msg = "Se actualizo de forma correcta";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }    
    public String eliminarLineas(DLineas misLineas){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{Call sp_eliminar_lineas(?)}");
            cst.setInt(1,misLineas.getIdLineas());
            cst.executeUpdate();
            msg = "Se elimino de forma correcta";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }    
}
