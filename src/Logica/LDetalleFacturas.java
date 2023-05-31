/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DDetalleFacturas;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.CallableStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kikin
 */
public class LDetalleFacturas {
    Connection cn = LConexion.getConnection();
    
    public String registrarDetalleFactura(DDetalleFacturas miDatalle) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_detallefacturas(?,?,?,?) }");
            cst.setInt(1, miDatalle.getFacturasId());
            cst.setString(2, miDatalle.getProductosId());
            cst.setInt(3, miDatalle.getCantidad());
            cst.setDouble(4, miDatalle.getTotal());
            cst.executeUpdate();
            msg = "si";
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }    

    public DefaultTableModel mostrarDetalleFacturas(DDetalleFacturas miDetalle) {
        DefaultTableModel miModelo = null;
        try{
            String titulos[] = {"CODIGO","DESCRIPCION","STOCK","UMEDIDA","PUNITARIO","TOTAL"};
            String dts [] = new String[6];
            miModelo = new DefaultTableModel(null,titulos);
            CallableStatement  cst = cn.prepareCall("{call sp_mostrardetalleFacturas(?)}");
            cst.setInt(1, miDetalle.getFacturasId());

            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("d.ProductosId");
                dts[1] = rs.getString("p.Descripcion");
                dts[2] = rs.getString("d.Cantidad");
                dts[3] = rs.getString("p.UMedida");
                dts[4] = rs.getString("p.PUnitario");
                dts[5] = rs.getString("d.Total");
                miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;      
    }
    
     
}
