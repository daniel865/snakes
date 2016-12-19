package co.s4n.snakes.commands.deletesnake;

import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.s4n.snakes.SnakeRepository;
import co.s4n.snakes.commands.Command;
import co.s4n.snakes.domain.Snake;
import co.s4n.snakes.infrastructure.events.SnakeDeleted;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel-rua on 16/12/16.
 */
public class DeleteSnakeCommand implements Command<Snake> {

    @Inject
    private SnakeRepository repository;
    private Snake data;

    @Override
    public String name() {
        return "DeleteSnake";
    }

    @Override
    public Snake data() {
        return data;
    }

    @Override
    public void setData(Snake data) {
        this.data = data;
    }

    @Override
    public List<Event> execute() throws Exception {
        repository.remove(data);
        List<Event> events = new ArrayList<>();
        events.add(new SnakeDeleted());
        return events;
    }
}
