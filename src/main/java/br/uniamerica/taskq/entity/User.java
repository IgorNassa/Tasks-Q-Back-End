package br.uniamerica.taskq.entity;

import br.uniamerica.taskq.entity.enums.CargoEnum;
import br.uniamerica.taskq.entity.enums.UserEloEnum;
import br.uniamerica.taskq.entity.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String avatarUrl;

    private CargoEnum cargo;

    private UserStatusEnum status;

    private Long xp;

    private UserEloEnum elo;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;
}
