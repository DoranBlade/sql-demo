package top.apower.sqldemo.mapper.custom;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.apower.sqldemo.SqlDemoApplicationTests;
import top.apower.sqldemo.model.data.DemoDO;
import utils.FakerUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomDemoDOMapperTest extends SqlDemoApplicationTests {

    @Autowired(required = false)
    private CustomDemoDOMapper customDemoDOMapper;

    public CustomDemoDOMapperTest() {
    }

    @Test
    public void insertList() {
        long size = 10000L;
        long page = 100;
        for (int i = 0; i < page; i++) {
            Long res = customDemoDOMapper.insertList(getData(size));
            Assert.assertThat(res, Matchers.equalTo(size));
        }
    }

    private List<DemoDO> getData(Long size) {
        List<DemoDO> container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DemoDO item = new DemoDO()
                    .withFirstName(FakerUtils.faker.name().firstName())
                    .withLastName(FakerUtils.faker.name().lastName())
                    .withAge((byte) FakerUtils.faker.number().numberBetween(0, 150));
            container.add(item);
        }
        return container;
    }
}