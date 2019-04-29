package mx.com.baz.directory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class PersonController {

    @Value("${directory.url}")
    String directoryUrl;

    @GetMapping("/")
    public String personForm() {
        return "personForm";
    }

    RestTemplate restTemplate = new RestTemplate();


    @PostMapping(value = "/savePerson", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object savePerson(@ModelAttribute Person person) {

        Object response = restTemplate.postForObject(directoryUrl,person, Object.class);
        return response;
    }
}
