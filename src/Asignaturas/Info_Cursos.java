/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asignaturas;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Info_Cursos {
    
    private String nombreCurso;
    private String IDCurso;
    private String Profesor;
    private int Duracion;

public Info_Cursos(String nombreCurso, String IDCurso, String profesor, int Duracion) {
    this.nombreCurso = nombreCurso;
    this.IDCurso = IDCurso;
    this.Profesor = profesor;
    this.Duracion = Duracion;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getIDCurso() {
        return IDCurso;
    }

    public void setIDCurso(String IDCurso) {
        this.IDCurso = IDCurso;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String Profesor) {
        this.Profesor = Profesor;
    }
    
    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    @Override
    public String toString() {
        return "Nombre del curso: " + nombreCurso + "\n" +
                "Codigo del curso: " + IDCurso + "\n" +
                "Profesor del curso: " + Profesor + "\n" +
                "Duracion del curso: " + Duracion + " Semanas";
    }
    
  
}
