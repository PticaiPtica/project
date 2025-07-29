package ru.academy.homework.proect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.academy.homework.proect.entities.PositionEnt;
import ru.academy.homework.proect.entities.WorkerEnt;
import ru.academy.homework.proect.repository.PositionRepository;
import ru.academy.homework.proect.repository.WorkerRepository;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<WorkerEnt> listWorkers = workerRepository.findAll();
        model.addAttribute("listWorkers", listWorkers);
        return "worker/index";
    }

    @GetMapping("/create")
    public String create(Model model) {


        model.addAttribute("worker", new WorkerEnt());
        System.out.println(model.addAttribute("worker", new WorkerEnt()));
        //model.addAttribute("options", Arrays.stream(positionRepository.findAll().toArray()));
        model.addAttribute("positions", positionRepository.findAll());

        return "worker/create";
    }

    @PostMapping("/create")
    public String createPost(WorkerEnt workerEnt) {

        System.out.println(":::::::::::::::");
        workerRepository.save(workerEnt);
        return "redirect:home";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        workerRepository.deleteAll();
        return "redirect:home";
    }
}
