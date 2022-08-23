package com.example.lecture_spring_2_crudproject.entity.customDto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Value
public class CustomDtoExample {

    private String input_id;
    private String input_writer;
    private String input_title;
}
