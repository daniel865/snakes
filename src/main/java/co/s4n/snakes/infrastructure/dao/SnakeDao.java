package co.s4n.snakes.infrastructure.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by daniel-rua on 15/12/16.
 */

@RegisterMapper(SnakeMapperJdbi.class)
public interface SnakeDao {

    @SqlUpdate("INSERT INTO snake (idSnake, name, color, breed) values (:e.idSnake, :e.name, :e.color, :e.breed)")
    void insert(@BindBean("e") SnakeRecord snakeRecord);

    @SqlQuery("SELECT * FROM snake")
    List<SnakeRecord> findAll();

    @SqlQuery("SELECT * FROM snake WHERE idSnake = :idSnake")
    SnakeRecord findById(@Bind("idSnake") int id);

    @SqlUpdate("UPDATE snake SET name = :e.name, color = :e.color, breed = :e.breed WHERE idSnake = :e.idSnake")
    void update(@BindBean("e") SnakeRecord snakeRecord);

    @SqlUpdate("DELETE FROM snake where idSnake = :idSnake")
    void deleteById(@Bind("idSnake") int id);

    void close();

}
