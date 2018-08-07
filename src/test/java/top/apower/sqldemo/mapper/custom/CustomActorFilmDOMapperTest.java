package top.apower.sqldemo.mapper.custom;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.apower.sqldemo.SqlDemoApplicationTests;
import top.apower.sqldemo.model.data.ActorDO;
import top.apower.sqldemo.model.data.ActorFilmDO;
import top.apower.sqldemo.model.data.FilmDO;
import top.apower.sqldemo.service.data.ActorService;
import top.apower.sqldemo.service.data.FilmService;

import java.util.ArrayList;
import java.util.List;

public class CustomActorFilmDOMapperTest extends SqlDemoApplicationTests {

    private int count = 0;
    private int size = 5;

    @Autowired(required = false)
    private CustomActorFilmDOMapper customActorFilmDOMapper;

    @Autowired
    private ActorService actorService;

    @Autowired
    private FilmService filmService;

    @Test
    public void insertList() {
        int size = 10000;
        int page  = 100;
        for (int i = 0; i < page; i++) {
            long res = customActorFilmDOMapper.insertList(getData(size));
        }
    }

    private List<ActorFilmDO> getData(int size) {
        List<ActorFilmDO> container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            count++;
            List<ActorDO> actorDOS = actorService.queryPage(count, 1);
            List<FilmDO> filmDOS = filmService.queryPage(count, size);
            for (int j = 0; j < filmDOS.size(); j++) {
                String actorId = actorDOS.stream().findAny().get().getId();
                container.add(new ActorFilmDO().withActorId(actorId).withFilmId(filmDOS.get(j).getId()));
            }
        }
        return container;
    }

}