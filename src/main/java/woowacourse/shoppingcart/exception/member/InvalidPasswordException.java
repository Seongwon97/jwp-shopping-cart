package woowacourse.shoppingcart.exception.member;

public class InvalidPasswordException extends IllegalArgumentException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
