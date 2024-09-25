package com.bookmarker.api.controller;

import com.bookmarker.api.domain.Bookmark;
import com.bookmarker.api.dto.BookmarkDTO;
import com.bookmarker.api.dto.BookmarksDTO;
import com.bookmarker.api.dto.CreateBookmarkRequest;
import com.bookmarker.api.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;


    @GetMapping
    public BookmarksDTO<?> getBookmarks(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "query", defaultValue = "") String query) {

        if(query == null || query.isBlank()) { // isBlank() == .trim().isEmpty()
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }
    //@Valid 유형성 검사
    //// CreateBookmarkRequest 클래스에 정의된 유효성 제약조건(예: @NotNull, @Size, @Pattern 등)을 기반으로
    // 요청 데이터의 유효성을 검사합니다.
}
