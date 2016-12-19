package co.s4n.snakes;

import co.s4n.snakes.domain.Snake;
import co.s4n.snakes.infrastructure.dao.SnakeDao;
import co.s4n.snakes.infrastructure.dao.SnakeRecord;
import co.s4n.snakes.infrastructure.mapper.SnakeMapperDozer;
import co.s4n.snakes.infrastructure.mq.Repository;
import com.google.inject.Inject;
import org.skife.jdbi.v2.IDBI;
import rx.Observable;

import java.util.Collection;
import java.util.List;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class SnakeRepository implements Repository<Snake> {

    @Inject
    private IDBI dbi;
    private SnakeMapperDozer map = new SnakeMapperDozer();
    private SnakeDao dao;

    @Override
    public String add(Snake entity) {
        dao = dbi.open(SnakeDao.class);
        dao.insert(map.mapSnake(entity));
        dao.close();
        return Integer.toString(entity.getIdSnake());
    }

    @Override
    public String remove(Snake entity) {
        dao = dbi.open(SnakeDao.class);
        dao.deleteById(entity.getIdSnake());
        dao.close();
        return "";
    }

    @Override
    public Snake update(Snake entity) {
        dao = dbi.open(SnakeDao.class);
        dao.update(map.mapSnake(entity));
        dao.close();
        return entity;
    }

    public SnakeRecord findById(int id){
        dao = dbi.open(SnakeDao.class);
        SnakeRecord snakeRecord = dao.findById(id);
        dao.close();
        return snakeRecord;
    }

    public List<SnakeRecord> findAll(){
        dao = dbi.open(SnakeDao.class);
        List<SnakeRecord> snakeRecords = dao.findAll();
        dao.close();
        return snakeRecords;
    }

    public Observable<List<Snake>> filter(){
        dao = dbi.open(SnakeDao.class);
        Observable<Collection<SnakeRecord>> from = Observable.just(dao.findAll());
        Observable<List<Snake>> now = from
                .flatMap(Observable::from)
                .map(x -> map.mapSnakeRecord(x))
                .toList();
        dao.close();
        return now;
    }


}
