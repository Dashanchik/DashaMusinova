package base.jdi.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    public static User PETER_CHAILOVSKII = new User("epam", "1234", "PETER_CHAILOVSKII");
    String login;
    String password;
    String fullName;

}
