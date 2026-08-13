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
        @Max(12)
        @Min(6)
        String password,

        @URL
        String avatarUrl,

        @NotEmpty
        CargoEnum cargo,

        @NotEmpty
        UserStatusEnum status,

        @NotNull
        @Positive
        Long xp,

        @NotEmpty
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
