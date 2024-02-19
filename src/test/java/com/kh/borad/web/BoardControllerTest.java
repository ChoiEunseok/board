package com.kh.borad.web;

import com.kh.borad.domain.entity.Board;
import com.kh.borad.domain.forum.dao.BoardDAO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
  @DisplayName("게시글조회")
  void findById() {
    Long boardId = 1L;
    Optional<Board> findedBoard = boardDAO.findById(boardId);
    Board board = findedBoard.orElse(null);
    log.info("product={}", board);
  }

  @Test
  @DisplayName("게시글삭제")
  void deleteById() {
    Long pid = 4L;
    int deleteRowCnt = boardDAO.deleteById(pid);
    log.info("삭제건수={}", deleteRowCnt);
    Assertions.assertThat(deleteRowCnt).isEqualTo(1);
  }

  @Test
  @DisplayName("게시글수정")
  void update() {
    Long boardId = 5L;
    Board board = new Board();
    board.setTitle("Hello");
    board.setUserContent("Hello~~");
    int updatedRowCnt = boardDAO.updateById(boardId, board);
    log.info("updatedRowCnt={}", updatedRowCnt);
    if (updatedRowCnt == 0) {
      Assertions.fail("변경 내역이 없습니다.");
    }
    Optional<Board> optionalBoard = boardDAO.findById(boardId);
    if (optionalBoard.isPresent()) {
      Board findedboard = optionalBoard.get();
      Assertions.assertThat(findedboard.getTitle()).isEqualTo("Hello");
      Assertions.assertThat(findedboard.getUserContent()).isEqualTo("Hello~~");
    } else {
      Assertions.fail("변경할 상품이 없습니다.");
    }
  }
  @Test
  @DisplayName("게시글목록")
  void findAll() {
    List<Board> list = boardDAO.findAll();
    for (Board board : list) {
      log.info("Board={}",board);
    }
    log.info("size={}",list.size());
  }
}