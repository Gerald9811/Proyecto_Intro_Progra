/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asistencia;

public class Asistencia {

    public String codigoCurso;
    public String nombreCurso;
    public int semanas;
    public int cantidadEstudiantes;
    public String[][] matriz;
    public String[] estudiantes;

    public Asistencia(String codigoCurso, String nombreCurso, int semanas, int cantidadEstudiantes) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.semanas = semanas;
        this.cantidadEstudiantes = cantidadEstudiantes;

        matriz = new String[cantidadEstudiantes][semanas];
        estudiantes = new String[cantidadEstudiantes];

        for (int i = 0; i < cantidadEstudiantes; i++) {
            estudiantes[i] = "Estudiante " + (i + 1);

            for (int j = 0; j < semanas; j++) {
                matriz[i][j] = "";
            }
        }
    }
}
