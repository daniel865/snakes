package co.s4n.snakes.infrastructure.mq.snakecreated;

import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.com.proteccion.advance.msbase.mq.api.EventSerializer;
import co.s4n.snakes.SnakeModule;
import co.s4n.snakes.infrastructure.events.SnakeCreated;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

/**
 * Created by daniel-rua on 16/12/16.
 */
public class SnakeCreatedSerializer implements EventSerializer{

    private Injector injector = Guice.createInjector(new SnakeModule());
    private ObjectMapper mapper = new ObjectMapper();

    public SnakeCreatedSerializer() {
        mapper.registerModule(new JodaModule());
    }

    @Override
    public EventProcessor deserialize(String json) throws IOException {
        SnakeCreated snakeCreated = mapper.readValue(json, SnakeCreated.class);
        SnakeCreatedListener listener = this.injector.getInstance(SnakeCreatedListener.class);
        listener.setData(snakeCreated);
        return listener;
    }
}
