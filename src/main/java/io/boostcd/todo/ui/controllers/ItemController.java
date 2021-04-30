package io.boostcd.todo.ui.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.boostcd.todo.ui.model.TodoItem;
import io.boostcd.todo.ui.service.ItemService;

@Controller
public class ItemController {

	private ItemService itemService;
	
	@RequestMapping("/item/{id}")
	public String item(@PathVariable int id, Model model) {
		TodoItem item = itemService.getItem(id);
		model.addAttribute("item", item);
		return "item";
	}
	
	@RequestMapping("/list/{id}/items")
	public String listItems(@PathVariable int id, Model model) {
		List<TodoItem> listItems = itemService.getItemsByList(id);
		model.addAttribute("listItems", listItems);
		return "listItems";
	}
		
	@PostMapping("/item")
	public String itemSubmit(@ModelAttribute TodoItem item) {
		itemService.updateItem(item);
		return "redirect:/list/" + item.getId() + "/items";
	}

	@RequestMapping("/addItem")
	public String addItem(Model model) {
		model.addAttribute("exchangeRate", new TodoItem());
		return "item";
	}
	
	@PostMapping("/addItem")
	public String addItemSubmit(@ModelAttribute TodoItem item) {
		itemService.addItem(item);
		return "redirect:/list/" + item.getId() + "/items";
	}	
	
}
