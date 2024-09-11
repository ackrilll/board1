package com.sparta.board1.controller;

import com.sparta.board1.dto.comment.requestDto.CommentSaveRequestDto;
import com.sparta.board1.dto.comment.responseDto.CommentResponseDto;
import com.sparta.board1.dto.comment.responseDto.CommentSaveResponseDto;
import com.sparta.board1.sevice.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/boards/{boardId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long boardId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(boardId, commentSaveRequestDto);
    }

    @GetMapping("/boards/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }
}
