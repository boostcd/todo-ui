package io.boostcd.todo.ui.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.boostcd.todo.ui.model.TodoList;

@Service
public class ListService {

	@Autowired
	private RestTemplate restTemplate;

	public List<TodoList> getLists() {
		return Arrays.asList(restTemplate.getForObject(System.getenv("LIST_MS_URI") + "/lists", TodoList[].class));
	}

	public void addList(TodoList list) {
		restTemplate.postForObject(System.getenv("LIST_MS_URI") + "/list", list, TodoList.class);
	}

}
