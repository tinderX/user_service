package tinderX.user_service.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tinderX.user_service.dto.request.CreateUserRequest;
import tinderX.user_service.dto.request.UpdateUserRequest;
import tinderX.user_service.entity.User;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        modelMapper.addMappings(new PropertyMap<CreateUserRequest, User>() {
//            @Override
//            protected void configure(){
//                map(source.getPassword(), destination.getPassword());
//            }
//        });
//
//        modelMapper.addMappings(new PropertyMap<UpdateUserRequest, User>() {
//            @Override
//            protected void configure(){
//                if (source.getPassword() != null) {
//                    map(source.getPassword(), destination.getPassword());
//                }
//            }
//        });

        return modelMapper;
    }
}