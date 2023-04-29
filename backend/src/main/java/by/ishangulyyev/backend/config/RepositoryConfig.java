package by.ishangulyyev.backend.config;

import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.Employee;
import by.ishangulyyev.backend.entity.Origin;
import by.ishangulyyev.backend.model.CargoPage;
import by.ishangulyyev.backend.model.EmployeeDTO;
import by.ishangulyyev.backend.model.EmployeePage;
import by.ishangulyyev.backend.model.OriginDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "by.ishangulyyev.backend")
@EnableJpaRepositories(basePackages = "by.ishangulyyev.backend")
@EnableJpaAuditing
@RequiredArgsConstructor
public class RepositoryConfig {

    @Bean
    public ModelMapper mapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Origin.class, OriginDTO.class)
                .addMappings(mapping -> mapping.map(source -> source.getCountry().getName(),OriginDTO::setCountry))
                .addMappings(mapping -> mapping.map(source -> source.getCity().getName(), OriginDTO::setCity));
        modelMapper.createTypeMap(Employee.class, EmployeeDTO.class)
                .addMappings(mapping -> mapping.map(source -> source.getAuthentication().getLogin(),EmployeeDTO::setLogin));
        modelMapper.createTypeMap(Employee.class, EmployeePage.class)
                .addMappings(mapping -> mapping.map(source -> source.getPerson().getName(),EmployeePage::setName))
                .addMappings(mapping -> mapping.map(source -> source.getPerson().getSurname(),EmployeePage::setSurname));
        modelMapper.createTypeMap(Cargo.class, CargoPage.class)
                .addMappings(mapping -> mapping.map(source -> source.getPerson().getName() + source.getPerson().getSurname(),CargoPage::setClient))
                .addMappings(mapping -> mapping.map(source -> source.getPerson().getOrigin().getCountry().getName(),CargoPage::setCountry));
        return modelMapper;
    }
}