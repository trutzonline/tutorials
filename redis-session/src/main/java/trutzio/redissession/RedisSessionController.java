package trutzio.redissession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class RedisSessionController {

    @GetMapping("/http-session-id")
    public String index(HttpSession httpSession) {
        return httpSession.getId();
    }

}
