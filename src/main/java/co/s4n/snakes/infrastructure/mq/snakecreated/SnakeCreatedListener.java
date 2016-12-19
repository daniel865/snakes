package co.s4n.snakes.infrastructure.mq.snakecreated;

import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.s4n.snakes.infrastructure.events.SnakeCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel-rua on 16/12/16.
 */
public class SnakeCreatedListener implements EventProcessor<SnakeCreated> {

    final static Logger logger = LoggerFactory.getLogger(SnakeCreatedListener.class);

    private SnakeCreated snakeCreated;

    @Override
    public String name() {
        return "SnakeCreated";
    }

    @Override
    public SnakeCreated data() {
        return snakeCreated;
    }

    @Override
    public void setData(SnakeCreated snakeCreated) {
        this.snakeCreated = snakeCreated;
    }

    @Override
    public List<Event> execute() {
        logger.debug("exec method from SnakeCreatedListener");
        return Arrays.asList();
    }
}
