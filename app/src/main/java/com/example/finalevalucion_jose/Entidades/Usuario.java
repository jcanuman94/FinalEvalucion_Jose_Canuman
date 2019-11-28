package com.example.finalevalucion_jose.Entidades;



public class Usuario {
    private Integer Id;
    private String Nombre;
    private String Numero;

    public Usuario(Integer Id,String Nombre,String Numero){
        this.Id=Id;
        this.Nombre=Nombre;
        this.Numero=Numero;
    }

    public Usuario() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }
}
