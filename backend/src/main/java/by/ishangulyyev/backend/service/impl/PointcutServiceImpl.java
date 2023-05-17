package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Pointcut;
import by.ishangulyyev.backend.exception.EntityNotFoundException;
import by.ishangulyyev.backend.model.PointcutDTO;
import by.ishangulyyev.backend.repository.PointcutRepository;
import by.ishangulyyev.backend.service.EmployeeService;
import by.ishangulyyev.backend.service.PointcutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static by.ishangulyyev.backend.util.PointcutUtil.findSpaceNumber;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointcutServiceImpl implements PointcutService {
    private final PointcutRepository repository;
    private final EmployeeService employeeService;
    private final ModelMapper mapper;
    @Override
    public Pointcut findMinimumOrder() {
        return repository.findFirstByOrderByNumberAsc()
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<PointcutDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(pointcut -> mapper.map(pointcut, PointcutDTO.class));
    }

    @Override
    @Transactional
    public PointcutDTO save(PointcutDTO pointcut) {
        changeExistedOrder(pointcut.getNumber());
        nullExistedEmployee(pointcut.getLogin());
        return mapper.map(savePointcut(pointcut), PointcutDTO.class);
    }

    @Override
    @Transactional
    public void delete(String id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

    @Override
    public Optional<Pointcut> findNext(@Valid Pointcut pointcut) {
        return repository.findFirstByNumberGreaterThan(pointcut.getNumber());
    }

    @Override
    @Transactional
    public PointcutDTO patchLogin(String id, String login) {
        Pointcut pointcut = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        nullExistedEmployee(login);
        pointcut.setEmployee(
                        employeeService.findByLoginEntity(login)
                                .orElseThrow(EntityNotFoundException::new)
                );
        return mapper.map(repository.save(pointcut), PointcutDTO.class);
    }

    private Pointcut savePointcut(PointcutDTO pointcut) {
        Pointcut entity = mapper.map(pointcut, Pointcut.class);
        entity.setEmployee(
                employeeService.findByLoginEntity(pointcut.getLogin())
                        .orElseThrow(EntityNotFoundException::new)
        );
        return repository.save(entity);
    }

    private Long findOrder() {
        return repository.findFirstByOrderByNumberDesc()
                .map(pointcut -> findFreeOrder()
                .orElseGet(() -> pointcut.getNumber() + 1))
                .orElse(1L);
    }

    private Optional<Long> findFreeOrder() {
        return findSpaceNumber(repository.findAllNumbers());
    }


    private void changeExistedOrder(Long order) {
        Optional<Pointcut> byNumber = repository.findByNumber(order);
        if(byNumber.isPresent()) {
            Pointcut entityByNumber = byNumber.get();
            entityByNumber.setNumber(findOrder());
            repository.save(entityByNumber);
        }
    }

    private void nullExistedEmployee(String login) {
        Optional<Pointcut> byLogin = repository.findByEmployee_Authentication_Login(login);
        if(byLogin.isPresent()) {
            Pointcut entityByLogin = byLogin.get();
            entityByLogin.setEmployee(null);
            repository.save(entityByLogin);
        }
    }
}
