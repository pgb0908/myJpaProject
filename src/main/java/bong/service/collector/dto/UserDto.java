package bong.service.collector.dto;

import bong.service.collector.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String password;

    private String name;

}
