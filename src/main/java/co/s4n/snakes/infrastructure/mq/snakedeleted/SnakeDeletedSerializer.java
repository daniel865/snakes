package co.s4n.snakes.infrastructure.mq.snakedeleted;

import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.com.proteccion.advance.msbase.mq.api.EventSerializer;
import co.s4n.snakes.SnakeModule;
import co.s4n.snakes.infrastructure.events.SnakeDeleted;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

/**
 * Created by daniel-rua on 19/12/16.
 */
public class SnakeDeletedSerializer implements EventSerializer{

    private Injector injector = Guice.createInjector(new SnakeModule());
    private ObjectMapper mapper = new ObjectMapper();

    public SnakeDeletedSerializer() {
        mapper.registerModule(new JodaModule());
    }

    @Override
    public EventProcessor deserialize(String json) throws IOException {
        SnakeDeleted snakeDeleted = mapper.readValue(json, SnakeDeleted.class);
        SnakeDeletedListener listener = this.injector.getInstance(SnakeDeletedListener.class);
        listener.setData(snakeDeleted);
        return listener;
    }
}
