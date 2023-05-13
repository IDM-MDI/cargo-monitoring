package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Cargo;

public interface AcceptedCargoService {
    void accept(Cargo cargo, String login);
}
