/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author kikin
 */
public class DProveedores {
    int IdProveedores;
    String Nombre;
    String Domicilio;
    String Telefono;
    
    public DProveedores(){
        
    }    

    public DProveedores(int IdProveedores, String Nombre, String Domicilio, String Telefono) {
        this.IdProveedores = IdProveedores;
        this.Nombre = Nombre;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
    }

    public int getIdProveedores() {
        return IdProveedores;
    }

    public void setIdProveedores(int IdProveedores) {
        this.IdProveedores = IdProveedores;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
}
