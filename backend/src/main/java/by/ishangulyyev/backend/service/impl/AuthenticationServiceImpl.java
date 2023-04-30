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

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationRepository repository;
    private final ModelMapper mapper;
    @Override
    public Authentication registration(AuthenticationRequest request) {
        Authentication entity = mapper.map(request, Authentication.class);
        repository.findById(request.getLogin())
                .ifPresentOrElse(
                        data -> {
                            throw new EntityExistException();
                        },
                        () -> repository.save(entity));
        return entity;
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        return null;
    }
}
