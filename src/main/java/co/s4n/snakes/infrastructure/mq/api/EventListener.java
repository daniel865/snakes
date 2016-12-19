package co.s4n.snakes.infrastructure.mq.api;

import co.com.proteccion.advance.infrastructure.mq.Publisher;
import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.com.proteccion.advance.msbase.CommonProperties;
import co.com.proteccion.advance.msbase.jackson.DateTimeModule;
import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.com.proteccion.advance.msbase.mq.api.EventSerializer;
import co.com.proteccion.advance.msbase.mq.api.EventToJson;
import co.s4n.snakes.SnakeModule;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by daniel-rua on 16/12/16.
 */
@MessageDriven
public class EventListener implements MessageListener {

    Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            logger.debug("Event Listener is called");
            String json = ((TextMessage) message).getText();
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new DateTimeModule());
            JsonNode root = mapper.readTree(json);
            JsonNode nameEvent = root.path("evento");
            logger.debug("Name of event received " + nameEvent.path("nombre").asText());
            EventSerializer serializer = EventSerializers.getInstance().get(nameEvent.path("nombre").asText());
            if (serializer != null){
                EventProcessor eventProcessor = serializer.deserialize(json);
                List<Event> events = eventProcessor.execute();
                publishEvents(events);
            }else{
                logger.debug("Event received without listener");
            }
        }catch (JMSException e){
            logger.error("JSMError getting events");
        }catch (IOException e){
            e.printStackTrace();
            logger.error("IOException getting events");
        }catch (Exception e){
            logger.error("Unknown error");
        }
    }

    private void publishEvents(List<Event> events){
        Publisher p = new Publisher("jms/PROTEC.RONNIE.PERSONA", CommonProperties.get("mq.user"), CommonProperties.get("mq.pass"));
        List<String> messages = events.stream().map(e -> EventToJson.transform(e)).collect(Collectors.toList());
        p.send(messages);
    }


}
