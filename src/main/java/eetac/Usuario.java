package eetac;

import java.util.LinkedList;

public class Usuario {
    String idUsuario;
    LinkedList<PlayList> ListaplayLists;
    String Nombre;


    public Usuario(String idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.ListaplayLists = new LinkedList<PlayList>();
        this.Nombre = nombre;
    }

    public void addPlayList (PlayList p){
        this.ListaplayLists.add(p);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LinkedList<PlayList> getPlayLists() {

        return this.ListaplayLists;
    }

    public int tamaño (){
        return ListaplayLists.size();
    }


    public void setPlayLists(LinkedList<PlayList> playLists) {
        this.ListaplayLists = playLists;
    }
}
