/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import javax.swing.JOptionPane;
import Auxiliares.Test_Data;

/**
 *
 * @author users
 */
public class Menu {
      
    //Funciones de Testeo del sistema
    
    public static void test(){
        Test_Data.Test_Data();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //Cargar Datos de Testeo
        test();
        
        Gestor_Submenus Gestion = new Gestor_Submenus();
        
        int opcion = 0;
        
        do {
            String opciones[] = {"Gestion de Cursos","Gestion de Estudiantes","Gestion de Asistencia","Reportes","Salir del sistema"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una Opcion para continuar",
                                 "Sistema de Gestion de Asistencia Fide", JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            switch(opcion){
                case 0:
                    Gestion.Cursos();
                    break;
                case 1:
                    Gestion.Estudiantes();
                    break;
                case 2:
                    Gestion.Asistencia();
                    break;
                case 3:
                    Gestion.Reportes();
                    break;
            }

        } while(opcion != 4);
        
    }
    
}
