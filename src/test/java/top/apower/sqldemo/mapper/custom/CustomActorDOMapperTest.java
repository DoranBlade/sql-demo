package top.apower.sqldemo.mapper.custom;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.apower.sqldemo.SqlDemoApplicationTests;
import top.apower.sqldemo.model.data.ActorDO;
import top.apower.sqldemo.model.data.FilmDO;
import utils.FakerUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomActorDOMapperTest extends SqlDemoApplicationTests {

    @Autowired(required = false)
    private CustomActorDOMapper customActorDOMapper;

    @Test
    public void insertList() {
        long size = 10000;
        long page = 100;
        for (int i = 0; i < page; i ++) {
            long res = customActorDOMapper.insertList(getDate(size));
            Assert.assertThat(size, Matchers.equalTo(res));
        }
    }

    private List<ActorDO> getDate(long size) {
        List<ActorDO> container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            container.add(getInstance());
        }
        return container;
    }

    private ActorDO getInstance() {
        return new ActorDO().withName(FakerUtils.faker.name().fullName());
    }
}