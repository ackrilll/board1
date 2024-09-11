package com.sparta.board1.dto.board.responseDto;

import lombok.Getter;

@Getter
public class BoardSaveResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    public BoardSaveResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


}
