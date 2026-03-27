/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Asignaturas.Gestion_Cursos;
import Asistencia.Gestion_Asistencia;
import Auxiliares.Funciones_Auxiliares;
import Estudiantes.Gestion_Estudiantes;
import Reportes.Reportes;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Gestor_Submenus {
    
    
    
    public static void Cursos(){
        
        Gestion_Cursos GCursos = new Gestion_Cursos();
        Funciones_Auxiliares FAuxiliares = new Funciones_Auxiliares();
    
        int opcion = 0;
        
        do {
            String opciones[] = {"Crear Curso","Modificar Curso","Eliminar Curso","Matricular Estudiante","Eliminar Matricula","Regresar al Menu Anterior"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una Opcion para continuar",
                                 "Modulo de Gestion de Cursos", JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            switch(opcion){
                case 0:
                    GCursos.Crear_Curso();
                    break;
                case 1:
                    GCursos.Modificar_Curso();
                    break;
                case 2:
                    GCursos.Eliminar_Curso();
                    break;
                case 3:
                    FAuxiliares.Matricular_Estudiante();
                    break;
                case 4:
                    FAuxiliares.Eliminar_Matricula();
                    break;
            }

        } while(opcion != 5);
    }
    public static void Estudiantes(){
        
        Gestion_Estudiantes GEstudiantes = new Gestion_Estudiantes();
        Funciones_Auxiliares FAuxiliares = new Funciones_Auxiliares();
    
        int opcion = 0;
        
        do {
            String opciones[] = {"Crear Estudiante","Modificar Estudiante","Eliminar Estudiante","Matricular Curso","Eliminar Matricula","Regresar al Menu Anterior"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una Opcion para continuar",
                                 "Modulo de Gestion de Estudiantes", JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            switch(opcion){
                case 0:
                    GEstudiantes.Crear_Estudiante();
                    break;
                case 1:
                    GEstudiantes.Modificar_Estudiante();
                    break;
                case 2:
                    GEstudiantes.Eliminar_Estudiante();
                    break;
                case 3:
                    GEstudiantes.Matricular_Estudiante();
                    break;
                case 4:
                    FAuxiliares.Eliminar_Matricula();
                    break;
            }

        } while(opcion != 5);
    }
    public static void Asistencia(){
        
        Gestion_Asistencia GAsistencia = new Gestion_Asistencia();
    
        int opcion = 0;
        
        do {
            String opciones[] = {"Pasar Lista","Modificar Asistencia","Generar Lista de Asistencia","Regresar al Menu Anterior"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una Opcion para continuar",
                                 "Modulo de Gestion de Estudiantes", JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            switch(opcion){
                case 0:
                    GAsistencia.Pasar_Lista();
                    break;
                case 1:
                    GAsistencia.Modificar_Asistencia();
                    break;
                case 2:
                    GAsistencia.Generar_Lista();
                    break;
            }

        } while(opcion != 3);
    }
    public static void Reportes(){
    
        Reportes GReportes = new Reportes();
    
        int opcion = 0;
        
        do {
            String opciones[] = {"Reportes de Asignaturas","Reportes de Estudiantes","Regresar al Menu Anterior"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione la categoria del repote deseado",
                                 "Modulo de Reportes", JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            switch(opcion){
                case 0:
                    int opcionA = 0;
        
                    do {
                        String opcionesA[] = {"Reporte de Asistencia","Regresar al Menu Anterior"};
                        opcionA = JOptionPane.showOptionDialog(null, "Seleccione El Reporte Deseado",
                                             "Reportes de la asignatura", JOptionPane.DEFAULT_OPTION,
                                             JOptionPane.QUESTION_MESSAGE, null, opcionesA, opcionesA[0]);

                        switch(opcionA){
                            case 0:
                                GReportes.Asistencia_Curso();
                                break;
                        }

                    } while(opcionA != 1);
                    break;
                case 1:
                    int opcionE = 0;
        
                    do {
                        String opcionesE[] = {"Datos del Estudiante","Reporte de Asistencia","Regresar al Menu Anterior"};
                        opcionE = JOptionPane.showOptionDialog(null, "Seleccione El Reporte Deseado",
                                             "Reportes Estudiantiles", JOptionPane.DEFAULT_OPTION,
                                             JOptionPane.QUESTION_MESSAGE, null, opcionesE, opcionesE[0]);

                        switch(opcionE){
                            case 0:
                                GReportes.Datos_Estudiante();
                                break;
                            case 1:
                                GReportes.Asistencia_Estudiante();
                                break;
                        }

                    } while(opcionE != 2);
                    break;
            }

        } while(opcion != 2);
    }
    
}
