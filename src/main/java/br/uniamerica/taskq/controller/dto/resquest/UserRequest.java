    package br.uniamerica.taskq.controller.dto.resquest;

import br.uniamerica.taskq.entity.User;
import br.uniamerica.taskq.entity.enums.CargoEnum;
import br.uniamerica.taskq.entity.enums.UserEloEnum;
import br.uniamerica.taskq.entity.enums.UserStatusEnum;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;


public record UserRequest(
        @NotEmpty
        String name,

        @Email
        String email,

        @NotEmpty
        @Size(min = 6, max = 12)
        String password,

        @URL
        String avatarUrl,

        @NotNull
        CargoEnum cargo,

        @NotNull
        UserStatusEnum status,

        @NotNull
        @Positive
        Long xp,

        @NotNull
        UserEloEnum elo
) {

    public User toUser() {
        return new User(
                null,
                this.name,
                this.email,
                this.password,
                this.avatarUrl,
                this.cargo,
                this.status,
                this.xp,
                this.elo,
                null,
                null
        );
    }
}
