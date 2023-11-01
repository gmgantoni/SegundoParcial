
package com.emergentes.clase;


public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String disponible;
    private String categoria;

    public Libro() {
        this.id = 0;
        this.titulo = "";
        this.autor = "";
        this.disponible = "";
        this.categoria = "";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
