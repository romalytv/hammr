package proj.hammr.hammr.User;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {


    // stub for adding users
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();

        user1.setName("Abba");
        user1.setPassword("1234");

        user2.setName("Boba");
        user2.setPassword("qwer");

        userRepository.saveAll(List.of(user1, user2));

        };
    }
}
