package co.s4n.snakes.commands.deletesnake;

import co.s4n.snakes.SnakeModule;
import co.s4n.snakes.commands.Command;
import co.s4n.snakes.commands.CommandSerializer;
import co.s4n.snakes.domain.Snake;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

/**
 * Created by daniel-rua on 16/12/16.
 */
public class DeleteSnakeSerializer implements CommandSerializer {

    private Injector injector = Guice.createInjector(new SnakeModule());
    private ObjectMapper mapper = new ObjectMapper();

    public DeleteSnakeSerializer() {
        mapper.registerModule(new JodaModule());
    }

    @Override
    public Command deserialize(String json) throws IOException {
        Snake snake = mapper.readValue(json, Snake.class);
        DeleteSnakeCommand snakeCommand = this.injector.getInstance(DeleteSnakeCommand.class);
        snakeCommand.setData(snake);
        return snakeCommand;
    }
}
