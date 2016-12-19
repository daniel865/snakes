package co.s4n.snakes.commands;

import co.s4n.snakes.commands.createsnake.CreateSnakeSerializer;
import co.s4n.snakes.commands.deletesnake.DeleteSnakeSerializer;
import co.s4n.snakes.commands.updatesnake.UpdateSnakeSerializer;

import java.util.HashMap;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class CommandSerializers {

    private final static CommandSerializers instance = new CommandSerializers();
    private final HashMap<String, CommandSerializer> processors = new HashMap<>();

    public CommandSerializers() {
        super(); // what's the reason?
        processors.put("CreateSnake", new CreateSnakeSerializer());
        processors.put("DeleteSnake", new DeleteSnakeSerializer());
        processors.put("UpdateSnake", new UpdateSnakeSerializer());
    }

    public static CommandSerializers getInstance(){
        return instance;
    }

    public CommandSerializer get(String commandName){
        return processors.get(commandName);
    }

}
