package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Person;
import by.ishangulyyev.backend.model.PersonDTO;
import by.ishangulyyev.backend.repository.PersonRepository;
import by.ishangulyyev.backend.service.OriginService;
import by.ishangulyyev.backend.service.PersonService;
import by.ishangulyyev.backend.service.PublicDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final OriginService originService;
    private final PublicDataService publicDataService;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public Person save(@Valid PersonDTO person) {
        Person entity = mapper.map(person, Person.class);
        entity.setOrigin(originService.save(person.getOrigin()));
        entity.setPublicData(publicDataService.save(person.getPublicData()));
        return repository.save(entity);
    }
}
