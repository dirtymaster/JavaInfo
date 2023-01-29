package edu.school21.javainfo.controllers;

import com.google.gson.Gson;
import edu.school21.javainfo.dao.DAO;
import edu.school21.javainfo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.sql.Time;

@Controller
@RequestMapping("/data")
public class DataController {
    private final DAO dao;

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

//    @GetMapping("/{tablename}/insert")
//    public <T> String insert(@PathVariable("tablename") String tablename,
//                         Model model) {
//        model.addAttribute("object", (T) dao.getObject(tablename));
//        model.addAttribute("fields", dao.getFields(tablename));
//        return "html/data/insert";
//    }
//
//    @RequestMapping(value = "/{tablename}/new", method = RequestMethod.POST)
//    public <T> String create(@ModelAttribute("object") T object) {
//        dao.insert(object);
//        return "redirect:/data/{tablename}/getall";
//    }

    @GetMapping("/{tablename}/insert")
    public <T> String insert(@PathVariable("tablename") String tablename,
                             Model model) {
        model.addAttribute("object", dao.getObject(tablename));
        return "html/data/insert";
    }

    @PostMapping("/checks/new")
    public <T> String create(@ModelAttribute("object") Check check) {
        dao.insert(check);
        return "redirect:/data/check/getall";
    }
    @PostMapping("/friends/new")
    public <T> String create(@ModelAttribute("object") Friend friend) {
        dao.insert(friend);
        return "redirect:/data/friends/getall";
    }
    @PostMapping("/p2p/new")
    public <T> String create(@ModelAttribute("object") P2p p2p) {
        dao.insert(p2p);
        return "redirect:/data/p2p/getall";
    }
    @PostMapping("/peers/new")
    public <T> String create(@ModelAttribute("object") Peer peer) {
        dao.insert(peer);
        return "redirect:/data/peers/getall";
    }
    @PostMapping("/recommendations/new")
    public <T> String create(@ModelAttribute("object") Recommendation recommendation) {
        dao.insert(recommendation);
        return "redirect:/data/recommendations/getall";
    }
    @PostMapping("/tasks/new")
    public <T> String create(@ModelAttribute("object") Task task) {
        dao.insert(task);
        return "redirect:/data/tasks/getall";
    }
    @PostMapping("/timetracking/new")
    public <T> String create(@ModelAttribute("object") Timetracking timetracking) {
        dao.insert(timetracking);
        return "redirect:/data/timetracking/getall";
    }
    @PostMapping("/transferredpoint/new")
    public <T> String create(@ModelAttribute("object") Transferredpoint transferredpoint) {
        dao.insert(transferredpoint);
        return "redirect:/data/transferredpoint/getall";
    }
    @PostMapping("/verter/new")
    public <T> String create(@ModelAttribute("object") Verter verter) {
        dao.insert(verter);
        return "redirect:/data/verter/getall";
    }
    @PostMapping("/xp/new")
    public <T> String create(@ModelAttribute("object") Xp xp) {
        dao.insert(xp);
        return "redirect:/data/xp/getall";
    }
}
