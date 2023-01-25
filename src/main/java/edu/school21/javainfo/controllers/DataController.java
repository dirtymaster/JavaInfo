package edu.school21.javainfo.controllers;

import edu.school21.javainfo.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/{tablename}/get")
    public String get(
            @PathVariable("tablename") String tablename, Model model) {
        model.addAttribute("tablename", tablename);
        return 
    }
}
