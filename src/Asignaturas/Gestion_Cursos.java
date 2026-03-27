/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Asignaturas;

import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Gestion_Cursos {

 public static void menucursos(){
        int menuDeOpciones = 0;
        Info_Cursos cursos = new Info_Cursos("Introduccion a la Programacion Orientada a Objetos", "SC-202", 4);
        
        do {
            menuDeOpciones = Integer.parseInt(JOptionPane.showInputDialog("Menu de cursos \n\n" +
                                                                          "1. Crear curso \n" +
                                                                          "2. Modificar curso \n" +
                                                                          "3. Eliminar curso \n" +
                                                                          "4. Matricular estudiante \n" +
                                                                          "5. Eliminar estudiante \n" +
                                                                          "6. Buscar curso \n" +
                                                                          "7. Buscar estudiante \n" +
                                                                          "8. Calcular duracion \n" +
                                                                          "9. Salir del menu \n\n" +
                                                                          "Digite un numero para seleccionar en el menu: "));
            
 
            
            
            switch (menuDeOpciones) {
                case 1:
                    cursos.crearCurso();
                    break;
                case 2:
                    cursos.modificarCurso();
                    break;
                case 3:
                    cursos.eliminarCurso();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    cursos.buscarCurso();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del menu...");
                    break;
                 
            }
            
        } while (menuDeOpciones != 10);
        
    }
    
}
