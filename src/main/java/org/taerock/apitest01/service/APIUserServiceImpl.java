package org.taerock.apitest01.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taerock.apitest01.domain.APIUser;
import org.taerock.apitest01.dto.APIUserDTO;
import org.taerock.apitest01.repository.APIUserRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class APIUserServiceImpl implements APIUserService{

    private final APIUserRepository apiUserRepository;
    private final ModelMapper modelMapper;


    @Override
    public Optional<APIUserDTO> checkUser(String mid, String mpw) {
        Optional<APIUser> result = apiUserRepository.findAPIUserByMidAndMpw(mid, mpw);
        if(result.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(modelMapper.map(result.get(), APIUserDTO.class));
    }
}
