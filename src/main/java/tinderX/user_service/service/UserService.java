package tinderX.user_service.service;

import org.springframework.stereotype.Service;
import tinderX.user_service.dto.request.CreateUserRequest;
import tinderX.user_service.dto.request.UpdateUserRequest;
import tinderX.user_service.dto.UserDto;

@Service
public interface UserService {
    UserDto createUser(CreateUserRequest request);
    UserDto getUserById(Long id);
    UserDto updateUserById(Long id, UpdateUserRequest request);
    void deleteUserById(Long id);
}
