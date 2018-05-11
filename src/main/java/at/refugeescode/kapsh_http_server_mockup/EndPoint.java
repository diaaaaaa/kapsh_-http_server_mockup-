package at.refugeescode.kapsh_http_server_mockup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EndPoint {

    @GetMapping
    public String get(){

        return"hi first";
    }


}
