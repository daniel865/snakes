package co.s4n.snakes.infrastructure.dao;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class SnakeMapperJdbi implements ResultSetMapper<SnakeRecord>{

    @Override
    public SnakeRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new SnakeRecord(r.getInt("idSnake"), r.getString("name"),
                               r.getString("color"), r.getString("breed"));
    }
}
