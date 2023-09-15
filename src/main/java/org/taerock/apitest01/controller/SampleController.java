package org.taerock.apitest01.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @Operation(summary = "SampleTest", description = "GET 방식 화면 테스트")
    @GetMapping("/doA")
    public List<String> doA(){
        return Arrays.asList("AAA", "BBB", "CCC");
    }


}
