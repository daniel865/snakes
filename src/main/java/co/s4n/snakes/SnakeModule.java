package co.s4n.snakes;

import co.s4n.snakes.infrastructure.jdbi.DefaultDBI;
import co.s4n.snakes.infrastructure.mq.Repository;
import com.google.inject.AbstractModule;
import org.skife.jdbi.v2.IDBI;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class SnakeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IDBI.class).to(DefaultDBI.class);
        bind(Repository.class).to(SnakeRepository.class);
    }
}
