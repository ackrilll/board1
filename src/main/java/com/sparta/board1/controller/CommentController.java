package com.sparta.board1.controller;

import com.sparta.board1.sevice.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentServicce;
}
