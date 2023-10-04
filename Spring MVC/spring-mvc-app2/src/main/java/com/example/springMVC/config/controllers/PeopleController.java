package com.example.springMVC.config.controllers;

import com.example.springMVC.config.dao.PersonDAO;
import com.example.springMVC.config.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

  @Autowired
  private PersonDAO personDAO;

  @GetMapping()
  public String index(Model model) {
    model.addAttribute("people", personDAO.index());
    return "index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute("person", personDAO.show(id));
    return "show";
  }

  @GetMapping("/new")
  public String createNewPerson(@ModelAttribute("person") Person person) {
    return "new";
  }

  @PostMapping()
  public String addNewPerson(@ModelAttribute("person") Person person) {
    personDAO.save(person);
    return "redirect:/people";
  }



}
