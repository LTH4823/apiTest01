package org.taerock.apitest01.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Objects;

@SpringBootTest
@Log4j2
public class JWTUtilTests {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerateToken(){

        Map<String, Object> claimMap = Map.of("mid", "ABCDE");

        String jwtStr = jwtUtil.generateToken(claimMap, 1);

        log.info(jwtStr);
    }

    @Test
    public void testValidate(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTQ4NDgzMDcsIm1pZCI6IkFCQ0RFIiwiaWF0IjoxNjk0NzYxOTA3fQ.lPxcXObvVDleCdjYaTGYZcdH5f1A0CMP9ZTlrnVstQQ";

        jwtUtil.validateToken(token);

    }

}
