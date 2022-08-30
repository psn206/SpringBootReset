package ru.netology.springbootreset.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.springbootreset.authorities.Authorities;
import ru.netology.springbootreset.exceptions.InvalidCredentials;
import ru.netology.springbootreset.exceptions.UnauthorizedUser;
import ru.netology.springbootreset.repository.UserRepository;

import java.util.List;



    @AllArgsConstructor
    @Service
    public class AuthorizationService {

        UserRepository userRepository;

        public List<Authorities> getAuthorities(String user, String password) {

            if (isEmpty(user) || isEmpty(password)) {
                throw new InvalidCredentials("user or password is empty");
            }
            List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
            if (isEmpty(userAuthorities)) {
                throw new UnauthorizedUser("unknown user" + user);
            }
            return userAuthorities;
        }

        private boolean isEmpty(String str) {
            return str == null || str.isEmpty();
        }

        private boolean isEmpty(List<?> str) {
            return str == null || str.isEmpty();
        }
    }