package org.taerock.apitest01.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.taerock.apitest01.dto.APIUserDTO;
import org.taerock.apitest01.service.APIUserService;

import java.util.Map;
import java.util.Optional;

@RestController
@Log4j2
@RequiredArgsConstructor
@Tag(name = "APIUserTest", description = "APIUserTest 입니다.")
public class APIUserController {

    private final APIUserService apiUserService;


    @Operation(summary = "Generate Token with POST", description = "POST 방식 토큰 생성 테스트")
    @PostMapping("/generateToken")
    public Map<String, String> generateToken(@RequestBody APIUserDTO apiUserDTO){


        log.info("========================================");
        log.info("========================================");
        log.info(apiUserDTO);
        log.info("========================================");
        log.info("========================================");

        Optional<APIUserDTO> result = apiUserService.checkUser(apiUserDTO.getMid(), apiUserDTO.getMpw());

        log.info("========================================");
        log.info("========================================");
        log.info(result);
        log.info("========================================");
        log.info("========================================");


        // 중첩클래스
        if(result.isEmpty()){
            throw new APIUserNotFoundException();
        }

        return Map.of("ACCESS","1111", "REFRESH", "2222");
    }

    // 중첩 클래스
    public static class APIUserNotFoundException extends  RuntimeException{

    }

}
