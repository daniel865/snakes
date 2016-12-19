package co.s4n.snakes.infrastructure.mq.snakeupdated;

import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.com.proteccion.advance.msbase.mq.api.EventSerializer;
import co.s4n.snakes.SnakeModule;
import co.s4n.snakes.infrastructure.events.SnakeUpdated;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

/**
 * Created by daniel-rua on 19/12/16.
 */
public class SnakeUpdatedSerializer implements EventSerializer {

    private Injector injector = Guice.createInjector(new SnakeModule());
    private ObjectMapper mapper = new ObjectMapper();

    public SnakeUpdatedSerializer() {
        mapper.registerModule(new JodaModule());
    }

    @Override
    public EventProcessor deserialize(String json) throws IOException {
        SnakeUpdated snakeUpdated = mapper.readValue(json, SnakeUpdated.class);
        SnakeUpdatedListener listener = this.injector.getInstance(SnakeUpdatedListener.class);
        listener.setData(snakeUpdated);
        return listener;
    }
}
