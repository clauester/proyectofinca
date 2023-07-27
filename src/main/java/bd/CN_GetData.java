/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import clases.Finca;
import clases.Persona;
import clases.Servicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Davila
 */
public class CN_GetData {

    private final CN_Connection db_connection = new CN_Connection();
    public static ResultSet consulta;
    
    public ResultSet IniciarSesion(String cedula, String contrasenia){
        try{
             Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call iniciar_sesion(?,?)}");
            ProcedimientoAlmacenado.setString(1, cedula);
            ProcedimientoAlmacenado.setString(2, contrasenia);
             ProcedimientoAlmacenado.registerOutParameter(3, java.sql.Types.INTEGER);
              ProcedimientoAlmacenado.executeUpdate();

            
            consulta = ProcedimientoAlmacenado.executeQuery();
//             db_connection.CloseConnection(conexion);
            return consulta;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return consulta;
    }

    public ResultSet GetPropietarios() {

        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call mostrar_persona}");
            consulta = ProcedimientoAlmacenado.executeQuery();
//             db_connection.CloseConnection(conexion);
            return consulta;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
    }

    public ResultSet SearchPropietario(String apellido) {
        try {
            Connection conexion = db_connection.OpenConnection();
            CallableStatement ProcedimientoAlmacenado = conexion.prepareCall("{call buscar_persona(?)}");
            ProcedimientoAlmacenado.setString(1, apellido);
            consulta = ProcedimientoAlmacenado.executeQuery();
            return consulta;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return consulta;
    }

    public void AddPropietario(Persona personaData) {
        try {
            Connection conexion = db_connection.OpenConnection();
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

    public void UpdatePropietario(Persona personaData, int id) {
        try {
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

}
