package com.wjh.mapper;

import com.wjh.entity.Menu;
import java.util.List;

public interface MenuMapper {
    List<Menu> findAll(int index, int limit);

    int count();

    Menu findById(long id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(long id);
}
