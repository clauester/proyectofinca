/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel Davila
 */
public class Usuario {
    String id_usuario;
    String tipo;
    String clave;
    int id_persona;

    public Usuario(String id_usuario, String tipo, String clave, int id_persona) {
        this.id_usuario = id_usuario;
        this.tipo = tipo;
        this.clave = clave;
        this.id_persona = id_persona;
    }

    public Usuario(String id_usuario, String tipo, String clave) {
        this.id_usuario = id_usuario;
        this.tipo = tipo;
        this.clave = clave;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    
    
    
}
