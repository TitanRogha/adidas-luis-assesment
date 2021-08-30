package starter.dashboard;

import org.openqa.selenium.By;

public class Account {

    public static By PEDIDOS = By.cssSelector("li[title='Pedidos']>a>div>span:first-child");
    public static By PREFERENCIAS = By.cssSelector("li[title='Preferencias']>a>div>span:first-child");
    public static By DATOS_PERSONALES = By.cssSelector("li[title='Datos personales']>a>div>span:first-child");
    public static By AGENDA_DIRECCIONES = By.cssSelector("li[title='Agenda de direcciones']>a>div>span:first-child");
}
