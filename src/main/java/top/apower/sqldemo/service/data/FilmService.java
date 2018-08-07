package top.apower.sqldemo.service.data;

import top.apower.sqldemo.model.data.FilmDO;

import java.util.List;

public interface FilmService {

    List<FilmDO> queryPage(int start, int offset);
}
