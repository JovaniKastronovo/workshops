package mx.com.baz.directory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private String phone;
    private String email;
}
