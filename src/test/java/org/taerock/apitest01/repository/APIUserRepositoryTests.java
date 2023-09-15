package org.taerock.apitest01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.taerock.apitest01.domain.APIUser;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class APIUserRepositoryTests {

    @Autowired
    APIUserRepository apiUserRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i-> {
            APIUser apiUser = APIUser.builder()
                    .mid("apiuser"+i)
                    .mpw("1111")
                    .build();
            apiUserRepository.save(apiUser);
        });
    }


}
