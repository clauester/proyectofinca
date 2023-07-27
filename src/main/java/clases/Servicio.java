/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Miguel Davila
 */
public class Servicio {
    String tipos_servicio;
    String descripcion;
    int costo;

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
    
            
            

    
}
