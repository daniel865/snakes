package co.s4n.snakes.infrastructure.mapper;

import co.s4n.snakes.domain.Snake;
import co.s4n.snakes.infrastructure.dao.SnakeRecord;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import java.util.ArrayList;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class SnakeMapperDozer {

    private static Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    static {
        ArrayList<String> mappingFilesUrls = new ArrayList<>();
        mappingFilesUrls.add("dozer/dozerBeanMapping.xml");

        ((DozerBeanMapper) mapper).setMappingFiles(mappingFilesUrls);
    }

    public Snake mapSnakeRecord(SnakeRecord snakeRecord){
        Snake snake = mapper.map(snakeRecord, Snake.class);
        return snake;
    }

    public SnakeRecord mapSnake(Snake snake){
        SnakeRecord snakeRecord = mapper.map(snake, SnakeRecord.class);
        return snakeRecord;
    }


}
