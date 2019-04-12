package eetac;

import java.util.LinkedList;

public class PlayList {

    String idPlaylist;
    LinkedList<Titulo> listaTitulos;


    public PlayList (String idPlaylist){

        this.idPlaylist = idPlaylist;
        this.listaTitulos = new LinkedList<Titulo>();
    }

    public void addTitulo (Titulo t){

        this.listaTitulos.add(t);
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public LinkedList<Titulo> getListaTitulos() {
        return listaTitulos;
    }

    public void setListaTitulos(LinkedList<Titulo> listaTitulos) {
        this.listaTitulos = listaTitulos;
    }
}
