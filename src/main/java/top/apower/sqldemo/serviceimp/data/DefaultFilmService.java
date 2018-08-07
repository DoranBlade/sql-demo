package top.apower.sqldemo.serviceimp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import top.apower.sqldemo.mapper.data.FilmDOMapper;
import top.apower.sqldemo.model.data.FilmDO;
import top.apower.sqldemo.model.data.FilmDOExample;
import top.apower.sqldemo.service.data.FilmService;

import java.util.List;

@Component
public class DefaultFilmService implements FilmService {

    private final FilmDOMapper filmDOMapper;

    @Autowired(required = false)
    public DefaultFilmService(FilmDOMapper filmDOMapper) {
        Assert.notNull(filmDOMapper, "filmDOMapper不能为空");
        this.filmDOMapper = filmDOMapper;
    }


    @Override
    public List<FilmDO> queryAll() {
        return filmDOMapper.selectByExample(new FilmDOExample());
    }
}
