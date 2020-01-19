package edu.upc.dsa.services;

import edu.upc.dsa.exceptions.UserAlreadyConnectedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.User;
import edu.upc.dsa.mysql.IUserDAO;
import edu.upc.dsa.mysql.UserDAOImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import javax.ws.rs.core.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Api(value="/login", description = "Operaciones relativas a la gestion de usuarios")
@Path("/auth")
public class LoginService {
    final static Logger log = Logger.getLogger(funciones.class.getName());

    private IUserDAO tm;

    public LoginService() {
        this.tm = UserDAOImpl.getInstance();
    }

    @POST
    @ApiOperation(value= "inicia sesion" , notes= "Introduce nickname y password")
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Successful", response = Jugador.class, responseContainer = "Jugador"),
            @ApiResponse(code = 404, message = "exc Error"),
            @ApiResponse(code = 418, message = "Ya está conectado")
    })
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signIn(User user) {
        String username = user.getNickname();
        String password = user.getPassword();

        try {
            Jugador jugador = this.tm.loginUser(username, password);
            return Response.status(201).entity(jugador).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        } catch (UserAlreadyConnectedException e) {
            e.printStackTrace();
            return Response.status(418).build();
        }
    }

    @POST
    @ApiOperation(value = "add new User", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = void.class, responseContainer = "Void class"),
            @ApiResponse(code = 402, message = "Usuario ya existe")
    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        String username = user.getNickname();
        String name = user.getName();
        String password = user.getPassword();
        this.tm.addUser(username, name, password);
        return Response.status(201).entity(user).build();
    }

}

