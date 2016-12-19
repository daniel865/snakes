package co.s4n.snakes.infrastructure.mq.snakedeleted;

import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.com.proteccion.advance.msbase.mq.api.EventProcessor;
import co.s4n.snakes.infrastructure.events.SnakeDeleted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel-rua on 19/12/16.
 */
public class SnakeDeletedListener implements EventProcessor<SnakeDeleted> {

    final static Logger logger = LoggerFactory.getLogger(SnakeDeletedListener.class);

    private SnakeDeleted snakeDeleted;

    @Override
    public String name() {
        return "SnakeDeleted";
    }

    @Override
    public SnakeDeleted data() {
        return snakeDeleted;
    }

    @Override
    public void setData(SnakeDeleted snakeDeleted) {
        this.snakeDeleted = snakeDeleted;
    }

    @Override
    public List<Event> execute() {
        logger.debug("exec method from SnakeDeletedListener");
        return Arrays.asList();
    }
}
