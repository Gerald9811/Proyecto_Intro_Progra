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
    
    public static Info_Cursos info_cursos[] = new Info_Cursos[20];
    public static int contador = 0;

    public static void Crear_Curso(){
        if (contador < info_cursos.length) {
            
            String nombreCurso = JOptionPane.showInputDialog("Digite el nombre del curso: ");
            String IDCurso = JOptionPane.showInputDialog("Digite el codigo del curso: ");
            String Profesor = JOptionPane.showInputDialog("Ingrese el nombre del docente del curso: ");
            JOptionPane.showMessageDialog(null, "La duracion Estandar del curso sera programada a 15 semanas.");
            int Duracion = 15;

            info_cursos[contador++] = new Info_Cursos(nombreCurso, IDCurso, Profesor, Duracion);
            
        } else {
            JOptionPane.showMessageDialog(null, "Limite de cursos excedido.");
    }
    
    }
    public static void Modificar_Curso(){
        String codigoBusqueda = JOptionPane.showInputDialog("Digite el codigo del curso a modificar: ");
        Info_Cursos cursoAModificar = null;

        for (int i = 0; i < contador; i++) {
            if (info_cursos[i].getIDCurso().equals(codigoBusqueda)) {
                cursoAModificar = info_cursos[i];
                break;
            }

        }

        if (cursoAModificar != null) {
            
            String nombreCurso = JOptionPane.showInputDialog("Digite el nombre del curso: ");
            cursoAModificar.setNombreCurso(nombreCurso);
            String IDCurso = JOptionPane.showInputDialog("Digite el codigo del curso: ");
            cursoAModificar.setIDCurso(IDCurso);
            String Profesor = JOptionPane.showInputDialog("Ingrese el nombre del docente del curso: ");
            cursoAModificar.setProfesor(Profesor);
            JOptionPane.showMessageDialog(null, "La duracion Estandar del curso sera programada a 15 semanas.");
            int Duracion = 15;
            cursoAModificar.setDuracion(Duracion);

            JOptionPane.showMessageDialog(null, "Curso actualizado: " + cursoAModificar.toString());
        } else  {
            JOptionPane.showMessageDialog(null, "No se encontro un curso con ese codigo.");
        }


    }
    public static void Eliminar_Curso(){
        int indice = -1;
        String codigoBusqueda = JOptionPane.showInputDialog("Digite el codigo del curso a eliminar: ");

        for (int i = 0; i < contador; i++) {
            if (info_cursos[i].getIDCurso().equals(codigoBusqueda)) {
                indice = i;
                break;
            }

        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "No se encontro un curso con ese codigo.");
            return;
        }

        for (int i = indice; i < contador - 1; i++) {
            info_cursos[i] = info_cursos[i + 1];
        }

        info_cursos[contador - 1] = null;

        contador--;
    }
    public void buscarCurso() {
    Info_Cursos encontrado = null;
    String codigoBusqueda = JOptionPane.showInputDialog("Digite el codigo del curso a buscar: ");
    
    for (int i = 0; i < contador; i++) {
        info_cursos[i] = encontrado;
        break;
    }
    
    if (encontrado != null) {
        JOptionPane.showMessageDialog(null, "Curso encontrado: " + info_cursos.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No se encuentran cursos registrados.");
    }
        
}
    
}
