/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import javax.swing.JOptionPane;
import Asistencia.Gestion_Asistencia;
import Estudiantes.Gestion_Estudiantes;

/**
 *
 * @author user
 */
public class Reportes {
    

    public static void Asistencia_Curso(){
        Gestion_Asistencia.Generar_Lista();
    }
    public static void Asistencia_Estudiante(){
        Gestion_Asistencia.AsistenciaXEstudiante();
    }
    public static void Datos_Estudiante(){
        Gestion_Estudiantes.Datos_Estudiante();
    }
    
}
