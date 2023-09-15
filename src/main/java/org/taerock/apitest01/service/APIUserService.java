package org.taerock.apitest01.service;

import org.taerock.apitest01.dto.APIUserDTO;

import java.util.Optional;

public interface APIUserService {
    Optional<APIUserDTO> checkUser(String mid, String mpw);
}
