package com.brumethon.app.expostion.user.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class GetUserDTO {
    @NotNull
    private UUID token;
}
