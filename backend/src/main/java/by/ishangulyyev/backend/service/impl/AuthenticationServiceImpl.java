package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Authentication;
import by.ishangulyyev.backend.exception.EntityExistException;
import by.ishangulyyev.backend.exception.UserNotFoundException;
import by.ishangulyyev.backend.model.AuthenticationRequest;
import by.ishangulyyev.backend.model.AuthenticationResponse;
import by.ishangulyyev.backend.repository.AuthenticationRepository;
import by.ishangulyyev.backend.security.JwtService;
import by.ishangulyyev.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    @Override
    public Authentication registration(AuthenticationRequest request) {
        Authentication entity = mapper.map(request, Authentication.class);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        Optional<Authentication> byId = repository.findById(request.getLogin());
        if(byId.isPresent()) {
            throw new EntityExistException();
        }

        return repository.save(entity);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword())
        );
        Authentication authentication = repository.findById(request.getLogin())
                .orElseThrow(UserNotFoundException::new);
        AuthenticationResponse result = mapper.map(authentication, AuthenticationResponse.class);
        result.setToken(jwtService.generateToken(authentication));
        return result;
    }

    @Override
    public Authentication update(AuthenticationRequest authentication, String id) {
        Optional<Authentication> byId = repository.findById(id);
        if(byId.isEmpty()) {
            return registration(authentication);
        }
        Authentication entity = byId.get();
        entity.setPassword(passwordEncoder.encode(authentication.getPassword()));
        return repository.save(entity);
    }
}
