package tinderX.user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tinderX.user_service.dto.request.CreateUserRequest;
import tinderX.user_service.dto.request.UpdateUserRequest;
import tinderX.user_service.dto.UserDto;
import tinderX.user_service.dto.response.ApiResponse;
import tinderX.user_service.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/create")
    ResponseEntity<ApiResponse<UserDto>> createUser(@RequestBody CreateUserRequest request){
        UserDto dto = userService.createUser(request);
        return new ResponseEntity<>(ApiResponse.success(dto), HttpStatus.CREATED);
    }

    @GetMapping("/v1/get/{id}")
    ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable("id") Long id){
        UserDto dto = userService.getUserById(id);
        return new ResponseEntity<>(ApiResponse.success(dto), HttpStatus.OK);
    }

    @PatchMapping("/v1/update/{id}")
    ResponseEntity<ApiResponse<UserDto>> updateUserById(@PathVariable("id") Long id, @RequestBody UpdateUserRequest request){
        UserDto dto = userService.updateUserById(id, request);
        return new ResponseEntity<>(ApiResponse.success(dto), HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{id}")
    ResponseEntity<ApiResponse<String>> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(ApiResponse.success("User was deleted successfully"),HttpStatus.NO_CONTENT);
    }
}
