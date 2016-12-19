package co.s4n.snakes.infrastructure.mq.snakeupdated;

import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.s4n.snakes.infrastructure.events.SnakeUpdated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel-rua on 19/12/16.
 */
public class SnakeUpdatedListener implements EventProcessor<SnakeUpdated> {

    final static Logger logger = LoggerFactory.getLogger(SnakeUpdated.class);

    private SnakeUpdated snakeUpdated;

    @Override
    public String name() {
        return "SnakeUpdated";
    }

    @Override
    public SnakeUpdated data() {
        return snakeUpdated;
    }

    @Override
    public void setData(SnakeUpdated snakeUpdated) {
        this.snakeUpdated = snakeUpdated;
    }

    @Override
    public List<Event> execute() {
        logger.debug("exec method from SnakeUpdatedListener");
        return Arrays.asList();
    }
}
