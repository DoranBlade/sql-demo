package top.apower.sqldemo.mapper.custom;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.apower.sqldemo.SqlDemoApplicationTests;
import top.apower.sqldemo.model.data.FilmDO;
import utils.FakerUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomFilmDOMapperTest extends SqlDemoApplicationTests {

    @Autowired(required = false)
    private CustomFilmDOMapper customFilmDOMapper;

    @Test
    public void insertList() {
        long size = 10000;
        long page = 100;
        for (int i = 0; i < page; i ++) {
            long res = customFilmDOMapper.insertList(getDate(size));
            Assert.assertThat(size, Matchers.equalTo(res));
        }
    }

    private List<FilmDO> getDate(long size) {
        List<FilmDO> container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            container.add(getInstance());
        }
        return container;
    }

    private FilmDO getInstance() {
        return new FilmDO().withName(FakerUtils.faker.name().fullName());
    }


}