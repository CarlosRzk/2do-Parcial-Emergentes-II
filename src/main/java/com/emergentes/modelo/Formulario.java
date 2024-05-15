package com.emergentes.modelo;

public class Formulario {
    private int id;
    private String nombres;
    private String apellidos;
    private String seminario;
    private int confirmados;
    private String fechainscripcion;
    
    public Formulario() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.seminario = "";
        this.confirmados = 0;
        this.fechainscripcion = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public int getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(int confirmados) {
        this.confirmados = confirmados;
    }

    public String getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(String fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }


    @Override
    public String toString(){
        return "Formulario(" + "id=" + id + ", Nombres=" + nombres + ", Apellidos=" + apellidos + ", Seminario =" + seminario + ", Confirmados" + confirmados + ", Fechainscripcion" + fechainscripcion + ")";
    }
    
}
