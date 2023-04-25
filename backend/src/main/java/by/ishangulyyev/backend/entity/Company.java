package by.ishangulyyev.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "companies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "name",unique = true, updatable = true, nullable = false)
    private String name;

    @Column(name = "origin_name",unique = true, updatable = true, nullable = false)
    private String originName;

    @ManyToOne
    @JoinColumn(name = "public_data_id", nullable = false)
    @ToString.Exclude
    private PublicData publicData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id.equals(company.id) && name.equals(company.name) && originName.equals(company.originName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originName);
    }
}
