package co.s4n.snakes.infrastructure.jdbi;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class DefaultDBI extends DBI {

    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultDBI.class);

    public DefaultDBI() {
        // if is possible create a dataSource for snakes and changes server.xml configuration
        //super(get("jdbc/oracleSnakes"));
        super(get("jdbc/oraclePersonas"));
    }

    private static DataSource get(String jndi){
        DataSource dataSource = null;
        try {
            dataSource = (DataSource) new InitialContext().lookup(jndi);
        }catch (NamingException e){
            LOGGER.error("Loading " + jndi, e);
            e.printStackTrace();
        }
        return dataSource;
    }

}
