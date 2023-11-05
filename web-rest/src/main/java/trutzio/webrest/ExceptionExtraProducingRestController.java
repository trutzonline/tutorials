package trutzio.webrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionExtraProducingRestController {

    @GetMapping("/error5")
    public void error5() {
        throw new IllegalStateException("This is an error!");
    }

}
