package pl.sda.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sda.springproject.console.ConsoleInput;
import pl.sda.springproject.console.ConsoleOutput;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
    private String appName = "Moja aplikacja konsolowa w Spring!";
    private final ConsoleInput input;
    private final ConsoleOutput output;

    @Autowired
    public SpringProjectApplication(ConsoleInput input, ConsoleOutput output) {
        this.input = input;
        this.output = output;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println(appName);
        String name = input.getName();
        output.print(name);

//        String name = input.getName();
//        System.out.println("Hello " + name);
    }

    @Bean
    public String appName(){
        return "Nazwa aplikacji";
    }
}