package trutzio.webrest;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/")
    public String root() {
        return "OK";
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(Optional<String> name,
            @RequestHeader(name = "User-Agent") String userAgent) {
        var user = name
                .map(n -> new User(UUID.randomUUID(), n))
                .orElse(new User(UUID.randomUUID(), userAgent));
        return ResponseEntity.status(201).body(user);
    }

}
