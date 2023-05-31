/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DDetalleFacturas;
import Datos.DDetalleRecibos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kikin
 */
public class LDetalleRecibos {
    Connection cn = LConexion.getConnection();
    
    public String registrarDetalleRecibos(DDetalleRecibos miDatalle) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_datellerecib(?,?,?,?,?) }");
            //(in recibid int, in prodid varchar(45), in idlin int, in cant int, in tot decimal(18,2))
            cst.setInt(1, miDatalle.getRecibosId());
            cst.setString(2, miDatalle.getProductosId());
            cst.setInt(3, miDatalle.getLineasId());
            cst.setInt(4, miDatalle.getCantidad());
            cst.setDouble(5, miDatalle.getTotal());
            cst.executeUpdate();
            msg = "si";
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }    
    public DefaultTableModel mostrarDetalleRecibos(DDetalleRecibos miDetalle) {
        DefaultTableModel miModelo = null;
        try{
            String titulos[] = {"CODIGO","DESCRIPCION","CANTIDAD","UMEDIDA","PUNITARIO","LINEA","TOTAL"};
            String dts [] = new String[7];
            miModelo = new DefaultTableModel(null,titulos);
            CallableStatement  cst = cn.prepareCall("{call sp_mostrardetallerecibos(?)}");
            cst.setInt(1, miDetalle.getRecibosId());

            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("d.ProductosId");
                dts[1] = rs.getString("p.Descripcion");
                dts[2] = rs.getString("d.Cantidad");
                dts[3] = rs.getString("p.UMedida");
                dts[4] = rs.getString("p.PUnitario");
                dts[5] = rs.getString("l.Nombre");
                dts[6] = rs.getString("d.Total");
                miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;      
    }    
}
