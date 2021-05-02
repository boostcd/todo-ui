package io.boostcd.todo.ui.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.boostcd.todo.ui.model.TodoItem;

@Service
public class ItemService {

	@Autowired
	private RestTemplate restTemplate;

	public TodoItem getItem(int id) {
		return restTemplate.getForObject(System.getenv("ITEM_MS_URI") + "/item/{1}", TodoItem.class, id);
	}

	public List<TodoItem> getItemsByList(int id) {
		return Arrays.asList(restTemplate.getForObject(System.getenv("ITEM_MS_URI") + "/list/{1}/items", TodoItem[].class, id));
	}

	public TodoItem addItem(int listId, TodoItem item) {
		return restTemplate.postForObject(System.getenv("ITEM_MS_URI") + "/list/{1}/item", item, TodoItem.class, listId);
	}

	public TodoItem complete(int id) {
		return restTemplate.postForObject(System.getenv("ITEM_MS_URI") + "/item/{1}/complete", id, TodoItem.class);
	}

}
