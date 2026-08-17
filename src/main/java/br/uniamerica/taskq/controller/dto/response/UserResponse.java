package br.uniamerica.taskq.controller.dto.response;

import br.uniamerica.taskq.entity.User;
import br.uniamerica.taskq.entity.enums.CargoEnum;
import br.uniamerica.taskq.entity.enums.UserEloEnum;
import br.uniamerica.taskq.entity.enums.UserStatusEnum;
import jakarta.validation.constraints.*;


public record UserResponse (

        String name,
        String email,
        String password,
        String avatarUrl,
        CargoEnum cargo,
        UserStatusEnum status,
        Long xp,
        UserEloEnum elo
){
    public static UserResponse from(User user) {
        return new UserResponse(user.getName(), user.getEmail(),user.getPassword(), user.getAvatarUrl(), user.getCargo()
        ,user.getStatus(),user.getXp(),user.getElo());
    }
}
