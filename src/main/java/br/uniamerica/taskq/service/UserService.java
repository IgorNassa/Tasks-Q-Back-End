package br.uniamerica.taskq.service;

import br.uniamerica.taskq.controller.dto.response.UserResponse;
import br.uniamerica.taskq.controller.dto.resquest.UserRequest;
import br.uniamerica.taskq.entity.User;
import br.uniamerica.taskq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserRequest userRequest){
        return userRepository.save(userRequest.toUser());
    }

    public List<UserResponse> findAll(){

        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    public UserResponse update(Long id, UserRequest atualizado){
        userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


         var user = atualizado.toUser();
         user.setId(id);

         var userAtualizado = userRepository.save(user);

        return UserResponse.from(userAtualizado);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não existe"));

        userRepository.delete(user);
    }
}
