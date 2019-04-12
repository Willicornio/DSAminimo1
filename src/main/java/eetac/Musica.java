package eetac;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Musica {

    public void crearPlaylistUsuario (String idUsuario, String idPlayList) throws  UsuarioNotFound;
    public void addUsuario (String idUsuario, String nombre);
    public void añadirTituloPlayUsuario(String idUsuario,String idplayList, Titulo t) throws UsuarioNotFound, PlayListNotFound;
    public LinkedList<Titulo> dameListaDeUnaPlayListUsuario (String idUser, String idPlay) throws UsuarioNotFound;
    public ArrayList<Artista> dameArtistasEnLaPlataforma();
    public void addArtista (String nombre);

    public void addTitulo (String idTitulo, String Nombre, String Artista, String Album, double Duracion) throws ArtistaNotFound;





    public int dameListaUsuario();
    public int dameListaArtitas();
    public int dameListaTitulos();
    public int dameListaPlay();
    public int dameListaTitulosEnPlaylist (String idPlaylist);

}
