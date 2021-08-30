package starter.login;

import org.openqa.selenium.By;

public class LoginForm {

    public static By EMAIL_FIELD = By.id("login-email");
    public static By PASSWORD_FIELD = By.id("login-password");
    public static By LOGIN_BUTTON = By.cssSelector("button[data-auto-id='login-form-login']");
}
