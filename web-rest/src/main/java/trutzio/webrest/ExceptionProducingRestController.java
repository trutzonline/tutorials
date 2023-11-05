package trutzio.webrest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ExceptionProducingRestController {

    @GetMapping("/error1")
    public void error1() {
        try {
            throw new IllegalStateException("This is an error!");
        } catch (IllegalStateException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This is an error!", exception);
        }
    }

    @GetMapping("/error2")
    public ResponseEntity<Object> error2() {
        try {
            throw new IllegalStateException("This is an error!");
        } catch (IllegalStateException exception) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", exception.getMessage());
            body.put("timestamp", LocalDateTime.now());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/error3")
    public String error3() {
        throw new IllegalStateException("This is an error!");
    }

    @GetMapping("/error4")
    public String error4() {
        throw new NullPointerException("This is an error!");
    }

    @ExceptionHandler(value = { IllegalStateException.class })
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("timestamp", LocalDateTime.now());
        body.put("exception", exception.getClass().getSimpleName());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
