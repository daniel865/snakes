package co.s4n.snakes;

import co.com.proteccion.advance.infrastructure.mq.Publisher;
import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.com.proteccion.advance.msbase.mq.api.EventToJson;
import co.s4n.snakes.commands.Command;
import co.s4n.snakes.commands.CommandSerializer;
import co.s4n.snakes.commands.CommandSerializers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by daniel-rua on 15/12/16.
 */

@Path("/commands")
public class CommandProcessor {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response receiveCommand(String json){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        Response response = null;
        try {
            JsonNode root = mapper.readTree(json);
            JsonNode jCommand = root.path("commando");
            CommandSerializer commandSerializer = CommandSerializers.getInstance().get(jCommand.asText());
            Command command = commandSerializer.deserialize(json);
            List<Event> eventList = command.execute();
            publishEvents(eventList);
            LoggerFactory.getLogger(CommandProcessor.class).debug("Generate events: " + eventList);
            response = Response.ok(Response.Status.ACCEPTED).build();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private void publishEvents(List<Event> events){
        if (events != null && !events.isEmpty()){
            events.stream().forEach(e -> System.out.println("Mensaje publicado en: {" + EventToJson.transform(e) + "}"));
            Publisher publisher = new Publisher("jms/PROTEC.RONNIE.PERSONA", "dev", "dev");
            List<String> messages = events.stream().map(e -> EventToJson.transform(e)).collect(Collectors.toList());
            publisher.send(messages);
        }
    }

}
