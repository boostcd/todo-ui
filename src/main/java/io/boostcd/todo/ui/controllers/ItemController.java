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
		List<TodoItem> items = itemService.getItemsByList(id);
		model.addAttribute("items", items);
		return "items";
	}
	
	@RequestMapping("/item/{1}/complete")
	public String complete(@PathVariable int id, Model model) {
		TodoItem item = itemService.complete(id);
		List<TodoItem> items = itemService.getItemsByList(item.getListId());
		model.addAttribute("items", items);
		return "items";		
	}	
	
	@PostMapping("/addItem")
	public String addItemSubmit(@ModelAttribute TodoItem item) {
		itemService.addItem(item.getListId(), item);
		return "redirect:/list/" + item.getId() + "/items";
	}	
	
}
