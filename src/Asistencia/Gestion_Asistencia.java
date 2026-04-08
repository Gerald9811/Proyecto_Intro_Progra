/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asistencia;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gestion_Asistencia {

    public static Asistencia[] cursos = new Asistencia[20];
    public static int contador = 0;

    // Llamado automáticamente al crear un curso en Gestion_Cursos
    public static void CrearCurso(String codigo, String nombre) {
        if (contador >= cursos.length) return;
        if (BuscarCurso(codigo) != -1) return; // ya existe
        cursos[contador] = new Asistencia(codigo, nombre);
        contador++;
    }

    // Llamado automáticamente al eliminar un curso en Gestion_Cursos
    public static void EliminarCurso(String codigo) {
        int pos = BuscarCurso(codigo);
        if (pos == -1) return;
        for (int i = pos; i < contador - 1; i++) {
            cursos[i] = cursos[i + 1];
        }
        cursos[contador - 1] = null;
        contador--;
    }

    // Llamado al matricular un estudiante en un curso
    public static void MatricularEstudiante(String codigoCurso, String nombre, int id) {
        int pos = BuscarCurso(codigoCurso);
        if (pos == -1) return;
        cursos[pos].agregarEstudiante(nombre, id);
    }

    // Llamado al quitar la matrícula de un estudiante
    public static void EliminarEstudiante(String codigoCurso, int id) {
        int pos = BuscarCurso(codigoCurso);
        if (pos == -1) return;
        cursos[pos].eliminarEstudiante(id);
    }

    public static int BuscarCurso(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].codigoCurso.equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    // Pasa la lista para UNA semana específica, con opciones P/A/T/J
    public static void Pasar_Lista() {
        String codigo = JOptionPane.showInputDialog("Digite el código del curso:");
        if (codigo == null) return;
        codigo = codigo.trim();

        int pos = BuscarCurso(codigo);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        Asistencia curso = cursos[pos];

        if (curso.cantidadEstudiantes == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes matriculados en este curso.");
            return;
        }

        String semanaStr = JOptionPane.showInputDialog(
                "Curso: " + curso.nombreCurso + " (" + curso.codigoCurso + ")\n"
                + "Ingrese el número de semana (1-" + Asistencia.SEMANAS + "):");
        if (semanaStr == null) return;

        int semana;
        try {
            semana = Integer.parseInt(semanaStr.trim()) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de semana inválido.");
            return;
        }

        if (semana < 0 || semana >= Asistencia.SEMANAS) {
            JOptionPane.showMessageDialog(null, "Semana fuera de rango. Debe ser entre 1 y " + Asistencia.SEMANAS + ".");
            return;
        }

        String[] opciones = {"P - Presente", "A - Ausente", "T - Tarde", "J - Justificado", "Cancelar"};

        for (int i = 0; i < curso.cantidadEstudiantes; i++) {
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Curso: " + curso.nombreCurso + " (" + curso.codigoCurso + ")\n"
                    + "Semana " + (semana + 1) + " de " + Asistencia.SEMANAS + "\n\n"
                    + "Estudiante " + (i + 1) + " de " + curso.cantidadEstudiantes + ": "
                    + curso.nombreEstudiantes[i] + "\n"
                    + "Estado actual: " + curso.matriz[i][semana],
                    "Pasar Lista - Semana " + (semana + 1),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opcion == JOptionPane.CLOSED_OPTION || opcion == 4) {
                // Cancelar o cerrar: detiene el recorrido
                break;
            }
            curso.matriz[i][semana] = String.valueOf(opciones[opcion].charAt(0));
        }

        JOptionPane.showMessageDialog(null, "Lista de la semana " + (semana + 1) + " guardada.");
    }

    // Modifica la asistencia de un estudiante específico en una semana específica
    public static void Modificar_Asistencia() {
        String codigo = JOptionPane.showInputDialog("Digite el código del curso:");
        if (codigo == null) return;
        codigo = codigo.trim();

        int pos = BuscarCurso(codigo);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        Asistencia curso = cursos[pos];

        if (curso.cantidadEstudiantes == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes matriculados en este curso.");
            return;
        }

        // Mostrar lista de estudiantes
        StringBuilder lista = new StringBuilder();
        lista.append("Estudiantes en ").append(curso.nombreCurso).append(":\n\n");
        for (int i = 0; i < curso.cantidadEstudiantes; i++) {
            lista.append(i + 1).append(". ").append(curso.nombreEstudiantes[i])
                 .append(" (ID: ").append(curso.idEstudiantes[i]).append(")\n");
        }
        lista.append("\nIngrese el número del estudiante:");

        String numEstStr = JOptionPane.showInputDialog(lista.toString());
        if (numEstStr == null) return;

        int numEst;
        try {
            numEst = Integer.parseInt(numEstStr.trim()) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido.");
            return;
        }

        if (numEst < 0 || numEst >= curso.cantidadEstudiantes) {
            JOptionPane.showMessageDialog(null, "Número de estudiante fuera de rango.");
            return;
        }

        String semanaStr = JOptionPane.showInputDialog(
                "Estudiante: " + curso.nombreEstudiantes[numEst] + "\n"
                + "Ingrese el número de semana a modificar (1-" + Asistencia.SEMANAS + "):");
        if (semanaStr == null) return;

        int semana;
        try {
            semana = Integer.parseInt(semanaStr.trim()) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de semana inválido.");
            return;
        }

        if (semana < 0 || semana >= Asistencia.SEMANAS) {
            JOptionPane.showMessageDialog(null, "Semana fuera de rango.");
            return;
        }

        String[] opciones = {"P - Presente", "A - Ausente", "T - Tarde", "J - Justificado"};
        int opcion = JOptionPane.showOptionDialog(
                null,
                "Curso: " + curso.nombreCurso + "\n"
                + "Estudiante: " + curso.nombreEstudiantes[numEst] + "\n"
                + "Semana: " + (semana + 1) + "\n"
                + "Estado actual: " + curso.matriz[numEst][semana] + "\n\n"
                + "Seleccione el nuevo estado:",
                "Modificar Asistencia",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcion != JOptionPane.CLOSED_OPTION) {
            curso.matriz[numEst][semana] = String.valueOf(opciones[opcion].charAt(0));
            JOptionPane.showMessageDialog(null,
                    "Asistencia actualizada.\n"
                    + "Estudiante: " + curso.nombreEstudiantes[numEst]
                    + " | Semana " + (semana + 1)
                    + " | Estado: " + curso.matriz[numEst][semana]);
        }
    }

    // Muestra la matriz completa del curso en una tabla scrollable
    public static void Generar_Lista() {
        String codigo = JOptionPane.showInputDialog("Digite el código del curso:");
        if (codigo == null) return;
        codigo = codigo.trim();

        int pos = BuscarCurso(codigo);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        Asistencia curso = cursos[pos];

        if (curso.cantidadEstudiantes == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes matriculados en este curso.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("LISTA DE ASISTENCIA\n");
        sb.append("Curso : ").append(curso.nombreCurso).append("\n");
        sb.append("Código: ").append(curso.codigoCurso).append("\n\n");

        // Encabezado de semanas
        sb.append(String.format("%-22s", "Estudiante"));
        for (int j = 0; j < Asistencia.SEMANAS; j++) {
            sb.append(String.format(" S%-2d", j + 1));
        }
        sb.append("\n");
        sb.append("-".repeat(22 + Asistencia.SEMANAS * 4)).append("\n");

        // Fila por estudiante
        for (int i = 0; i < curso.cantidadEstudiantes; i++) {
            String nombre = curso.nombreEstudiantes[i];
            if (nombre.length() > 21) nombre = nombre.substring(0, 21);
            sb.append(String.format("%-22s", nombre));
            for (int j = 0; j < Asistencia.SEMANAS; j++) {
                sb.append(String.format("  %-2s", curso.matriz[i][j]));
            }
            sb.append("\n");
        }

        sb.append("\nReferencia: P=Presente  A=Ausente  T=Tarde  J=Justificado  -=Sin registro");

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(760, 320));

        JOptionPane.showMessageDialog(null, scrollPane,
                "Lista de Asistencia - " + curso.nombreCurso,
                JOptionPane.PLAIN_MESSAGE);
    }
}
