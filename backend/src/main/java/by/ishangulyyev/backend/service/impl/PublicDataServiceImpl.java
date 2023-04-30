package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.PublicData;
import by.ishangulyyev.backend.exception.EntityExistException;
import by.ishangulyyev.backend.model.PublicDataDTO;
import by.ishangulyyev.backend.repository.PublicDataRepository;
import by.ishangulyyev.backend.service.PublicDataService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublicDataServiceImpl implements PublicDataService {
    private final PublicDataRepository repository;
    private final ModelMapper mapper;

    @Override
    public PublicData save(PublicDataDTO publicData) {
        PublicData entity = mapper.map(publicData, PublicData.class);
        Optional<PublicData> byId = repository.findById(publicData.getEmail());
        if(byId.isPresent()) {
            throw new EntityExistException();
        }
        return repository.save(entity);
    }
}
