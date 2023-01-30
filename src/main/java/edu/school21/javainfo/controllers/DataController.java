package edu.school21.javainfo.controllers;

import edu.school21.javainfo.dao.DAO;
import edu.school21.javainfo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

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

    @GetMapping("/{tablename}/insert")
    public <T> String insert(@PathVariable("tablename") String tablename,
                             Model model) {
        model.addAttribute("object", dao.getObject(tablename));
        return "html/data/insert";
    }

    @PostMapping("/checks/new")
    public <T> String create(@ModelAttribute("object") Check check) {
        dao.insert(check, "checks");
        return "redirect:/data/check/getall";
    }
    @PostMapping("/friends/new")
    public <T> String create(@ModelAttribute("object") Friend friend) {
        dao.insert(friend, "friends");
        return "redirect:/data/friends/getall";
    }
    @PostMapping("/p2p/new")
    public <T> String create(@ModelAttribute("object") P2p p2p) {
        dao.insert(p2p, "p2p");
        return "redirect:/data/p2p/getall";
    }
    @PostMapping("/peers/new")
    public <T> String create(@ModelAttribute("object") Peer peer) {
        dao.insert(peer, "peers");
        return "redirect:/data/peers/getall";
    }
    @PostMapping("/recommendations/new")
    public <T> String create(@ModelAttribute("object") Recommendation recommendation) {
        dao.insert(recommendation, "recommendations");
        return "redirect:/data/recommendations/getall";
    }
    @PostMapping("/tasks/new")
    public <T> String create(@ModelAttribute("object") Task task) {
        dao.insert(task, "tasks");
        return "redirect:/data/tasks/getall";
    }
    @PostMapping("/timetracking/new")
    public <T> String create(@ModelAttribute("object") Timetracking timetracking) {
        dao.insert(timetracking, "timetracking");
        return "redirect:/data/timetracking/getall";
    }
    @PostMapping("/transferredpoints/new")
    public <T> String create(@ModelAttribute("object") Transferredpoint transferredpoint) {
        dao.insert(transferredpoint, "transferredpoints");
        return "redirect:/data/transferredpoints/getall";
    }
    @PostMapping("/verter/new")
    public <T> String create(@ModelAttribute("object") Verter verter) {
        dao.insert(verter, "verter");
        return "redirect:/data/verter/getall";
    }
    @PostMapping("/xp/new")
    public <T> String create(@ModelAttribute("object") Xp xp) {
        dao.insert(xp, "xp");
        return "redirect:/data/xp/getall";
    }
}
