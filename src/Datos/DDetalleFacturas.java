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
public class DDetalleFacturas {
    int IdDetalleFacturas;
    int FacturasId;
    String ProductosId;
    int Cantidad;
    double Total;

    public DDetalleFacturas() {
    }

    public DDetalleFacturas(int IdDetalleFacturas, int FacturasId, String ProductosId, int Cantidad, double Total) {
        this.IdDetalleFacturas = IdDetalleFacturas;
        this.FacturasId = FacturasId;
        this.ProductosId = ProductosId;
        this.Cantidad = Cantidad;
        this.Total = Total;
    }

    public int getIdDetalleFacturas() {
        return IdDetalleFacturas;
    }

    public void setIdDetalleFacturas(int IdDetalleFacturas) {
        this.IdDetalleFacturas = IdDetalleFacturas;
    }

    public int getFacturasId() {
        return FacturasId;
    }

    public void setFacturasId(int FacturasId) {
        this.FacturasId = FacturasId;
    }

    public String getProductosId() {
        return ProductosId;
    }

    public void setProductosId(String ProductosId) {
        this.ProductosId = ProductosId;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
}
