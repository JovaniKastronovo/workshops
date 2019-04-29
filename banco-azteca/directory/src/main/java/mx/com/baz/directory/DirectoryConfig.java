package mx.com.baz.directory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectoryConfig {

    @Bean
    public ApplicationRunner init(PersonRepository repository){
        return args -> {
            repository.save(new Person("Dan","1-800","dan@email.com"));
            repository.save(new Person("Mark","1-800","mark@email.com"));
            repository.save(new Person("Mike","1-800","mike@email.com"));

        };
    }
}
