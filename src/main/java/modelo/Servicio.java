/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel Davila
 */
public class Servicio {
    int id_servicio;
    String tipos_servicio;
    String descripcion;
    int costo;

    public Servicio() {
    }

    public Servicio(int id_servicio, String tipos_servicio, String descripcion, int costo) {
        this.id_servicio = id_servicio;
        this.tipos_servicio = tipos_servicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Servicio(String tipos_servicio, String descripcion, int costo) {
        this.tipos_servicio = tipos_servicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getTipos_servicio() {
        return tipos_servicio;
    }

    public void setTipos_servicio(String tipos_servicio) {
        this.tipos_servicio = tipos_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    @Override
    public String toString() {
        return "tipo: " + tipos_servicio + " - costo: $" + costo ;
    }
    
            
            

    
}
