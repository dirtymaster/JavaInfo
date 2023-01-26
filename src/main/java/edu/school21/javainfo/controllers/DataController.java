package edu.school21.javainfo.controllers;

import edu.school21.javainfo.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Arrays;

@Controller
@RequestMapping("/data")
public class DataController {
    private DAO dao;

    @Autowired
    public DataController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String getData(Model model) {
        model.addAttribute("tables", dao.index());
        return "html/data/data";
    }

    @GetMapping("/{tablename}")
    public String getTable(
            @PathVariable("tablename") String tablename, Model model) {
        model.addAttribute("tablename", tablename);
        return "html/data/table";
    }

    @GetMapping("/{tablename}/getall")
    public String get(
            @PathVariable("tablename") String tablename, Model model) {
        model.addAttribute("fields", dao.getFields(tablename));
        model.addAttribute("values", dao.getAll(tablename));
        return "html/data/getall";
    }

    @GetMapping("/{tablename}/insert")
    public String insert(@PathVariable("tablename") String tablename,
                         Model model) {
        model.addAttribute("object",
                dao.getTableClass(tablename).cast(dao.getObject(tablename)));
        model.addAttribute("fields", dao.getFields(tablename));
        System.out.println(dao.getTableClass(tablename).cast(dao.getObject(tablename)).getClass().getName());
        for (Field field : dao.getTableClass(tablename).cast(dao.getObject(tablename)).getClass().getFields()) {
            System.out.println(field.getName().substring(field.getName().lastIndexOf(".") + 1));
        }
        return "html/data/insert";
    }

//    @PostMapping("/{tablename}/new")
//    public String create(@ModelAttribute("object") Object object) {
//        Field field = null;
//        field.g
//        dao.
//        return "redirect:/{tablename}/getall";
//    }
}
