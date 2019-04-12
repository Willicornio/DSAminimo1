package eetac;

import java.util.LinkedList;
import java.util.List;


public class Artista {
    String nombre;
    LinkedList<Titulo> listaTitulos;

    public  Artista (String nombre) {
        this.nombre = nombre;
        this.listaTitulos = new LinkedList<Titulo>();

        }

        public void addTitulo (Titulo t){

        this.listaTitulos.add(t);
        }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public LinkedList<Titulo> getListaTitulos() {
        return listaTitulos;
    }

    public void setListaTitulos(LinkedList<Titulo> listaTitulos) {
        this.listaTitulos = listaTitulos;
    }
}


