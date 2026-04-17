/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estudiantes;

import Asignaturas.Gestion_Cursos;
import Asistencia.Gestion_Asistencia;
import javax.swing.JOptionPane;

public class Gestion_Estudiantes {

    public static Info_Estudiantes[] estudiantes = new Info_Estudiantes[20];
    public static int contador = 0;



    public static void Crear_Estudiante() {

        if (contador < estudiantes.length) {

            int id = contador + 1;

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            if (nombre == null) return;
            String inputEdad = JOptionPane.showInputDialog("Ingrese la edad del estudiante:");
            if (inputEdad == null) return;
            int edad = Integer.parseInt(inputEdad);
            String correo = JOptionPane.showInputDialog("Ingrese el correo del estudiante:");
            if (correo == null) return;
            String inputCelular = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
            if (inputCelular == null) return;
            int celular = Integer.parseInt(inputCelular);
            String inputCedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
            if (inputCedula == null) return;
            int cedula = Integer.parseInt(inputCedula);

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

        String inputId = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
        if (inputId == null) return;
        int idBuscar = Integer.parseInt(inputId);

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

        String inputId = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
        if (inputId == null) return;
        int idBuscar = Integer.parseInt(inputId);

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

        String inputId = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
        if (inputId == null) return;
        int idBuscar = Integer.parseInt(inputId);

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
        
        //Elimina la Matricula del estudiante de cualquier curso en el que se encuentre matriculado
        Gestion_Asistencia.RetiroCompleto(idBuscar);

        for (int i = indice; i < contador - 1; i++) {
            estudiantes[i] = estudiantes[i + 1];
        }

        estudiantes[contador - 1] = null;
        contador--;

        JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente");

    }

    public static void Matricular_Estudiante() {

       String inputId = JOptionPane.showInputDialog("Digite el ID del estudiante:");
       if (inputId == null) return;
       int idBuscar = Integer.parseInt(inputId);
       
       Info_Estudiantes estudiante = null;

       for (int i = 0; i < contador; i++) {
           if (estudiantes[i].getIdEstudiante() == idBuscar) {
               estudiante = estudiantes[i];
               break;
           }
       }

       if (estudiante == null) {
           JOptionPane.showMessageDialog(null, "No se encontró el estudiante.");
           return;
       }

       String codigoCurso = JOptionPane.showInputDialog("Digite el código del curso a matricular:");
       if (codigoCurso == null) return;
       codigoCurso = codigoCurso.trim();

       // Verificar que el curso existe
       boolean cursoExiste = false;
       for (int i = 0; i < Gestion_Cursos.contador; i++) {
           if (Gestion_Cursos.info_cursos[i].getIDCurso().equals(codigoCurso)) {
               cursoExiste = true;
               break;
           }
       }

       if (!cursoExiste) {
           JOptionPane.showMessageDialog(null, "No existe un curso con ese código.");
           return;
       }

       int posCurso = Gestion_Asistencia.BuscarCurso(codigoCurso);
       boolean agregado = false;
       if (posCurso != -1) {
           agregado = Gestion_Asistencia.cursos[posCurso]
                   .agregarEstudiante(estudiante.getNombreEstudiante(), estudiante.getIdEstudiante());
       }

       if (agregado) {
           JOptionPane.showMessageDialog(null, "Estudiante " + estudiante.getNombreEstudiante()
                   + " matriculado en el curso: " + codigoCurso);
       } else {
           JOptionPane.showMessageDialog(null, "No se pudo matricular. El estudiante ya está matriculado o el curso está lleno.");
       }
   }

    public static void Eliminar_Matricula() {

        String input = JOptionPane.showInputDialog("Digite el ID del estudiante:");
        if (input == null) return;
        int idBuscar = Integer.parseInt(input);
        
        Info_Estudiantes estudiante = null;

        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getIdEstudiante() == idBuscar) {
                estudiante = estudiantes[i];
                break;
            }
        }

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante.");
            return;
        }

        String codigoCurso = JOptionPane.showInputDialog("Digite el código del curso a retirar:");
        if (codigoCurso == null) return;
        codigoCurso = codigoCurso.trim();

        int posCurso = Gestion_Asistencia.BuscarCurso(codigoCurso);
        if (posCurso == -1) {
            JOptionPane.showMessageDialog(null, "No existe un curso con ese código.");
            return;
        }

        boolean eliminado = Gestion_Asistencia.cursos[posCurso]
                .eliminarEstudiante(estudiante.getIdEstudiante());

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Estudiante " + estudiante.getNombreEstudiante()
                    + " retirado del curso: " + codigoCurso);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró al estudiante en ese curso.");
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

    public static void Crear_EstudianteT(String nombre, int edad, String correo, int celular, int cedula){
    
        if (contador < estudiantes.length) {

            int id = contador + 1;

            estudiantes[contador++] = new Info_Estudiantes(nombre, id, edad, correo,celular,cedula);

        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más estudiantes");
            
        }
    }
    
    public static void Datos_Estudiante(){
    
        if (contador == 0 ) {
            JOptionPane.showMessageDialog(null,"No hay estudiantes registrados");
            return;
        }
        
        String input = JOptionPane.showInputDialog("Ingrese el ID del esdudiante");
        
        if (input == null) return;
        
        int idBuscar = Integer.parseInt(input);
        
        Info_Estudiantes estudiante = null;
        
        for (int i =0; i < contador; i++) {
            if (estudiantes[i].getIdEstudiante() == idBuscar) {
                estudiante = estudiantes[i];
                break;
            }
            
        }
        
        if (estudiante == null) {
           JOptionPane.showMessageDialog(null,"No se encontro el estudiante");
           return;
        }
        
        String reporte = "==== Reporte de Datos del Estudiante =====\n\n";
        reporte += estudiante.toString();
        reporte += "\n\n==================================";
        
        JOptionPane.showMessageDialog(null, reporte);
                
       
    }

}
