package com.kh.borad.web;

import com.kh.borad.domain.entity.Board;
import com.kh.borad.domain.forum.dao.BoardDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class BoardControllerTest {

  @Autowired
  BoardDAO boardDAO;

  @Test
  @DisplayName("게시글등록")
  void add() {
    Board board = new Board();
    board.setBname("홍길순");
    board.setTitle("안녕");
    board.setUserContent("안녕하세요");

    Long boardId = boardDAO.save(board);
    log.info("boardId={}{}", boardId,"2");
    log.info("board={}", board);
  }

  @Test
  @DisplayName("게시글등록")
  void findById() {
    Long boardId = 1L;
    Optional<Board> findedBoard = boardDAO.findById(boardId);
    Board board = findedBoard.orElse(null);
    log.info("product={}", board);
  }


}