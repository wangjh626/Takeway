package com.wjh.controller;

import com.wjh.entity.MenuVO;
import com.wjh.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String delete(@PathVariable("id") long id) {
        menuFeign.deletebyId(id);
        return "redirect:/client/redirect/index";
    }
}
