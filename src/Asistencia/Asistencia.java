/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asistencia;

public class Asistencia {

    public static final int MAX_ESTUDIANTES = 50;
    public static final int SEMANAS = 15;

    public String codigoCurso;
    public String nombreCurso;
    public int cantidadEstudiantes;
    public String[][] matriz;           // [MAX_ESTUDIANTES][SEMANAS]
    public String[] nombreEstudiantes;
    public int[] idEstudiantes;

    public Asistencia(String codigoCurso, String nombreCurso) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.cantidadEstudiantes = 0;
        this.matriz = new String[MAX_ESTUDIANTES][SEMANAS];
        this.nombreEstudiantes = new String[MAX_ESTUDIANTES];
        this.idEstudiantes = new int[MAX_ESTUDIANTES];

        for (int i = 0; i < MAX_ESTUDIANTES; i++) {
            for (int j = 0; j < SEMANAS; j++) {
                matriz[i][j] = "-";
            }
        }
    }

    public boolean agregarEstudiante(String nombre, int id) {
        if (cantidadEstudiantes >= MAX_ESTUDIANTES) return false;
        // Evitar duplicados
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (idEstudiantes[i] == id) return false;
        }
        nombreEstudiantes[cantidadEstudiantes] = nombre;
        idEstudiantes[cantidadEstudiantes] = id;
        for (int j = 0; j < SEMANAS; j++) {
            matriz[cantidadEstudiantes][j] = "-";
        }
        cantidadEstudiantes++;
        return true;
    }

    public boolean eliminarEstudiante(int id) {
        int pos = buscarEstudiante(id);
        if (pos == -1) return false;

        for (int i = pos; i < cantidadEstudiantes - 1; i++) {
            nombreEstudiantes[i] = nombreEstudiantes[i + 1];
            idEstudiantes[i] = idEstudiantes[i + 1];
            for (int j = 0; j < SEMANAS; j++) {
                matriz[i][j] = matriz[i + 1][j];
            }
        }
        cantidadEstudiantes--;
        return true;
    }

    public int buscarEstudiante(int id) {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (idEstudiantes[i] == id) return i;
        }
        return -1;
    }
}
