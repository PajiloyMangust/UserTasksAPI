package com.example.test.model;

import com.example.test.Entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean comoleted;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setComoleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComoleted() {
        return comoleted;
    }

    public void setComoleted(Boolean comoleted) {
        this.comoleted = comoleted;
    }
}
