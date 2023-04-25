package by.ishangulyyev.backend.entity;

import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @OneToOne
    @JoinColumn(name = "authentication_id", nullable = false)
    @ToString.Exclude
    private Authentication authentication;

    @OneToOne
    @JoinColumn(name = "position_id", nullable = false)
    @ToString.Exclude
    private Position position;

    @OneToOne
    @JoinColumn(name = "client_person_id", nullable = false)
    @ToString.Exclude
    private Person person;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "start_work", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate startWork;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AcceptedCargo> acceptedCargos;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<DeclinedCargo> declinedCargos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pointcut_id", nullable = false)
    @ToString.Exclude
    private Pointcut pointcut;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && salary.equals(employee.salary) && startWork.equals(employee.startWork) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, startWork, status);
    }
}
