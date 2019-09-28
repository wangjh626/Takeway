package com.wjh.controller;

import com.wjh.entity.MenuVO;
import com.wjh.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/menu")
public class MenuController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return new MenuVO(0, "", menuMapper.count(), menuMapper.findAll(index, limit));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuMapper.deleteById(id);
    }
}
