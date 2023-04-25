package by.ishangulyyev.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "pointcuts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pointcut {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "order",unique = true, updatable = true, nullable = false)
    private Long order;

    @Column(name = "name",unique = true, updatable = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "pointcut")
    @ToString.Exclude
    private Employee employee;

    @OneToMany(mappedBy = "pointcut", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Cargo> cargos;
}
