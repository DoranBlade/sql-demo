package top.apower.sqldemo.mapper.custom;

import org.apache.ibatis.annotations.Param;
import top.apower.sqldemo.model.data.ActorDO;

import java.util.List;

public interface CustomActorDOMapper {

    Long insertList(@Param("param") List<ActorDO> param);
}
