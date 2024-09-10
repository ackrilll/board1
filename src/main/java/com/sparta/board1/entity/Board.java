package com.sparta.board1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String comment;

    @OneToMany(mappedBy = "board", cascade =  CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

}
