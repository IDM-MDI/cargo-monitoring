package by.ishangulyyev.backend.config;

import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.Employee;
import by.ishangulyyev.backend.entity.Origin;
import by.ishangulyyev.backend.entity.Pointcut;
import by.ishangulyyev.backend.model.CargoPage;
import by.ishangulyyev.backend.model.EmployeeDTO;
import by.ishangulyyev.backend.model.EmployeePage;
import by.ishangulyyev.backend.model.OriginDTO;
import by.ishangulyyev.backend.model.PointcutDTO;
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
                .addMappings(mapping -> mapping.map(source -> source.getPosition().getName(),EmployeeDTO::setPosition));

        modelMapper.createTypeMap(Employee.class, EmployeePage.class)
                .addMappings(mapping -> mapping.map(source -> source.getPerson().getName(),EmployeePage::setName))
                .addMappings(mapping -> mapping.map(source -> source.getPerson().getSurname(),EmployeePage::setSurname))
                .addMappings(mapping -> mapping.map(source -> source.getPosition().getName(),EmployeePage::setPosition));

        modelMapper.createTypeMap(Pointcut.class, PointcutDTO.class)
                        .addMappings(mapping -> mapping.map(source -> source.getEmployee().getAuthentication().getLogin(), PointcutDTO::setLogin));

        modelMapper.createTypeMap(Cargo.class, CargoPage.class)
                .setConverter(context -> {
                    Cargo source = context.getSource();
                    return CargoPage.builder()
                            .id(source.getId())
                            .country(source.getPerson().getOrigin().getCountry().getName())
                            .client(source.getPerson().getName() + " " + source.getPerson().getSurname())
                            .type(source.getType())
                            .status(source.getStatus())
                            .build();
                });
        return modelMapper;
    }
}
