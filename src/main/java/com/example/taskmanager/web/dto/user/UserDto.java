package com.example.taskmanager.web.dto.user;

import com.example.taskmanager.web.dto.validation.OnCreate;
import com.example.taskmanager.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "UserDTO")
public class UserDto {

    @Schema(description = "User id", example = "1")
    @NotNull(message = "Id must be not null.", groups = {OnUpdate.class})
    private Long id;

    @Schema(description = "User name", example = "Ivan")
    @NotNull(message = "Name must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @Schema(description = "User email", example = "ivanov@mail.ru")
    @NotNull(message = "Username must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String username;

    @Schema(description = "User crypted password", example = "$2a$10$E0Yz21hNwz/wIuzv8CCT2ezTsAQo67.TWBJitsPWhgwpzHJvNcWrG")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.", groups = {OnUpdate.class, OnCreate.class})
    private String password;

    @Schema(description = "User password confirmation", example = "$2a$10$E0Yz21hNwz/wIuzv8CCT2ezTsAQo67.TWBJitsPWhgwpzHJvNcWrG")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null.", groups = {OnCreate.class})
    private String passwordConfirmation;

}
