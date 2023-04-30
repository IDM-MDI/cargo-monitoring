package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Person;
import by.ishangulyyev.backend.model.PersonDTO;

public interface PersonService {
    Person save(PersonDTO person);
}
