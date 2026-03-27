/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estudiantes;

import javax.swing.JOptionPane;

public class Gestion_Estudiantes {

    public static Info_Estudiantes[] estudiantes = new Info_Estudiantes[1];
    public static int contador = 0;



    public static void Crear_Estudiante() {

        if (contador < estudiantes.length) {

            int id = contador + 1;

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante:"));
            String correo = JOptionPane.showInputDialog("Ingrese el correo del estudiante:");
            int celular = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:"));
            int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del estudiante:"));

            estudiantes[contador++] = new Info_Estudiantes(nombre, id, edad, correo,celular,cedula);

            JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más estudiantes");
        }

    }

    public static void mostrarEstudiantes() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }

        String info = "Lista de estudiantes:\n";

        for (int i = 0; i < contador; i++) {
            info += estudiantes[i].toString();
            info += "\n";
            info += "----------------------\n";
        }

        JOptionPane.showMessageDialog(null, info);

    }

    public static void buscarEstudiante() {

        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante:"));

        Info_Estudiantes encontrado = null;

        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getIdEstudiante() == idBuscar) {
                encontrado = estudiantes[i];
                break;
            }
        }

        if (encontrado != null) {
            JOptionPane.showMessageDialog(null, encontrado.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
        }

    }

    public static void Modificar_Estudiante() {

        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante:"));

        Info_Estudiantes estudianteEditar = null;

        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getIdEstudiante() == idBuscar) {
                estudianteEditar = estudiantes[i];
                break;
            }
        }

        if (estudianteEditar != null) {

            String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
            estudianteEditar.setNombreEstudiante(nombre);

            int edad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:"));
            estudianteEditar.setEdadEstudiante(edad);

            String correo = JOptionPane.showInputDialog("Nuevo correo:");
            estudianteEditar.setCorreoEstudiante(correo);

            int celular =  Integer.parseInt(JOptionPane.showInputDialog("Nuevo teléfono:"));
            estudianteEditar.setCelularEstudiante(celular);

            int cedula =  Integer.parseInt(JOptionPane.showInputDialog("Nueva cédula:"));
            estudianteEditar.setNumeroCedulaES(cedula);

            JOptionPane.showMessageDialog(null, "Estudiante actualizado");

        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
        }

    }

    public static void Eliminar_Estudiante() {

        int indice = -1;

        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante:"));

        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getIdEstudiante() == idBuscar) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
            return;
        }

        for (int i = indice; i < contador - 1; i++) {
            estudiantes[i] = estudiantes[i + 1];
        }

        estudiantes[contador - 1] = null;
        contador--;

        JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente");

    }

 public static void Matricular_Estudiante() {

    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del estudiante:"));
    Info_Estudiantes estudiante = null;

    for (int i = 0; i < contador; i++) {
        if (estudiantes[i].getIdEstudiante() == idBuscar) {
            estudiante = estudiantes[i];
            break;
        }
    }

    if (estudiante != null) {

        String curso = JOptionPane.showInputDialog("Digite el nombre del curso a matricular:");

        JOptionPane.showMessageDialog(null, "Estudiante matriculado en el curso: " + curso);

    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
    }
}   
 
public static void Eliminar_Matricula() {

    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del estudiante:"));
    Info_Estudiantes estudiante = null;

    for (int i = 0; i < contador; i++) {
        if (estudiantes[i].getIdEstudiante() == idBuscar) {
            estudiante = estudiantes[i];
            break;
        }
    }

    if (estudiante != null) {

        String curso = JOptionPane.showInputDialog("Digite el nombre del curso a retirar:");

        JOptionPane.showMessageDialog(null, "Estudiante retirado del curso: " + curso);

    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
    }
}    

public static void buscarCurso() {

    String cursoBuscar = JOptionPane.showInputDialog("Digite el nombre del curso:");

    boolean encontrado = false;

    for (int i = 0; i < contador; i++) {

        if (estudiantes[i].toString().contains(cursoBuscar)) {
            JOptionPane.showMessageDialog(null, estudiantes[i].toString());
            encontrado = true;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontró el curso");
    }
}

}
