package com.sparta.board1.dto.comment.responseDto;

import lombok.Getter;

@Getter
public class CommentSaveResponseDto {
    private final Long id;
    private final String content;

    public CommentSaveResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
