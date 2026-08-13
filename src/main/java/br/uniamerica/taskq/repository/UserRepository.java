package br.uniamerica.taskq.repository;

import br.uniamerica.taskq.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}