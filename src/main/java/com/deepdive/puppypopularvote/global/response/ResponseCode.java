package com.deepdive.puppypopularvote.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    GET_PUPPY_LIST_SUCCESS(HttpStatus.OK, "강아지 전체 목록 조회 성공"),
    GET_PUPPY_DETAIL_SUCCESS(HttpStatus.OK, "강아지 상세 정보 조회 성공");

    private HttpStatus status;
    private final String message;
}
