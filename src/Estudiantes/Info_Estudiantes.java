/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estudiantes;

/**
 *
 * @author user
 */
public class Info_Estudiantes {

    
    private String nombreEstudiante;   
    private int idEstudiante;
    private int edadEstudiante;
    private String correoEstudiante;
    private int celularEstudiante;
    private int numeroCedulaES;
    
    

public Info_Estudiantes(String nombreEstudiante, int idEstudiante, int edadEstudiante, String correoEstudiante, int celularEstudiante, int numeroCedulaES) {
        this.nombreEstudiante = nombreEstudiante;
        this.idEstudiante = idEstudiante;
        this.edadEstudiante = edadEstudiante;
        this.correoEstudiante = correoEstudiante;
        this.celularEstudiante = celularEstudiante;
        this.numeroCedulaES = numeroCedulaES;
    }    

    Info_Estudiantes(String nombre, int edad, String correo, int celular, int cedula) {
        
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public int getEdadEstudiante() {
        return edadEstudiante;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public int getCelularEstudiante() {
        return celularEstudiante;
    }

    public int getNumeroCedulaES() {
        return numeroCedulaES;
    }
 
    
 @Override
    public String toString() {
        return    "Id de Estudiante del estudiante: " + idEstudiante + "\n" 
                + "Nombre Completo del estudiante: " + nombreEstudiante + "\n"
                + "Numero de Cedula del estudiante: " + numeroCedulaES + "\n"
                + "Edad del estudiante: " + edadEstudiante + "\n" 
                + "Correo Electronico del estudiante: " + correoEstudiante + "\n" 
                + "Numero de telefono del estudiante: " + celularEstudiante;
    }    

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setEdadEstudiante(int edadEstudiante) {
        this.edadEstudiante = edadEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public void setCelularEstudiante(int celularEstudiante) {
        this.celularEstudiante = celularEstudiante;
    }

    public void setNumeroCedulaES(int numeroCedulaES) {
        this.numeroCedulaES = numeroCedulaES;
    }
    
    
    
    
}
