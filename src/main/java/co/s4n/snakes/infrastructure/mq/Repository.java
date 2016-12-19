package co.s4n.snakes.infrastructure.mq;

/**
 * Created by daniel-rua on 15/12/16.
 */
public interface Repository<T> {
    String add(T entity);
    String remove(T entity);
    T update(T entity);
}
