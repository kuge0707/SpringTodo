package com.example.spring_todo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.spring_todo.domains.Task;

@Mapper
public interface TaskMapper {
	List<Task> all();
	void add(Task task);
	void change(int id);
}
