package top.apower.sqldemo.mapper.custom;

import org.apache.ibatis.annotations.Param;
import top.apower.sqldemo.model.data.DemoDO;

import java.util.List;

public interface CustomDemoDOMapper {

    Long insertList(@Param("param")List<DemoDO> param);
}
