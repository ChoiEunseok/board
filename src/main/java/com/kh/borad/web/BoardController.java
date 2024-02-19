package com.kh.borad.web;

import com.kh.borad.domain.entity.Board;
import com.kh.borad.domain.forum.svc.BoardSVC;
import com.kh.borad.web.form.forum.AddForm;
import com.kh.borad.web.form.forum.UpdateForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/forums")
public class BoardController {
  private BoardSVC boardSVC;

  BoardController(BoardSVC boardSVC) {this.boardSVC = boardSVC;}

  //게시판등록양식
  @GetMapping("/add")         // Get, http://localhost:9080/forums/add
  public String addForm(Model model) {
    model.addAttribute("addForm", new AddForm());
    return "forum/add";     // view이름  게시판등록화면
  }

  //게시판등록처리
  @PostMapping("/add")
  public String add( AddForm addForm, Model model,
                     RedirectAttributes redirectAttributes ) {
    log.info("addForm={}", addForm);
    //상품등록
    Board board = new Board();
    board.setBname(addForm.getBname());
    board.setTitle(addForm.getTitle());
    board.setUserContent(addForm.getUserContent());

    Long boardId = boardSVC.save(board);
    log.info("상품번호={}", boardId);

    redirectAttributes.addAttribute("pid", boardId);

    return "redirect:/forums/{pid}/detail";
  }

  //조회
  @GetMapping("/{pid}/detail")       //GET http://localhost:9080/forums/상품번호/detail
  public String findById(@PathVariable("pid") Long boardId, Model model){

    Optional<Board> findedBoard = boardSVC.findById(boardId);
    Board board = findedBoard.orElseThrow();
    model.addAttribute("board", board);

    return "forum/detailForm";
  }

  //삭제
  @GetMapping("/{pid}/del")
  public String deleteById(@PathVariable("pid") Long boardId) {
    log.info("deleteById={}", boardId);

    int deletedRowCnt = boardSVC.deleteById(boardId);

    return "redirect:/forums";    //  GET http://localhost:9080/forums/
  }


  //수정양식
  @GetMapping("/{pid}/edit")    // GET http://localhost:9080/forums/상품번호/edit
  public String updateForm(
          @PathVariable("pid") Long boardId,
          Model model) {

    Optional<Board> optionalBoard = boardSVC.findById(boardId);
    Board findedBoard = optionalBoard.orElseThrow();
    model.addAttribute("board", findedBoard);

    return "forum/updateForm";
  }
  //수정처리
  @PostMapping("/{pid}/edit")
  public String update(
          //경로변수 pid 로부터 상품번호를 읽어온다
          @PathVariable("pid") Long boardId,
          //요청메세지 바디로부터 대응되는 상품정보를 읽어온다.
          UpdateForm updateForm,
          //리다이렉트 시 경로변수에 값을 설정하기위해 사용
          RedirectAttributes redirectAttributes,
          Model model) {

    //유효성 체크
    //필드레벨
    //1-1) 상품명
//    String pattern = "^[a-zA-Z0-9가-힣_-]{3,10}$";
//    if (!Pattern.matches(pattern, updateForm.getPname())) {
//      model.addAttribute("product", updateForm);
//      model.addAttribute("s_err_pname","영문/숫자/한글/_-가능, 3~10자리");
//      return "productv2/updateForm";
//    }
//    //1-2) 수량
//    pattern = "^\\d{1,10}$";
//    if (!Pattern.matches(pattern, String.valueOf(updateForm.getQuantity())))  {
//      model.addAttribute("product", updateForm);
//      model.addAttribute("s_err_quantity", "숫자0~9사이 입력가능 1~10자리");
//      return "productv2/updateForm";
//    }
//    //글로벌 레벨
//    if (updateForm.getQuantity() * updateForm.getPrice() > 10_000_000) {
//      model.addAttribute("product", updateForm);
//      model.addAttribute("s_err_global", "총액 1000만원 초과합니다.");
//      return "productv2/updateForm";
//    }

    //정상 처리
    Board board = new Board();
    board.setTitle(updateForm.getTitle());
    board.setUserContent(updateForm.getUserContent());
    int updateRowCnt = boardSVC.updateById(boardId, board);
    redirectAttributes.addAttribute("pid", boardId);

    return "redirect:/forums/{pid}/detail";
  }

  //목록
  @GetMapping   // GET http://localhost:9080/forums
  public String findAll(Model model) {

    List<Board> list = boardSVC.findAll();
    model.addAttribute("list", list);

    return "forum/all";
  }

}
