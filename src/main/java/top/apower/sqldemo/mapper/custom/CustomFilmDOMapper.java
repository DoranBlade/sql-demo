package top.apower.sqldemo.mapper.custom;

import org.apache.ibatis.annotations.Param;
import top.apower.sqldemo.model.data.FilmDO;

import java.util.List;

public interface CustomFilmDOMapper {

    Long insertList(@Param("param") List<FilmDO> param);
}
