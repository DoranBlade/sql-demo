package top.apower.sqldemo.mapper.custom;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.apower.sqldemo.SqlDemoApplicationTests;
import top.apower.sqldemo.model.data.ActorDO;
import top.apower.sqldemo.model.data.ActorFilmDO;
import top.apower.sqldemo.model.data.FilmDO;
import top.apower.sqldemo.model.data.FilmDOExample;
import top.apower.sqldemo.service.data.ActorService;
import top.apower.sqldemo.service.data.FilmService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomActorFilmDOMapperTest extends SqlDemoApplicationTests {

    private int count = 0;
    private int size = 5;
    private List<ActorDO> actorDOS;
    private List<FilmDO> filmDOS;

    @Autowired(required = false)
    private CustomActorFilmDOMapper customActorFilmDOMapper;

    @Autowired
    private ActorService actorService;

    @Autowired
    private FilmService filmService;

    @Before
    public void before() {
        this.actorDOS = this.actorService.queryAll();
        this.filmDOS = this.filmService.queryAll();
    }

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
            ActorDO actorDO = this.actorDOS.get(count++);
            List<FilmDO> filmDOS = randomFilm(4);
            List<ActorFilmDO> items = filmDOS.stream()
                    .map(filmDO -> new ActorFilmDO().withActorId(actorDO.getId()).withFilmId(filmDO.getId()))
                    .collect(Collectors.toList());
            container.addAll(items);
        }
        return container;
    }

    private List<FilmDO> randomFilm(int size) {
        List<FilmDO> container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = RandomUtils.nextInt(0, this.filmDOS.size());
            container.add(this.filmDOS.get(index));
        }
        return container;
    }

}