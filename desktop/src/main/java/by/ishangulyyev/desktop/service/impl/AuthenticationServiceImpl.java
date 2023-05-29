package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.service.AuthenticationService;
import javafx.event.ActionEvent;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String AUTHENTICATION_URL = "/api/v1/user/login";
    private final RestApi<Authentication> restApi;

    public AuthenticationServiceImpl() {
        restApi = new RestApi<>();
    }

    @Override
    public void submit(ActionEvent event, String login, String password) {
        Authentication authentication = AuthenticationService.getAuthentication(login, password);
        Authentication result = restApi.post(AUTHENTICATION_URL, authentication, Authentication.class);
        AuthenticationService.adminChecker(result.getRole());
        AuthenticationService.save(result);
        AuthenticationService.switchAfterAuthenticate(event);
    }
}
