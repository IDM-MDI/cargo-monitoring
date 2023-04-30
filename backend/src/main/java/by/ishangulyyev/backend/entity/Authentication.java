package by.ishangulyyev.backend.entity;

import by.ishangulyyev.backend.entity.listener.AuthenticationEntityListener;
import by.ishangulyyev.backend.entity.type.AuthenticationRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "authentications")
@EntityListeners(AuthenticationEntityListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Authentication {
    @Id
    @Column(name = "login",unique = true, updatable = true, nullable = false)
    private String login;
    @Column(name = "password",unique = true, updatable = true, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private AuthenticationRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authentication that = (Authentication) o;
        return login.equals(that.login) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
