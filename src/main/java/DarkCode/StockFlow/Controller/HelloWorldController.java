package DarkCode.StockFlow.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class HelloWorldController {

    @GetMapping()
    public String helloWorld(){
        System.out.println("Hello World");
        return "HelloWorldd";
    }

}
