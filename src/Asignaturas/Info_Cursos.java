/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asignaturas;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Info_Cursos {
    

    String nombreCurso;
    String codigoCurso;
    int creditosCurso;
    
    Info_Cursos lista_cursos[] = new Info_Cursos[20];
    int contador = 0;

    public Info_Cursos(String nombreCurso, String codigoCurso, int creditosCurso) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.creditosCurso = creditosCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCreditosCurso() {
        return creditosCurso;
    }

    public void setCreditosCurso(int creditosCurso) {
        this.creditosCurso = creditosCurso;
    }

    @Override
    public String toString() {
        return "Nombre del curso: " + nombreCurso + "\n" +
                "Codigo del curso: " + codigoCurso + "\n" +
                "Creditos del curso: " + creditosCurso;
    }
    
public void crearCurso() {
    if (contador < lista_cursos.length) {
        nombreCurso = JOptionPane.showInputDialog("Digite el nombre del curso: ");
        codigoCurso = JOptionPane.showInputDialog("Digite el codigo del curso: ");
        creditosCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de creditos para este curso: "));
        
        lista_cursos[contador++] = new Info_Cursos(nombreCurso, codigoCurso,creditosCurso);
    } else {
        JOptionPane.showMessageDialog(null, "Limite de cursos excedido.");
    }
    
}

public void modificarCurso() {
    String codigoBusqueda = JOptionPane.showInputDialog("Digite el codigo del curso a modificar: ");
    Info_Cursos cursoAModificar = null;
    
    for (int i = 0; i < contador; i++) {
        if (lista_cursos[i].getCodigoCurso() == codigoBusqueda) {
            cursoAModificar = lista_cursos[i];
            break;
        }
        
    }
    
    if (cursoAModificar != null) {
        nombreCurso = JOptionPane.showInputDialog("Digite el nombre del curso a modificar: ");
        codigoCurso = JOptionPane.showInputDialog("Digite el codigo del curso a modificar: ");
        creditosCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite el nombre del curso a modificar: "));
        
        JOptionPane.showMessageDialog(null, "Curso actualizado: " + lista_cursos.toString());
    } else  {
        JOptionPane.showMessageDialog(null, "No se encuentran cursos registrados.");
    }
    
    
}

public void eliminarCurso() {
    int indice = -1;
    String codigoBusqueda = JOptionPane.showInputDialog("Digite el codigo del curso a eliminar: ");
    
    for (int i = 0; i < contador; i++) {
        if (lista_cursos[i].getCodigoCurso() == codigoBusqueda) {
            indice = i;
            break;
        }
        
    }
    
    if (indice == -1) {
        JOptionPane.showMessageDialog(null, "No se encuentran cursos registrados.");
        return;
    }
    
    for (int i = 0; i < contador - 1; i++) {
        lista_cursos[i] = lista_cursos[i + 1];
    }
    
    lista_cursos[contador - 1] = null;
    
    contador--;  
}

public void buscarCurso() {
    Info_Cursos encontrado = null;
    String codigoBusqueda = JOptionPane.showInputDialog("Digite el codigo del curso a buscar: ");
    
    for (int i = 0; i < contador; i++) {
        lista_cursos[i] = encontrado;
        break;
    }
    
    if (encontrado != null) {
        JOptionPane.showMessageDialog(null, "Curso encontrado: " + lista_cursos.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No se encuentran cursos registrados.");
    }
        
}
  
}
