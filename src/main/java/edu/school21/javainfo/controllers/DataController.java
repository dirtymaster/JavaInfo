package edu.school21.javainfo.controllers;

import edu.school21.javainfo.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public <T> String insert(@PathVariable("tablename") String tablename,
                         Model model) {
        model.addAttribute("object", (T) dao.getObject(tablename));
        model.addAttribute("fields", dao.getFields(tablename));
        return "html/data/insert";
    }

    @RequestMapping(value = "/{tablename}/new", method = RequestMethod.POST)
    public <T> String create(@ModelAttribute("object") T object) {
        dao.insert(object);
        return "redirect:/data/{tablename}/getall";
    }
}
