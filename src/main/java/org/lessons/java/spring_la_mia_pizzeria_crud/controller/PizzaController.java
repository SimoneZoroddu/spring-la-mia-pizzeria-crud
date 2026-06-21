package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(@RequestParam(required = false) String keyword, Model model) {

        List<Pizza> pizzas;

        if (keyword != null && !keyword.isEmpty()) {
            pizzas = repository.findByNameContainingIgnoreCase(keyword);
        } else {
            pizzas = repository.findAll();
        }

        model.addAttribute("pizzas", pizzas);
        model.addAttribute("keyword", keyword);

        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {

        Pizza pizza = repository.findById(id).orElseThrow();

        model.addAttribute("pizza", pizza);
        return "pizzas/show";
    }

}
