package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.PublicData;
import by.ishangulyyev.backend.exception.EntityExistException;
import by.ishangulyyev.backend.model.PublicDataDTO;
import by.ishangulyyev.backend.repository.PublicDataRepository;
import by.ishangulyyev.backend.service.PublicDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PublicDataServiceImpl implements PublicDataService {
    private final PublicDataRepository repository;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public PublicData save(@Valid PublicDataDTO publicData) {
        PublicData entity = mapper.map(publicData, PublicData.class);
        Optional<PublicData> byId = repository.findById(publicData.getEmail());
        if(byId.isPresent()) {
            throw new EntityExistException();
        }
        return repository.save(entity);
    }

    @Override
    @Transactional
    public PublicData update(@Valid PublicDataDTO publicData, String email) {
        Optional<PublicData> byId = repository.findById(email);
        if(byId.isEmpty()) {
            return save(publicData);
        }
        PublicData entity = byId.get();
        entity.setPhone(publicData.getPhone());
        return repository.save(entity);
    }
}
