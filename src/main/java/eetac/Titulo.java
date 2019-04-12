package eetac;

public class Titulo {

    String idTitulo;
    String Artista;
    String Album;
    double Duracion;
    String Nombre;

    public Titulo (String idTitulo,String Nombre, String Artista, String Album, double Duracion){
        this.idTitulo = idTitulo;
        this.Nombre =  Nombre;
        this.Artista = Artista;
        this.Album = Album;
        this.Duracion = Duracion;

    }




    public String getArtista() {
        return Artista;
    }

    public void setArtista(String artista) {
        Artista = artista;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public double getDuracion() {
        return Duracion;
    }

    public void setDuracion(double duracion) {
        Duracion = duracion;
    }

    public String getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(String idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
