package edu.upc.dsa.services;
import edu.upc.dsa.models.User;
import edu.upc.dsa.mysql.IUserDAO;
import edu.upc.dsa.mysql.UserDAOImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@Api(value = "/users", description = "Endpoint to Product edu.upc.dsa.services.Service")
@Path("/users")
public class funciones {
    final static Logger log = Logger.getLogger(funciones.class.getName());

    private IUserDAO tm;

    public funciones() {
        this.tm = UserDAOImpl.getInstance();

        if (tm.size()==0) {
            this.tm.addUser("55555", "Eric", "Jimenez");
            this.tm.addUser("11111", "Juan", "Lopez");
            Objects o=new Objects("Espada", "Grande",1);
            Objects p=new Objects("Pocion", "Curativa", 1);
            this.tm.addObject("55555", o);
            this.tm.addObject("11111", p);
        }
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "Users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> list = this.tm.userlistordered();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(list) {};
        return Response.status(201).entity(entity).build() ;

    }
    @GET
    @ApiOperation(value = "get objects from a user", notes = "Objects of the user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objects.class, responseContainer="List"),
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjects(@PathParam("id") String id) {

        List<Objects> objects = this.tm.objectsofuser(id);

        GenericEntity<List<Objects>> entity = new GenericEntity<List<Objects>>(objects) {};
        return Response.status(201).entity(entity).build() ;

    }

    @GET
    @ApiOperation(value = "get a user", notes = "Obtain an user with his/her id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getuser(@PathParam("id") String iduser) {
        User u = this.tm.getinfouser(iduser);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
    }

    @PUT
    @ApiOperation(value = "update a user", notes = "Something")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response =  User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/user/{iduser}/{name}/{surname}")
    public Response modifyuser(@PathParam("iduser") String iduser, @PathParam("name") String name, @PathParam("surname") String surname ) {

        this.tm.modifyuser(iduser, name, surname);
        User t = this.tm.getinfouser(iduser);
        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a user", notes = "New User")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {

        if (user.getNameuser()==null || user.getIduser() == null)  return Response.status(500).entity(user).build();
        this.tm.addUser(user.iduser,user.name, user.surname);
        return Response.status(201).entity(user).build();
    }
    @POST
    @ApiOperation(value = "create a new Object", notes = "New Object")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addObject(@PathParam("id")String id, Objects object) {

        User user=this.tm.getinfouser(id);
        user.addObject(object);
        return Response.status(201).entity(user).build();
    }

}
