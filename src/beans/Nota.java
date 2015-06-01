/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author EAlvarez
 */
public class Nota {
    int idNota;
    double primer_corte;
    double segundo_corte;
    double tercer_corte;
    Proyeccion proyeccion;
    double definitiva;

      
    
    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public double getPrimer_corte() {
        return primer_corte;
    }

    public void setPrimer_corte(double primer_corte) {
        this.primer_corte = primer_corte;
    }

    public double getSegundo_corte() {
        return segundo_corte;
    }

    public void setSegundo_corte(double segundo_corte) {
        this.segundo_corte = segundo_corte;
    }

    public double getTercer_corte() {
        return tercer_corte;
    }

    public void setTercer_corte(double tercer_corte) {
        this.tercer_corte = tercer_corte;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public double getDefinitiva() {
        return definitiva;
    }

    public void setDefinitiva(double definitiva) {
        this.definitiva = definitiva;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", primer_corte=" + primer_corte + ", segundo_corte=" + segundo_corte + ", tercer_corte=" + tercer_corte + ", proyeccion=" + proyeccion + ", definitiva=" + definitiva + '}';
    }
    
    
}
