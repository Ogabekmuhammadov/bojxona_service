package com.example.demo.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
@Configuration
public class OpenAPIConfig {
    @Value("${server.url}")
    private String url;
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(url);
        devServer.setDescription("Server URL");


        Contact contact = new Contact();
        contact.setEmail("BojxonaServis");
        contact.setName("BojxonaServis");
        contact.setUrl("https://t.me/muhammadov_1");



        Info info = new Info()
                .title("BojxonaServis Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.")
                .termsOfService("https://t.me/muhammadov_1")
                .license(null);
        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
