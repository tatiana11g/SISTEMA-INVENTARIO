/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.DAlmacen;
import Datos.DFactura;
import Formularios.FrmFacturas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class LFactura {
    Connection cn = LConexion.getConnection();

    public DefaultTableModel mostrarFacturas(){
        DefaultTableModel miModelo = null;
        try{
            String titulos[] = {"CODIGO","PROVEEDOR","LINEA","FECHA DE REGISTRO"};
            String dts [] = new String[4];
            miModelo = new DefaultTableModel(null,titulos);
            CallableStatement  cst = cn.prepareCall("{call sp_mostrar_facturas()}");
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("f.IdFacturas");
                dts[1] = rs.getString("p.NombreRS");
                dts[2] = rs.getString("l.Nombre");
                dts[3] = rs.getString("f.FechaEntrada");

                miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;        
    }     
    
    public int insertarFacturas(DFactura misFacturas){
        int idres = 0;
        FrmFacturas miFrmFactura = new FrmFacturas();
        try{                                          
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_facturas(?,?,?,?) }");
            cst.setInt(1, misFacturas.getLineasId());
            cst.setInt(2, misFacturas.getProveedoresId());
            cst.setDate(3, misFacturas.getFechaEntrada());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);
        }catch(Exception ex){
            ex.printStackTrace();
            idres = 0;
        }
        return idres;        
    }    
    
}
