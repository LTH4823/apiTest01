package org.taerock.apitest01.service;

import org.taerock.apitest01.dto.APITokenDTO;

public interface APITokenService {

    APITokenDTO makeTokens(String mid, String mpw);

}
