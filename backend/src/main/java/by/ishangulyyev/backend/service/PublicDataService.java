package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.PublicData;
import by.ishangulyyev.backend.model.PublicDataDTO;

public interface PublicDataService {
    PublicData save(PublicDataDTO publicData);
}
