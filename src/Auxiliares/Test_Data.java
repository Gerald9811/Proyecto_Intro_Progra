/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auxiliares;

import Asignaturas.Gestion_Cursos;
import Estudiantes.Gestion_Estudiantes;

/**
 *
 * @author user
 */
public class Test_Data {
    
    public static void Test_Data (){
        
        //Crear cursos de prueba
        Gestion_Cursos.Crear_CursoT("Espanol", "ES01", "Zulema");
        Gestion_Cursos.Crear_CursoT("Matematica", "MA01", "Mayela");
        Gestion_Cursos.Crear_CursoT("Sociales", "SO01", "Mabelyn");
        
        //Crear estudiantes de prueba
        Gestion_Estudiantes.Crear_EstudianteT("Gerald", 27, "geortiz", 5068001, 1001);
        Gestion_Estudiantes.Crear_EstudianteT("Enrique", 27, "enortiz", 5068002, 1002);
        Gestion_Estudiantes.Crear_EstudianteT("Maria", 25, "maortiz", 5068003, 1003);
        
    }
    
    
}
