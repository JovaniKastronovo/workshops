package mx.com.baz.directory;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
public class InfoController {

    DataSource dataSource;

    @GetMapping("/info")
    public Map<String,String> info() throws SQLException {
        Map<String,String> map = new HashMap<>();
        map.put("jdbc-url",dataSource.getConnection().getMetaData().getURL());
        map.put("instance",System.getenv("CF_INSTANCE_INDEX"));
        return map;
    }

    @GetMapping("/kill")
    @ResponseStatus(HttpStatus.OK)
    public void exit(){
        System.exit(-1);
    }
}


/*
@RestController
public class InfoController {

    private DataSource dataSource;

    @Autowired
    public InfoController(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @GetMapping("/info")
    public Map<String,String> info() throws SQLException {
        Map<String,String> map = new HashMap<>();
        map.put("jdbc-url",dataSource.getConnection().getMetaData().getURL());
        map.put("instance",System.getenv("CF_INSTANCE_INDEX"));
        return map;
    }
}
*/