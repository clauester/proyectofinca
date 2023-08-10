/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel Davila
 */

// Esta clase representa una entidad 'Finca', que tiene atributos como id, nombre, tamaño, código y dirección.
public class Finca {
   // Atributos de la finca
    int id;
    String nombre;
    int tamanio;
    String codigo;
    String direccion;
    
// Constructor por defecto, necesario para instanciar la clase sin parámetros
    public Finca() {
    }
    
// Constructor con parámetros para inicializar todos los atributos de la finca
    public Finca(int id, String nombre, int tamanio, String codigo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.codigo = codigo;
        this.direccion = direccion;
    }
  // Métodos para acceder y modificar los atributos de la finca

    // Métodos 'getter' para obtener el valor de 'id', 'nombre', 'tamanio', 'codigo' y 'direccion'
    // respectivamente
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    // Métodos 'setter' para asignar valores a 'id', 'nombre', 'tamanio', 'codigo' y 'direccion'
    // respectivamente
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Representación en forma de cadena de la finca, que se utilizará para imprimir
    // información sobre la finca en un formato legible
    @Override
    public String toString() {
        return "nombre Finca: " + nombre + ", codigo: " + codigo + '}';
    }

}
