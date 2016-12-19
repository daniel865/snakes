package co.s4n.snakes.infrastructure.mq.api;

import co.com.proteccion.advance.msbase.mq.api.EventSerializer;
import co.s4n.snakes.infrastructure.mq.snakedeleted.SnakeDeletedSerializer;
import co.s4n.snakes.infrastructure.mq.snakeupdated.SnakeUpdatedSerializer;
import co.s4n.snakes.infrastructure.mq.snakecreated.SnakeCreatedSerializer;

import java.util.HashMap;

/**
 * Created by daniel-rua on 16/12/16.
 */
public class EventSerializers {

    private final HashMap<String, EventSerializer> listeners = new HashMap<>();
    private final static EventSerializers instance = new EventSerializers();

    public EventSerializers() {
        listeners.put("SnakeCreated", new SnakeCreatedSerializer());
        listeners.put("SnakeUpdated", new SnakeUpdatedSerializer());
        listeners.put("SnakeDeleted", new SnakeDeletedSerializer());
    }

    public static EventSerializers getInstance(){
        return instance;
    }

    public EventSerializer get(String eventName){
        return listeners.get(eventName);
    }

}
