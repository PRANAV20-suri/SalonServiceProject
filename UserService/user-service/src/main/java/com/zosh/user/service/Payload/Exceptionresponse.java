package com.zosh.user.service.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exceptionresponse {

    private String message;
    private String error;
    private LocalDateTime localdateTime;

}
