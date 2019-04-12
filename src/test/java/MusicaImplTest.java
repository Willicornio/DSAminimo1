import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import eetac.*;


public class MusicaImplTest {

    final static Logger log = Logger.getLogger(MusicaImplTest.class.getName());
    Musica ms;

    @Before

    public void setUp(){
        ms = MusicaImpl.getInstance();
        this.ms = new MusicaImpl();
        log.info("Empieza el test");
    }


    @After
    public void setDown(){
        ms = null;
    }


    @Test
    public void testAddUsuario(){
        this.ms.addUsuario("15", "Willi");
        Assert.assertEquals(1, this.ms.dameListaUsuario());

    }

    @Test
    public void testAddArtista(){
        this.ms.addArtista("Lepoka");
        Assert.assertEquals(1, this.ms.dameListaArtitas());

    }

    @Test
    public void testAddTitulo() throws ArtistaNotFound{
        this.ms.addArtista("Lepoka");
        this.ms.addTitulo("titulo1", "Suma", "Lepoka", "bi" , 50);

        Assert.assertEquals(1, this.ms.dameListaTitulos());
    }



    @Test
    public void testAddPlay() throws ArtistaNotFound, UsuarioNotFound{
        this.ms.addUsuario("15", "Willi");
        this.ms.addArtista("Lepoka");
        this.ms.addTitulo("titulo1", "Suma", "Lepoka", "bi" , 50);
        this.ms.crearPlaylistUsuario("15" ,"hola");

        Assert.assertEquals(1, this.ms.dameListaPlay());
    }
    @Test
    public void testAddTituloUsuarioPlaylist() throws ArtistaNotFound, UsuarioNotFound, PlayListNotFound{

        Titulo t = new Titulo("titulo2", "titulo2", "Lepoka", "album", 50);

        this.ms.addUsuario("15", "Willi");
        this.ms.addArtista("Lepoka");
        this.ms.addTitulo("titulo1", "Suma", "Lepoka", "bi" , 50);
        this.ms.crearPlaylistUsuario("15" ,"play1");
        this.ms.añadirTituloPlayUsuario("15", "play1", t);


        Assert.assertEquals(1, this.ms.dameListaTitulosEnPlaylist("play1"));
    }

@Test
    public void testdameArtistasEnLaPlataforma(){
    this.ms.addArtista("Lepoka");
    this.ms.addArtista("Lepoka2");
    ArrayList<Artista> artistas;
     artistas = this.ms.dameArtistasEnLaPlataforma();
     Assert.assertEquals(2, artistas.size());



}

@Test
    public void testdameListaDeUnaPlayListUsuario() throws UsuarioNotFound, PlayListNotFound, ArtistaNotFound{

    Titulo t = new Titulo("titulo2", "titulo2", "Lepoka", "album", 50);

    this.ms.addUsuario("15", "Willi");
    this.ms.addArtista("Lepoka");
    this.ms.addTitulo("titulo1", "Suma", "Lepoka", "bi" , 50);
    this.ms.crearPlaylistUsuario("15" ,"play1");
    this.ms.añadirTituloPlayUsuario("15", "play1", t);
    LinkedList<Titulo> titulos;
    titulos = this.ms.dameListaDeUnaPlayListUsuario("15","play1");

    Assert.assertEquals(1, titulos.size());
    Assert.assertEquals(50, this.ms.dameListaDeUnaPlayListUsuario("15", "play1").get(0).getDuracion(), 1);
    Assert.assertEquals("titulo2", this.ms.dameListaDeUnaPlayListUsuario("15", "play1").get(0).getNombre());






}

@Test(expected = UsuarioNotFound.class)
    public void testUsuarioNotFound () throws UsuarioNotFound{
        this.ms.crearPlaylistUsuario("manolo", "lopoka3");


}

    @Test(expected = PlayListNotFound.class)
    public void    testPlayNotFound () throws PlayListNotFound, ArtistaNotFound, UsuarioNotFound{

        Titulo t = new Titulo("titulo2", "titulo2", "Lepoka", "album", 50);

        this.ms.addUsuario("15", "Willi");
        this.ms.addArtista("Lepoka");
        this.ms.addTitulo("titulo1", "Suma", "Lepoka", "bi" , 50);
        this.ms.crearPlaylistUsuario("15" ,"play1");
        this.ms.añadirTituloPlayUsuario("15", "play2", t);


    }

}
