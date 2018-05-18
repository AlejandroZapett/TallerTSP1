package me.alejnadrozapett.ejercicio1;

/**
 * Created by AlejnadroZapett on 03/05/18.
 */

public class RegistroAlumno {
    private String nombre;
    private String apellidos;
    private long numCuenta;
    private String correo;
    private String genero;
    private String facultad;

    public RegistroAlumno(String nombre, String apellidos, long numCuenta, String correo, String genero, String facultad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numCuenta = numCuenta;
        this.correo = correo;
        this.genero = genero;
        this.facultad = facultad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public String getGenero() {
        return genero;
    }

    public String getFacultad() {
        return facultad;
    }

    @Override
    public String toString() {
        return "Alumno guardado. Nombre: "+ getNombre()+" "+getApellidos()+" NC:"+getNumCuenta()+" g:"+getGenero()+" f:"+getFacultad();
    }
}
