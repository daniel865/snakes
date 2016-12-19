package co.s4n.snakes.infrastructure.events;

import co.com.proteccion.advance.it.eventos.events.api.Event;
import co.com.proteccion.advance.it.eventos.events.api.Evento;
import org.joda.time.DateTime;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class SnakeDeleted extends Event {

    private Evento evento;
    private DateTime timestamps;
    protected static final Object NOT_FOUND_VALUE = new Object();

    public SnakeDeleted() {
    }

    public SnakeDeleted(Evento evento, DateTime timestamps) {
        this.setEvento(evento);
        this.setTimestamps(timestamps);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public DateTime getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(DateTime timestamps) {
        this.timestamps = timestamps;
    }

    public static Object getNotFoundValue() {
        return NOT_FOUND_VALUE;
    }
}
