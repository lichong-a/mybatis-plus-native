package work.lichong.test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@Slf4j
@SpringBootApplication
@MapperScan({"work.lichong.test"})
@OpenAPIDefinition(
        info = @Info(title = "MybatisPlusNative",
                version = "dev",
                description = "MybatisPlusNative API文档",
                contact = @Contact(name = "LiChong", url = "https://lichong.work", email = "mail@lichong.host"),
                license = @License(name = "", url = "")))
public class MybatisPlusNativeApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(MybatisPlusNativeApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        String infoMessage = "\n----------------------------------------------------------\n" +
                "Application LogInspectApplication is running! Access URLs:\n" +
                "Local: \t\t\thttp://localhost:" + port + path + "\n" +
                "External: \t\thttp://" + ip + ":" + port + path + "\n";
        boolean swaggerEnabled = "true".equals(env.getProperty("springdoc.swagger-ui.enabled"));
        if (swaggerEnabled) {
            String swaggerPath = Objects.requireNonNull(env.getProperty("springdoc.swagger-ui.path")).substring(1);
            infoMessage += "Swagger文档: \thttp://" + ip + ":" + port + path + swaggerPath + "\n" +
                    "----------------------------------------------------------";
        } else {
            infoMessage += "----------------------------------------------------------";
        }
        log.info(infoMessage);
    }

}
