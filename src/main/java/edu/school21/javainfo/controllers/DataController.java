package edu.school21.javainfo.controllers;

import edu.school21.javainfo.dao.DAO;
import edu.school21.javainfo.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

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
        model.addAttribute("object", new Friend());
        model.addAttribute("fields", dao.getFields(tablename));
        return "html/data/insert";
    }

    @PostMapping("/{tablename}/new")
    public String create(@ModelAttribute("object") Friend object) {
        System.out.println(object.peer1);
        dao.insert(object);
        return "redirect:/data/{tablename}/getall";
    }
}
