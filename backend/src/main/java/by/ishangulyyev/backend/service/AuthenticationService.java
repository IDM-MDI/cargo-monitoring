package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Authentication;
import by.ishangulyyev.backend.model.AuthenticationRequest;
import by.ishangulyyev.backend.model.AuthenticationResponse;

public interface AuthenticationService {
    Authentication registration(AuthenticationRequest request);
    AuthenticationResponse authentication(AuthenticationRequest request);
}
