package beans;

import java.util.List;

/**
 *
 * @author EAlvarez
 */
public class Proyeccion {

    int idProyeccion;
    Asignatura asigntura;
    Estudiante estudiante;
    int estado;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idProyeccion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proyeccion other = (Proyeccion) obj;
        if (this.idProyeccion != other.idProyeccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proyeccion{" + "idProyeccion=" + idProyeccion + ", asigntura=" + asigntura + ", estudiante=" + estudiante + ", estado=" + estado + '}';
    }

    public Asignatura getAsigntura() {
        return asigntura;
    }

    public void setAsigntura(Asignatura asigntura) {
        this.asigntura = asigntura;
    }

    public int getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
