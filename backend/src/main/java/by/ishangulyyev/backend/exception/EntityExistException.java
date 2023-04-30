package by.ishangulyyev.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "Current entity is exist")
public class EntityExistException extends RuntimeException {
}
