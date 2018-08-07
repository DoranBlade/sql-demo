package top.apower.sqldemo.service.data;

import top.apower.sqldemo.model.data.ActorDO;

import java.util.List;

public interface ActorService {

    List<ActorDO> queryPage(int page, int size);

}
