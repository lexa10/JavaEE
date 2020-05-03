import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductWSService {

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepository product);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepository product);

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") long id);

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepository findById(@PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepository> findAll();
}


