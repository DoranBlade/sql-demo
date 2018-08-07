package top.apower.sqldemo.serviceimp.data;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import top.apower.sqldemo.mapper.data.ActorDOMapper;
import top.apower.sqldemo.model.data.ActorDO;
import top.apower.sqldemo.model.data.ActorDOExample;
import top.apower.sqldemo.service.data.ActorService;

import java.util.List;

@Component
public class DefaultActorService implements ActorService {

    private final ActorDOMapper actorDOMapper;

    @Autowired(required = false)
    public DefaultActorService(ActorDOMapper actorDOMapper) {
        Assert.notNull(actorDOMapper, "actorDOMapper不能为空");
        this.actorDOMapper = actorDOMapper;
    }

    @Override
    public List<ActorDO> queryPage(int page, int size) {
        PageHelper.startPage(page, size);
        return actorDOMapper.selectByExample(new ActorDOExample());
    }
}
