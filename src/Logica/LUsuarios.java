/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DUsuarios;
import Formularios.FrmLogin;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author kikin
 */
public class LUsuarios {

    Connection cn = LConexion.getConnection();

    public DefaultTableModel mostrarUsuarios(DUsuarios misUsuarios) {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"ID", "NOMBRE", "USUARIO", "CLAVE", "PERFIL"};
            String dts[] = new String[5];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = cn.prepareCall("{call sp_mostrarbuscar_usuarios(?)}");
            cst.setString(1, misUsuarios.getUsuario());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("IdUsuarios");
                dts[1] = rs.getString("Nombre");
                dts[2] = rs.getString("Usuario");
                dts[3] = "*****";
                dts[4] = rs.getString("Perfil");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    public String insertarUsuarios(DUsuarios misUsuarios) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{Call sp_insertar_usuarios(?,?,?,?)}");
            cst.setString(1, misUsuarios.getNombre());
            cst.setString(2, misUsuarios.getUsuario());
            cst.setString(3, misUsuarios.getClave());
            cst.setString(4, misUsuarios.getPerfil());
            cst.executeUpdate();
            msg = "Se registro de forma correcta";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return msg;
    }

    public String editarUsuarios(DUsuarios misUsuarios) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{Call sp_editar_usuarios(?,?,?,?,?)}");
            cst.setInt(1, misUsuarios.getIdUsuarios());
            cst.setString(2, misUsuarios.getNombre());
            cst.setString(3, misUsuarios.getUsuario());
            cst.setString(4, misUsuarios.getClave());
            cst.setString(5, misUsuarios.getPerfil());
            cst.executeUpdate();
            msg = "Se actualizo de forma correcta";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return msg;
    }

    public String eliminarUsuarios(DUsuarios misUsuarios) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{Call sp_eliminar_usuarios(?)}");
            cst.setInt(1, misUsuarios.getIdUsuarios());
            cst.executeUpdate();
            msg = "Se elimino de forma correcta";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return msg;
    }

    public String ValidarLogin(DUsuarios misUsuarios) {
        String perfil = "";
        try {

            CallableStatement cst = cn.prepareCall("{call sp_validarusuario(?,?)}");
            cst.setString(1, misUsuarios.getUsuario());
            cst.setString(2, misUsuarios.getClave());
            ResultSet rs = cst.executeQuery();
            if (rs.first()) {
                perfil = rs.getString("Perfil");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return perfil;
    }

}
