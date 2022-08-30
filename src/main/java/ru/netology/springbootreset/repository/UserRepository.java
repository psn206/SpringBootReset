package ru.netology.springbootreset.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootreset.authorities.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    public List getUserAuthorities(String user, String password) {

        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("qwerty")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Nana") && password.equals("12")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else {
            return Collections.EMPTY_LIST;
        }

        return authorities;
    }
}