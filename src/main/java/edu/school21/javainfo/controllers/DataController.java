package edu.school21.javainfo.controllers;

import edu.school21.javainfo.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import edu.school21.javainfo.model.*;

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
    public String insert(@PathVariable("tablename") String tablename,
                             Model model) {
        model.addAttribute("object", dao.getObject(tablename));
        return "html/data/insert";
    }

    @PostMapping("/checks/insert")
    public String create(Check check) {
        dao.insert(check, "checks");
        return "redirect:/data/check/getall";
    }

    @PostMapping("/friends/insert")
    public String create(Friend friend) {
        dao.insert(friend, "friends");
        return "redirect:/data/friends/getall";
    }

    @PostMapping("/p2p/insert")
    public String create(P2p p2p) {
        dao.insert(p2p, "p2p");
        return "redirect:/data/p2p/getall";
    }

    @PostMapping("/peers/insert")
    public String create(Peer peer) {
        dao.insert(peer, "peers");
        return "redirect:/data/peers/getall";
    }

    @PostMapping("/recommendations/insert")
    public String create(Recommendation recommendation) {
        dao.insert(recommendation, "recommendations");
        return "redirect:/data/recommendations/getall";
    }

    @PostMapping("/tasks/insert")
    public String create(Task task) {
        dao.insert(task, "tasks");
        return "redirect:/data/tasks/getall";
    }

    @PostMapping("/timetracking/insert")
    public String create(Timetracking timetracking) {
        dao.insert(timetracking, "timetracking");
        return "redirect:/data/timetracking/getall";
    }

    @PostMapping("/transferredpoints/insert")
    public String create(Transferredpoint transferredpoint) {
        dao.insert(transferredpoint, "transferredpoints");
        return "redirect:/data/transferredpoints/getall";
    }

    @PostMapping("/verter/insert")
    public String create(Verter verter) {
        dao.insert(verter, "verter");
        return "redirect:/data/verter/getall";
    }

    @PostMapping("/xp/insert")
    public String create(Xp xp) {
        dao.insert(xp, "xp");
        return "redirect:/data/xp/getall";
    }
}
