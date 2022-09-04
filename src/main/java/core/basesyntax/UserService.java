package core.basesyntax;

public class UserService {
    public void registerUser(User user) {
        PasswordValidator passwordValidator = new PasswordValidator();
        if (user.getPassword().trim() != "" || user.getRepeatPassword().trim() != "") {
            try {
                passwordValidator.validate(user.getPassword(), user.getRepeatPassword());
                saveUser(user);
            } catch (PasswordValidationException e) {
                System.out.println("Your passwords are incorrect. Try again" + e);
            }
        } else {
            System.out.println("Your passwords are incorrect. Try again");
        }
    }

    public void saveUser(User user) {
        System.out.println("User " + user.toString() + " was saved to database!!!");
    }
}
