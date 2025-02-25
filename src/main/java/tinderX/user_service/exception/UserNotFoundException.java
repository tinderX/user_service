package tinderX.user_service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super(ErrorMessages.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
