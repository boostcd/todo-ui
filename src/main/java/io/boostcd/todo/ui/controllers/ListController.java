package io.boostcd.todo.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.boostcd.todo.ui.model.TodoList;
import io.boostcd.todo.ui.service.ListService;

@Controller
public class ListController {

	private ListService listService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("lists", listService.getLists());
		return "lists";
	}

	@GetMapping("/addList")
	public String addListForm(Model model) {
		model.addAttribute("list", new TodoList());
		return "addList";
	}

	@PostMapping("/addList")
	public String addListSubmit(@ModelAttribute TodoList list) {
		listService.addList(list);
		return "redirect:/";
	}

}
