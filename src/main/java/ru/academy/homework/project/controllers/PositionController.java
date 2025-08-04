package ru.academy.homework.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.repository.PositionRepository;
import ru.academy.homework.project.services.PositionService;


import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {


    @Autowired
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @Autowired
    private PositionRepository repository;


    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("Home");
        List<PositionEnt> listPos = repository.findAll();
        model.addAttribute("positions", listPos);
        return "position/index";


    }


    @GetMapping("/create")
    public String create(Model model) {
        System.out.println(model.addAttribute("position", new PositionEnt()));
        System.out.println("Create" + model);
        return "position/create";
    }

    @PostMapping("/create")
    public String createPost(PositionEnt positionEnt) {
        repository.save(positionEnt);
        return "redirect:position/create";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        repository.deleteAll();
        return "redirect:position/index";
    }
}
