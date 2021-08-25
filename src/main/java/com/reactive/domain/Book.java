package com.reactive.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String title;
    private String bio;
    private double price;
    private Date createdAt = new Date();
    private String author;
}
