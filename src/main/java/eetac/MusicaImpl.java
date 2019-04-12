package eetac;
import org.apache.log4j.Logger;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;


public class MusicaImpl implements Musica {

    final static Logger log = Logger.getLogger(MusicaImpl.class.getName());
    public static Musica ms;

    private HashMap<String, Usuario> usuarios;
    private ArrayList<Artista> artistas;
    private LinkedList<Titulo> titulos;
    private LinkedList<PlayList> playLists;


    public MusicaImpl(){

        usuarios = new HashMap<String, Usuario>();
        artistas = new ArrayList<Artista>();
        titulos = new LinkedList<Titulo>();
        playLists = new LinkedList<PlayList>();

    }

    public static Musica getInstance() {

        if (ms == null) ms = new MusicaImpl();

        return ms;

    }

    public void addUsuario (String idUsuario, String nombre){

     log.info("Añadiendo usuario");
     this.usuarios.put(idUsuario, new Usuario(idUsuario,nombre));
     log.info("Añadido el usuario " + nombre);

    }

    public void addArtista (String nombre){
        log.info("Añadiendo artista");

        Artista artista = new Artista(nombre);
        artistas.add(artista);
        log.info("Añadido el artista " + nombre);

    }


    public void addTitulo (String idTitulo, String Nombre, String Artista, String Album, double Duracion) throws ArtistaNotFound{

        log.info("Añadiendo titulo");
        Artista artista;
        int i;
        boolean artistaencontrado = false;


        for (i=0; i < this.artistas.size(); i++){
            if (Artista.equals(this.artistas.get(i).getNombre())) {

                artista = this.artistas.get(i);
                Titulo titulo = new Titulo(idTitulo, Nombre, Artista, Album, Duracion);
                artista.addTitulo(titulo);
                titulos.add(titulo);
                artistaencontrado = true;

            }

                }

        if (artistaencontrado = true){
            log.info("Añadido titulo" + Nombre);
        }
        if (artistaencontrado = false) {
            log.error("No existe el artista");
            throw new ArtistaNotFound();
        }


            }




    public void crearPlaylistUsuario (String idUsuario, String idPlaylist) throws  UsuarioNotFound{
        log.info("Añadir playlist");
        Usuario usuario;
        usuario = usuarios.get(idUsuario);

        if (usuario != null){
            PlayList p = new PlayList(idPlaylist);
            usuario.addPlayList(p);
            playLists.add(p);


        }
        else {
            log.error("no se encuentra el usuario");
            throw  new UsuarioNotFound();
        }
    }







    public void añadirTituloPlayUsuario(String idUsuario,String idplayList, Titulo t) throws UsuarioNotFound, PlayListNotFound {

        Usuario usuario;

        usuario = usuarios.get(idUsuario);

        if (usuario != null) {
            LinkedList<PlayList> lista = new LinkedList<PlayList>();
           lista = usuario.getPlayLists();
            int i =0;
            for (i=0; i < lista.size(); i++){
                PlayList playList;
                playList=usuario.getPlayLists().get(i);
                if (idplayList.equals(playList.getIdPlaylist())) {


                    playList.addTitulo(t);
                }

                else {
                    throw new PlayListNotFound();
                }

            }

        }
        else {
            throw new UsuarioNotFound();
        }


    }






    public LinkedList<Titulo> dameListaDeUnaPlayListUsuario (String idUser, String idPlay) throws UsuarioNotFound, PlayListNotFound {
        log.info("Titulos de una plalist de un usuario");
        Usuario u;
        u = usuarios.get(idUser);
        LinkedList<Titulo> listaTitulo = new LinkedList<Titulo>();
        LinkedList<PlayList> lista = new LinkedList<PlayList>();
        boolean ExistePlay =false ;

        if (u != null) {

            lista = u.getPlayLists();
            int i = 0;
            PlayList p;
            for (i = 0; i < lista.size(); i++) {
                p = u.getPlayLists().get(i);
                if (idPlay.equals(p.getIdPlaylist())){

               listaTitulo = p.getListaTitulos();
               ExistePlay = true;

                }

            }
            if (ExistePlay = true) {

                return listaTitulo;
            }
            else {
                log.error("Playlist no encontrada");
                throw new PlayListNotFound();
            }
            }
        else {
            log.error("Usuario no encontrado");
            throw new UsuarioNotFound();

        }
        }

    public ArrayList<Artista> dameArtistasEnLaPlataforma(){

        ArrayList<Artista> listaArtistas;
        listaArtistas = new ArrayList<Artista>(this.artistas);
        return listaArtistas;
    }

    public int dameListaUsuario(){
        return this.usuarios.size();
    }

    public int dameListaArtitas() {
        return this.artistas.size();
    }
    public int dameListaTitulos(){

        return this.titulos.size();
    }

    public int dameListaPlay(){

        return this.playLists.size();
    }


    public int dameListaTitulosEnPlaylist (String idPlaylist){

        int i;
        int resulta =0;

        for (i = 0; i < this.playLists.size(); i++) {

            PlayList p = this.playLists.get(i);

            if (idPlaylist.equals(p.getIdPlaylist())) {


                resulta = p.getListaTitulos().size();
            }
            }

        return resulta;
        }

    }


