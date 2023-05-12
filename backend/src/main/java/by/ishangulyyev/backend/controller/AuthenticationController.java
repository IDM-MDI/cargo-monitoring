package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.AuthenticationRequest;
import by.ishangulyyev.backend.model.AuthenticationResponse;
import by.ishangulyyev.backend.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody @Valid AuthenticationRequest request) {
        return service.authenticate(request);
    }
}
