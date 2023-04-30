package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Authentication;
import by.ishangulyyev.backend.exception.EntityExistException;
import by.ishangulyyev.backend.model.AuthenticationRequest;
import by.ishangulyyev.backend.model.AuthenticationResponse;
import by.ishangulyyev.backend.repository.AuthenticationRepository;
import by.ishangulyyev.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationRepository repository;
    private final ModelMapper mapper;
    @Override
    public Authentication registration(AuthenticationRequest request) {
        Authentication entity = mapper.map(request, Authentication.class);
        Optional<Authentication> byId = repository.findById(request.getLogin());
        if(byId.isPresent()) {
            throw new EntityExistException();
        }
        return repository.save(entity);
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        return null;
    }
}