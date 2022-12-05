package andrey.rest;

import andrey.rest.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }


}
