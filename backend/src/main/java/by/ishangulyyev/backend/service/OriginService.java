package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Origin;
import by.ishangulyyev.backend.model.OriginDTO;

public interface OriginService {
    Origin save(OriginDTO origin);
}
