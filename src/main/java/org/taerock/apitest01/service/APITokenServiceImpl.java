package org.taerock.apitest01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.taerock.apitest01.controller.APIUserController;
import org.taerock.apitest01.domain.APIUser;
import org.taerock.apitest01.dto.APITokenDTO;
import org.taerock.apitest01.dto.APIUserDTO;
import org.taerock.apitest01.repository.APIUserRepository;
import org.taerock.apitest01.util.JWTUtil;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class APITokenServiceImpl implements APITokenService{

    private final JWTUtil jwtUtil;

    private final APIUserRepository apiUserRepository;


    @Override
    public APITokenDTO makeTokens(String mid, String mpw) {

        Optional<APIUser> result =
                apiUserRepository.findAPIUserByMidAndMpw(mid, mpw);

        APIUser apiUser = result.orElseThrow(() -> new APIUserController.APIUserNotFoundException());

        Map<String, Object> claim = Map.of(mid, mpw);
        // Access Token 유효기간 10일
        String accessToken = jwtUtil.generateToken(claim, 10);
        // Refresh Token 유효기간 60일
        String refreshToken = jwtUtil.generateToken(claim, 60);

        APITokenDTO apiTokenDTO = APITokenDTO
                .builder()
                .access(accessToken)
                .refresh(refreshToken)
                .build();

        return apiTokenDTO;
    }
}
