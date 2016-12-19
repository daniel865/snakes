package co.s4n.snakes.commands.createsnake;

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
 * Created by daniel-rua on 15/12/16.
 */
public class CreateSnakeSerializer implements CommandSerializer {

    private Injector injector = Guice.createInjector(new SnakeModule());
    private ObjectMapper mapper = new ObjectMapper();

    public CreateSnakeSerializer() {
        mapper.registerModule(new JodaModule());
    }

    @Override
    public Command deserialize(String json) throws IOException {
        Snake snake = mapper.readValue(json, Snake.class);
        CreateSnakeCommand snakeCommand = this.injector.getInstance(CreateSnakeCommand.class);
        snakeCommand.setData(snake);
        return snakeCommand;
    }



}
