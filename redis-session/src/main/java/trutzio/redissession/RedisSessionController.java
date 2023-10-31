package trutzio.redissession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class RedisSessionController {

    @GetMapping("/")
    public String index(HttpSession httpSession) {
        httpSession.setAttribute("test", "Christian");
        return httpSession.getId();
    }

}
