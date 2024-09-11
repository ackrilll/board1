package com.sparta.board1.sevice;

import com.sparta.board1.dto.comment.requestDto.CommentSaveRequestDto;
import com.sparta.board1.dto.comment.responseDto.CommentResponseDto;
import com.sparta.board1.dto.comment.responseDto.CommentSaveResponseDto;
import com.sparta.board1.entity.Board;
import com.sparta.board1.entity.Comment;
import com.sparta.board1.repository.BoardRepository;
import com.sparta.board1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long boardId, CommentSaveRequestDto commentSaveRequestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드 못찾았음"));
        Comment comment = new Comment(commentSaveRequestDto.getComment(),board);
        Comment savedComment = commentRepository.save(comment);
        return new CommentSaveResponseDto(savedComment.getId(),savedComment.getContent());
    }

    public List<CommentResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContent()));
        }
        return dtoList;
    }
}
