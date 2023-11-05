package trutzio.webrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionProducingRestController {

    @GetMapping("/error1")
    public void error() {
        throw new IllegalStateException("This is an error!");
    }

}
