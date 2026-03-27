/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asistencia;

import javax.swing.JOptionPane;

public class Gestion_Asistencia {

    Asistencia[] cursos = new Asistencia[10];
    int contador = 0;

    public void Pasar_Lista() {

        String codigo = JOptionPane.showInputDialog("Digite el código del curso:");

        int pos = BuscarCurso(codigo);

        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        Asistencia curso = cursos[pos];

        for (int i = 0; i < curso.cantidadEstudiantes; i++) {

            for (int j = 0; j < curso.semanas; j++) {

                String estado = JOptionPane.showInputDialog(
                        "Estudiante: " + curso.estudiantes[i]
                        + "\nSemana: " + (j + 1)
                        + "\nDigite P (Presente), A (Ausente), J (Justificado):"
                );

                curso.matriz[i][j] = estado;
            }
        }

        JOptionPane.showMessageDialog(null, "Asistencia registrada.");
    }

    public void Modificar_Asistencia() {

        String codigo = JOptionPane.showInputDialog("Digite el código del curso:");

        int pos = BuscarCurso(codigo);

        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        Asistencia curso = cursos[pos];

        int estudiante = Integer.parseInt(JOptionPane.showInputDialog("Número de estudiante:")) - 1;
        int semana = Integer.parseInt(JOptionPane.showInputDialog("Número de semana:")) - 1;

        String estado = JOptionPane.showInputDialog("Nuevo estado (P/A/J):");

        curso.matriz[estudiante][semana] = estado;

        JOptionPane.showMessageDialog(null, "Asistencia modificada.");
    }

    public void Generar_Lista() {

        String codigo = JOptionPane.showInputDialog("Digite el código del curso:");

        int pos = BuscarCurso(codigo);

        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        Asistencia curso = cursos[pos];

        String texto = "LISTA DE ASISTENCIA\n\n";

        for (int i = 0; i < curso.cantidadEstudiantes; i++) {

            texto += curso.estudiantes[i] + ": ";

            for (int j = 0; j < curso.semanas; j++) {
                texto += "[" + curso.matriz[i][j] + "]";
            }

            texto += "\n";
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    public void Consulta_Asistencia() {
        Generar_Lista();
    }

    public int BuscarCurso(String codigo) {

        for (int i = 0; i < contador; i++) {
            if (cursos[i].codigoCurso.equalsIgnoreCase(codigo)) {
                return i;
            }
        }

        return -1;
    }

    public void CrearCurso() {

        String codigo = JOptionPane.showInputDialog("Código del curso:");
        String nombre = JOptionPane.showInputDialog("Nombre del curso:");
        int semanas = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de semanas:"));
        int estudiantes = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes:"));

        cursos[contador] = new Asistencia(codigo, nombre, semanas, estudiantes);
        contador++;

        JOptionPane.showMessageDialog(null, "Curso creado.");
    }
}
