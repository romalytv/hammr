package proj.hammr.hammr.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserEntity user) {
        userRepository.save(user);
    }

    public UserEntity getById(Long id) {
        Optional<UserEntity> usersWithId = userRepository.findById(id);
        UserEntity user = null;

        if (usersWithId.isPresent())
            user = usersWithId.get();
        else
            throw new RuntimeException(
                "User not found. Id = " + id + ". Check UserService");

        return user;
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

}
