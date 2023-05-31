/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.Date;
/**
 *
 * @author kikin
 */
public class DRecibos {
    
    int IdRecibos;


    Date FechaRecibo;
    String PersonaEntrega;
    String PersonaRecibe;

    public DRecibos() {
    }

    public DRecibos(int IdRecibos, Date FechaRecibo, String PersonaEntrega, String PersonaRecibe) {
        this.IdRecibos = IdRecibos;
        this.FechaRecibo = FechaRecibo;
        this.PersonaEntrega = PersonaEntrega;
        this.PersonaRecibe = PersonaRecibe;
    }
    public int getIdRecibos() {
        return IdRecibos;
    }

    public void setIdRecibos(int IdRecibos) {
        this.IdRecibos = IdRecibos;
    }
    public Date getFechaRecibo() {
        return FechaRecibo;
    }

    public void setFechaRecibo(Date FechaRecibo) {
        this.FechaRecibo = FechaRecibo;
    }

    public String getPersonaEntrega() {
        return PersonaEntrega;
    }

    public void setPersonaEntrega(String PersonaEntrega) {
        this.PersonaEntrega = PersonaEntrega;
    }

    public String getPersonaRecibe() {
        return PersonaRecibe;
    }

    public void setPersonaRecibe(String PersonaRecibe) {
        this.PersonaRecibe = PersonaRecibe;
    }
    
}
