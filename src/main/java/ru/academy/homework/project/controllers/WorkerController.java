package ru.academy.homework.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.academy.homework.project.model.WorkerEnt;
import ru.academy.homework.project.repository.PositionRepository;
import ru.academy.homework.project.repository.WorkerRepository;
import ru.academy.homework.project.repository.WorkerSortRepository;

import java.util.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private WorkerSortRepository workerSortRepository;
    @Autowired
    private PositionRepository positionRepository;


    @GetMapping("/home")
    public String home(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {
        List<WorkerEnt> list = workerRepository.findAll();
        if (!list.isEmpty()) {
            int totalWorkers = (int) workerRepository.count();
            int totalPages = (int) Math.ceil((double) totalWorkers / size);
            int fromIndex = (page - 1) * size;
            int toIndex = fromIndex + size;

            int sizePage = 10;
            int startPage = Math.max(1, page - sizePage / 2);
            int endPage = Math.min(startPage + sizePage, totalPages);

            List<WorkerEnt> workers = list.subList(fromIndex, toIndex);
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("workers", workers);
            model.addAttribute("size", size);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("totalWorkers", totalWorkers);
            model.addAttribute("currentPage", page);
        } else {
            model.addAttribute("workers", new ArrayList<>());

        }
        model.addAttribute("title", "Worker List");

        return "worker/index";
    }
    @GetMapping("/home/filter")
    public String filter(Model model) {
        List<WorkerEnt> list = workerRepository.findAll();
        List<WorkerEnt> filteredList = new ArrayList<>();
        for (WorkerEnt worker : list) {

        }
        return "worker/index";
    }

    @GetMapping("/sort/{columIndex}")
    public String home(Model model, @PathVariable int columIndex, String sort) {
        List<WorkerEnt> list = workerRepository.findAll();
        model.addAttribute("worker", list);
        model.addAttribute("title", "Worker List");
        return "worker/index";
    }


    @GetMapping("/create")
    public String create(Model model) {


        model.addAttribute("worker", new WorkerEnt());


        model.addAttribute("positions", positionRepository.findAll());

        return "worker/create";
    }

    @PostMapping("/create")
    public String createPost(WorkerEnt workerEnt) {


        workerRepository.save(workerEnt);
        return "redirect:home";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Optional<WorkerEnt> workerEnt = workerRepository.findById(id);
        model.addAttribute("worker", workerEnt.get());
        model.addAttribute("positions", positionRepository.findAll());
        return "worker/edit";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        workerRepository.deleteAll();
        return "redirect:home";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        positionRepository.deleteById(id);
        return "redirect:/worker/home";
    }

    @ResponseBody
    @DeleteMapping("/api/delete/{id}")
    public String deleteByIdAjax(@PathVariable Long id) {
        Optional<WorkerEnt> removeWorker = workerRepository.findById(id);
        if (removeWorker.isPresent()) {
            workerRepository.delete(removeWorker.get());
            return "Worker deleted => " + removeWorker.get();
        } else {
            return "Worker deleted false";
        }
    }


}
