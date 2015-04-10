package beans;

/**
 *
 * @author EAlvarez
 */
public class Asignatura {
    int idAsigntaura;
    String nombre;
    int estado;
    int creditos;
    int horas_teoricas;
    int horas_practicas;
    int horas_independientes;
    String tipo;

    public int getIdAsigntaura() {
        return idAsigntaura;
    }

    public void setIdAsigntaura(int idAsigntaura) {
        this.idAsigntaura = idAsigntaura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras_teoricas() {
        return horas_teoricas;
    }

    public void setHoras_teoricas(int horas_teoricas) {
        this.horas_teoricas = horas_teoricas;
    }

    public int getHoras_practicas() {
        return horas_practicas;
    }

    public void setHoras_practicas(int horas_practicas) {
        this.horas_practicas = horas_practicas;
    }

    public int getHoras_independientes() {
        return horas_independientes;
    }

    public void setHoras_independientes(int horas_independientes) {
        this.horas_independientes = horas_independientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "idAsigntaura=" + idAsigntaura + ", nombre=" + nombre + ", estado=" + estado + ", creditos=" + creditos + ", horas_teoricas=" + horas_teoricas + ", horas_practicas=" + horas_practicas + ", horas_independientes=" + horas_independientes + ", tipo=" + tipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idAsigntaura;
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
        final Asignatura other = (Asignatura) obj;
        if (this.idAsigntaura != other.idAsigntaura) {
            return false;
        }
        return true;
    }
    
    
}
