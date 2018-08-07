package top.apower.sqldemo.mapper.custom;

import org.apache.ibatis.annotations.Param;
import top.apower.sqldemo.model.data.ActorFilmDO;

import java.util.List;

public interface CustomActorFilmDOMapper {

    Long insertList(@Param("param") List<ActorFilmDO> param);
}
