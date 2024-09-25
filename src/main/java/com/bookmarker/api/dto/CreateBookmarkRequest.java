package com.bookmarker.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {

    //@NotEmpty - 공백 허용 -> 공백만 있으면 empty가 아니다!
    //@NotBlank = trim() + @NotEmpty -> 공백을 허용하지 않는다!

    @NotBlank(message = "Title 은 필수 입력항목입니다!")
    private String title;
    
    @NotEmpty(message = "Url should not be empty")
    private String url;
}