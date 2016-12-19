package co.s4n.snakes.commands;

import co.com.proteccion.advance.it.eventos.events.api.Event;

import java.util.List;

/**
 * Created by daniel-rua on 15/12/16.
 */
public interface Command<T> {
    String name();
    T data();
    void setData(T data);
    List<Event> execute() throws Exception;
}
