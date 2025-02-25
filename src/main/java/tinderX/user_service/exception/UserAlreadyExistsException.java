package tinderX.user_service.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super(ErrorMessages.USER_ALREADY_EXISTS);
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
