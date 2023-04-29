package by.ishangulyyev.backend.entity;

import by.ishangulyyev.backend.entity.type.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "persons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "origin_id", nullable = false)
    @ToString.Exclude
    private Origin origin;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "public_data_email", nullable = false)
    @ToString.Exclude
    private PublicData publicData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && name.equals(person.name) && surname.equals(person.surname) && lastname.equals(person.lastname) && birthday.equals(person.birthday) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, lastname, birthday, gender);
    }
}
