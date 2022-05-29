package woowacourse.member.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import woowacourse.error.ErrorResponse;
import woowacourse.member.exception.InvalidMemberException;

@RestControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler(InvalidMemberException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMemberException(InvalidMemberException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }
}
