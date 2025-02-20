package bong.service.collector.service;

import bong.service.collector.domain.User;
import bong.service.collector.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public Optional<User> findOne(String userId) {
        return userRepository.findByLoginId(userId);
    }
}
