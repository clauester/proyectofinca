/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import modelo.Finca;
import modelo.Persona;
import modelo.Recibo;
import modelo.Servicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JTable;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Davila
 */
//clase con funciones para llamar a los procedimientos almacenados 
public class CN_GetData {

    private final CN_Connection db_connection = new CN_Connection();
    public static ResultSet consulta;
    
   //metodo para obtener la tabla de todos los propietarios, devuelve un result Set
    public ResultSet GetPropietarios() {

        try {
            //se abre la conexion con la base de datos 
            Connection conexion = db_connection.OpenConnection();
            //se llama al stored procedure
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call mostrar_persona}");
            consulta = ProcedimientoAlmacenado.executeQuery();

            return consulta;

            // se agarra el error y se lo presenta por pantalla
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
    }
    
 //metodo para obtener la tabla segun el nombre del propietario, devuelve un result Set
    public ResultSet SearchPropietario(String apellido) {
        try {
            Connection conexion = db_connection.OpenConnection();
                //se llama al stored procedure
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call buscar_persona(?)}");
            ProcedimientoAlmacenado.setString(1, apellido);
            consulta = ProcedimientoAlmacenado.executeQuery();
            return consulta;
            
            // se agarra el error y se lo presenta por pantalla
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
    }
    
    
//metodo que añade elementos a la tabla propietarios
    public void AddPropietario(Persona personaData) {
        try {
            Connection conexion = db_connection.OpenConnection();
                //se llama al stored procedure y se ingresan todos los valores necesarios para el SP
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call agregar_propietario(?,?,?,?,?,?,?)}");
            ProcedimientoAlmacenado.setString(1, personaData.getCedula());
            ProcedimientoAlmacenado.setString(2, personaData.getNombre());
            ProcedimientoAlmacenado.setString(3, personaData.getApellido());
            ProcedimientoAlmacenado.setString(4, personaData.getDireccion());
            ProcedimientoAlmacenado.setString(5, personaData.getTelefono());
            ProcedimientoAlmacenado.setString(6, personaData.getSexo());
            ProcedimientoAlmacenado.setString(7, personaData.getCorreo());

            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Propietario añadido");
            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
// metodo void que actualiza a un propietario existente
    public void UpdatePropietario(Persona personaData, int id) {
        try {
            //se abre la conexion a la base de datos
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call actualizar_persona(?,?,?,?,?,?,?,?)}");

            ProcedimientoAlmacenado.setInt(1, id);
            ProcedimientoAlmacenado.setString(2, personaData.getCedula());
            ProcedimientoAlmacenado.setString(3, personaData.getNombre());
            ProcedimientoAlmacenado.setString(4, personaData.getApellido());
            ProcedimientoAlmacenado.setString(5, personaData.getDireccion());
            ProcedimientoAlmacenado.setString(6, personaData.getTelefono());
            ProcedimientoAlmacenado.setString(7, personaData.getSexo());
            ProcedimientoAlmacenado.setString(8, personaData.getCorreo());
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Propietario Actualizado");
            db_connection.CloseConnection();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //metodo que elimina a un propietario por su ide de propietario
    public void DeletePropietario(int id) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call eliminar_persona(?)}");

            ProcedimientoAlmacenado.setInt(1, id);
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Propietario Eliminado");
//            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //metodo que devuelve todos los elementos de la tabla fincas y devuelve un resultSet
    public ResultSet GetFincas() {

        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call mostrar_finca}");
            consulta = ProcedimientoAlmacenado.executeQuery();
//             db_connection.CloseConnection(conexion);
            return consulta;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
        
    }
    
    // Metodo que devuelve todas las fincas de un usuario mediante su id 
    public ResultSet GetFincasByPropietario(int id) {

        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call buscar_finca_id_persona(?)}");
            ProcedimientoAlmacenado.setInt(1, id);
            consulta = ProcedimientoAlmacenado.executeQuery();
//             db_connection.CloseConnection(conexion);
            return consulta;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
        
    }
    
    
     public ResultSet SearchFinca(String nombre) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call buscar_finca(?)}");
            ProcedimientoAlmacenado.setString(1, nombre);
            consulta = ProcedimientoAlmacenado.executeQuery();
            return consulta;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
    }
      public ResultSet IniciarSesion(String cedula, String contrasenia){
        try{
             Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call iniciar_sesion(?,?)}");
            ProcedimientoAlmacenado.setString(1, cedula);
            ProcedimientoAlmacenado.setString(2, contrasenia);
              consulta = ProcedimientoAlmacenado.executeQuery();

           
//             db_connection.CloseConnection(conexion);
            return consulta;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return consulta;
    }



    public void AddFinca(Finca fincaData) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call agregar_finca(?,?,?,?,?)}");
            ProcedimientoAlmacenado.setInt(1, fincaData.getId());
            ProcedimientoAlmacenado.setString(2, fincaData.getNombre());
            ProcedimientoAlmacenado.setInt(3, fincaData.getTamanio());
            ProcedimientoAlmacenado.setString(4, fincaData.getCodigo());
            ProcedimientoAlmacenado.setString(5, fincaData.getDireccion());

            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Finca añadida");
            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void DeleteFinca(int id) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call eliminar_finca(?)}");

            ProcedimientoAlmacenado.setInt(1, id);
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Finca Eliminada");
//            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void UpdateFinca(Finca fincaData, int id) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call actualizar_finca(?,?,?,?)}");

            ProcedimientoAlmacenado.setString(1, fincaData.getNombre());
            ProcedimientoAlmacenado.setInt(2, fincaData.getTamanio());
            ProcedimientoAlmacenado.setString(3, fincaData.getCodigo());
            ProcedimientoAlmacenado.setString(4, fincaData.getDireccion());
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Finca Actualizado");
            db_connection.CloseConnection();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void AddServicio(Servicio servicioData) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call agregar_servicio(?,?,?)}");
            ProcedimientoAlmacenado.setString(1, servicioData.getTipos_servicio());
            ProcedimientoAlmacenado.setString(2, servicioData.getDescripcion());
            ProcedimientoAlmacenado.setInt(3, servicioData.getCosto());
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Servicio añadido");
            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ResultSet GetServicios() {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call mostrar_servicio}");
            consulta = ProcedimientoAlmacenado.executeQuery();
//             db_connection.CloseConnection(conexion);
            return consulta;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;

    }

    public void UpdateServicio(Servicio servicioData, int id) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call actualizar_servicio(?,?,?,?)}");

            ProcedimientoAlmacenado.setInt(1, id);
            ProcedimientoAlmacenado.setString(2, servicioData.getTipos_servicio());
            ProcedimientoAlmacenado.setString(3, servicioData.getDescripcion());
            ProcedimientoAlmacenado.setInt(4, servicioData.getCosto());

            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Servicio Actualizado");
            db_connection.CloseConnection();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void DeleteServicio (int id) {
            try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call eliminar_servicio(?)}");

            ProcedimientoAlmacenado.setInt(1, id);
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Servicio Eliminado");
//            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public void AddRecibo(Recibo reciboData) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call agregar_recibo(?,?,?,?,?,?)}");
            ProcedimientoAlmacenado.setInt(1, reciboData.getId_persona());
            ProcedimientoAlmacenado.setInt(2, reciboData.getId_finca());    
            ProcedimientoAlmacenado.setDate(3, reciboData.getFecha());
            ProcedimientoAlmacenado.setString(4, reciboData.getCodigo_recibo());
            ProcedimientoAlmacenado.setString(5, reciboData.getNombre_empresa());
            ProcedimientoAlmacenado.setInt(6, reciboData.getPrecio());

            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Recibo añadido");
            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
       public ResultSet GetRecibos() {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call mostrar_recibo}");
            consulta = ProcedimientoAlmacenado.executeQuery();
//             db_connection.CloseConnection(conexion);
            return consulta;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;

    }
         public void UpdateRecibo(Recibo reciboData, int id) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call actualizar_recibo(?,?,?,?,?,?,?)}");

            ProcedimientoAlmacenado.setInt(1, id);
           ProcedimientoAlmacenado.setInt(2, reciboData.getId_persona());
            ProcedimientoAlmacenado.setInt(3, reciboData.getId_finca());    
            ProcedimientoAlmacenado.setDate(4, reciboData.getFecha());
            ProcedimientoAlmacenado.setString(5, reciboData.getCodigo_recibo());
            ProcedimientoAlmacenado.setString(6, reciboData.getNombre_empresa());
            ProcedimientoAlmacenado.setInt(7, reciboData.getPrecio());
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Recibo Actualizado");
            db_connection.CloseConnection();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
          public void DeleteRecibo (int id) {
            try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call eliminar_recibo(?)}");

            ProcedimientoAlmacenado.setInt(1, id);
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Recibo Eliminado");
//            db_connection.CloseConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

       public void AddFincaServicio(int idFinca, int idServicio, int idPersona) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call agregar_servicio_finca(?,?,?)}");

            ProcedimientoAlmacenado.setInt(1, idServicio);
           ProcedimientoAlmacenado.setInt(2, idFinca);
           ProcedimientoAlmacenado.setInt(3, idPersona);
            
            ProcedimientoAlmacenado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Servicio añadido a Finca");
            db_connection.CloseConnection();
        }catch(SQLIntegrityConstraintViolationException e){
//                 System.out.println(e);
                JOptionPane.showMessageDialog(null,"Esta Finca ya cuenta con ese Servicio");
             
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }  
         
         
}
