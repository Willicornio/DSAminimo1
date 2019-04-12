package services;
import eetac.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Api(value = "/Musica", description = "Endpoint to musica Service")

@Path("/musica")



public class MusicaService {

    final static Logger log = Logger.getLogger(MusicaService.class.getName());
    private Musica ms;

    public MusicaService() {

        this.ms = MusicaImpl.getInstance();

    }


    @POST

    @ApiOperation(value = "Añadir artista", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "exito"),

    })
    @Path("/{addArtista}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addArtista (@PathParam("nombre") String nombre) {

        this.ms.addArtista(nombre);
        return Response.status(201).build();
    }



    @GET
    @ApiOperation(value = "Lista artista en la plataforma")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "exito", response = Artista.class, responseContainer = "Lista de artistas"),

    })
    @Path("/{artiasplataforma}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response artitasPlataforma() {
        ArrayList<Artista> listaartistas = new ArrayList<>();

            listaartistas = this.ms.dameArtistasEnLaPlataforma();
            GenericEntity<List<Artista>> entity = new GenericEntity<List<Artista>>(listaartistas){};
            return Response.status(201).entity(entity).build();




        }

        @POST
        @ApiOperation(value = "Crear play en un usuario")
        @ApiResponses(value= {
                @ApiResponse(code = 201, message = "exito"),
                @ApiResponse(code = 404, message ="Usuario no existe")

        })
        @Path("/{crearplayusuario}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response crearPlaylistUsuario(@PathParam("idUsario") String idUsario, @PathParam("idPlay") String idPlay) {

        try {

              this.ms.crearPlaylistUsuario(idUsario, idPlay);
              return Response.status(201).build();

        }catch (UsuarioNotFound e){
        e.printStackTrace();
        return Response.status(404).build();
        }
        }

    @POST
    @ApiOperation(value = "añadir titulo play list usuario")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "exito"),
            @ApiResponse(code = 404, message ="Usuario no existe"),
            @ApiResponse(code = 405, message ="PlayList no existe")

    })
    @Path("/{ponertituloenplaylistusuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ponerTituloPlayListUsuario(@PathParam("idUsario") String idUsario, @PathParam("idPlay") String idPlay, Titulo t) {

        try {

            this.ms.añadirTituloPlayUsuario(idPlay, idPlay, t);
            return Response.status(201).build();

        }catch (UsuarioNotFound e){
            e.printStackTrace();
            return Response.status(404).build();
        }catch (PlayListNotFound e){
            e.printStackTrace();
            return Response.status(405).build();
        }
    }


    @GET
    @ApiOperation(value = "Lista de titulos de una playlist de un usuario")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "exito", response = Titulo.class, responseContainer = "Lista de titulos"),
            @ApiResponse(code = 404, message = "usuario no encontrado"),
            @ApiResponse(code = 405, message = "Playlist no encontrada")


    })
    @Path("/{artiasplataforma}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response titulosEnUnaPlayUsuario(@PathParam("idUsario") String idUsario, @PathParam("idPlay") String idPlay){

        LinkedList<Titulo> listatitulos = new LinkedList<>();
        try {

            listatitulos = this.ms.dameListaDeUnaPlayListUsuario(idUsario,idPlay);
            GenericEntity<List<Titulo>> entity = new GenericEntity<List<Titulo>>(listatitulos) {
            };
            return Response.status(201).entity(entity).build();
        }catch (UsuarioNotFound e){
        e.printStackTrace();
        return Response.status(404).build();
    }catch (PlayListNotFound e){
        e.printStackTrace();
        return Response.status(405).build();
    }
}



}



