package tinderX.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class ApiResponse<T>{
    private String status;
    private T data;
    private String message;

    public static <T> ApiResponse<T> success(T data){
            return new ApiResponse<>("success", data,null);
    }

    public static <T> ApiResponse<T> success(T data, String message){
        return new ApiResponse<>("success", data, message);
    }

    public static <T> ApiResponse<T> error(String message){
        return new ApiResponse<>("error", null, message);
    }
}
