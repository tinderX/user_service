package tinderX.user_service.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tinderX.user_service.dto.request.CreateUserRequest;
import tinderX.user_service.dto.request.UpdateUserRequest;
import tinderX.user_service.dto.UserDto;
import tinderX.user_service.entity.User;
import tinderX.user_service.exception.UserAlreadyExistsException;
import tinderX.user_service.exception.UserNotFoundException;
import tinderX.user_service.repository.UserRepository;
import tinderX.user_service.service.UserService;
import tinderX.user_service.utils.PasswordEncoderUtil;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(CreateUserRequest request) {
        if(userRepository.existsByUsername(request.getUsername())){
            throw new UserAlreadyExistsException();
        }

        String encodedPassword = PasswordEncoderUtil.encodePassword(request.getPassword());
        request.setPassword(encodedPassword);

        User user = modelMapper.map(request, User.class);

        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUserById(Long id, UpdateUserRequest request) {
        User existingUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        if(request.getPassword() != null && !request.getPassword().isEmpty()){
            String encodedPassword = PasswordEncoderUtil.encodePassword(request.getPassword());
            request.setPassword(encodedPassword);
        }
        modelMapper.map(request, existingUser);

        userRepository.save(existingUser);

        return modelMapper.map(existingUser, UserDto.class);
    }

    @Override
    public void deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else {
            throw new UserNotFoundException();
        }
    }
}
