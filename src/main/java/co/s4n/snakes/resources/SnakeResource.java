package co.s4n.snakes.resources;

import co.s4n.snakes.SnakeModule;
import co.s4n.snakes.SnakeRepository;
import co.s4n.snakes.infrastructure.dao.SnakeRecord;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * Created by daniel-rua on 15/12/16.
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class SnakeResource {

    private Injector injector = Guice.createInjector(new SnakeModule());
    private SnakeRepository repository = injector.getInstance(SnakeRepository.class);
    Logger logger = LoggerFactory.getLogger(SnakeResource.class);

    @GET
    public void findAll(@Suspended final AsyncResponse asyncResponse){
        List<SnakeRecord> snakeRecords = repository.findAll();
        Response response;
        if (!snakeRecords.isEmpty()){
            response = Response.ok(snakeRecords).build();
        }else{
            response = Response.status(Response.Status.NO_CONTENT).build();
        }
        asyncResponse.resume(response);
        logger.debug("FindAll Async");
    }

    @GET
    @Path("/{id}")
    public void getSnake(@Suspended final AsyncResponse asyncResponse, @PathParam("id") int id){
        SnakeRecord snakeRecord = repository.findById(id);
        Response response;
        if (snakeRecord != null){
            response = Response.ok().entity(snakeRecord).build();
        }else{
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        asyncResponse.resume(response);
        logger.debug("getSnake Async");
    }

}
