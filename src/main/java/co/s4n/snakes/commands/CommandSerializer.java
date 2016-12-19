package co.s4n.snakes.commands;

import java.io.IOException;

/**
 * Created by daniel-rua on 15/12/16.
 */
public interface CommandSerializer {
    Command deserialize(String json) throws IOException;
}
