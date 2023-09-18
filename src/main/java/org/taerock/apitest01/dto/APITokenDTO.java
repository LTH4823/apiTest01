package org.taerock.apitest01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APITokenDTO {

    private String mdi;
    private String access;
    private String refresh;

}
