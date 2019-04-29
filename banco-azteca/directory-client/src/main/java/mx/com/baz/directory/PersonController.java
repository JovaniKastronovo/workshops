package mx.com.baz.directory;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
public class PersonController {

    @GetMapping("/")
    public String personForm() {
        return "personForm";
    }

    RestTemplate restTemplate = new RestTemplate();


    @PostMapping(value = "/savePerson", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object savePerson(@ModelAttribute Person person,BindingResult result) {

        Object response = restTemplate.postForObject("http://localhost:8080/persons",person, Object.class);
        return response;
    }
}
