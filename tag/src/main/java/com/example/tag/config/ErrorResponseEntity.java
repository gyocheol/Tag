package com.example.tag.config;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Data
@Builder
public class ErrorResponseEntity {

    private String code;
    private String message;

    /**
     * Validation Exception Response 생성
     * Validation 을 통과하지 못한 첫 번째 field에 대해서만 에러 코드 반환
     *
     * @param e
     * @return Validation Exception Response
     */
    public static ResponseEntity<ErrorResponseEntity> toResponseEntity(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        FieldError fieldError = fieldErrors.get(fieldErrors.size()-1);  // 가장 첫 번째 에러 필드
        String fieldName = fieldError.getField();   // 필드명
        Object rejectedValue = fieldError.getRejectedValue();   // 입력값

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseEntity.builder()
                        // 에러 코드 in 에러 코드 명세서
                        .code(fieldError.getDefaultMessage())
                        .message(fieldName + " 필드의 입력값[ " + rejectedValue + " ]이 유효하지 않습니다.")
                        .build());
    }

    /**
     * Request Body가 요구되지만 아무 것도 보내지 않은 경우
     *
     * @param e
     * @return
     */
    public static ResponseEntity<ErrorResponseEntity> toResponseEntity(HttpMessageNotReadableException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseEntity.builder()
                        .code("39")
                        .message("Request Body 가 누락되었습니다.")
                        .build());
    }
}
