package com.kh.borad.web.form.forum;

import lombok.Data;

@Data
public class UpdateForm {
  private Long boardId;
  private String bname;
  private String title;
  private String userContent;
}
