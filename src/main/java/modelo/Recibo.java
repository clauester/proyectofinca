/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;



/**
 *
 * @author Miguel Davila
 */
public class Recibo {
    int id_persona;
    int id_finca;
    Date fecha;
    String codigo_recibo;
    String nombre_empresa;
    int precio;

    public Recibo(int id_persona, int id_finca, Date fecha, String codigo_recibo, String nombre_empresa, int precio) {
        this.id_persona = id_persona;
        this.id_finca = id_finca;
        this.fecha = fecha;
        this.codigo_recibo = codigo_recibo;
        this.nombre_empresa = nombre_empresa;
        this.precio = precio;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_finca() {
        return id_finca;
    }

    public void setId_finca(int id_finca) {
        this.id_finca = id_finca;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigo_recibo() {
        return codigo_recibo;
    }

    public void setCodigo_recibo(String codigo_recibo) {
        this.codigo_recibo = codigo_recibo;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    
}
