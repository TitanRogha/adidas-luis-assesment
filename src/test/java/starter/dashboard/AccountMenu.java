package starter.dashboard;


import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class AccountMenu {

    public static Question<String> orders(){
        return actor -> TextContent.of(Account.PEDIDOS).viewedBy(actor).asString();
    }
    public static Question<String> preferences(){
        return actor -> TextContent.of(Account.PREFERENCIAS).viewedBy(actor).asString();
    }
    public static Question<String> personalData(){
        return actor -> TextContent.of(Account.DATOS_PERSONALES).viewedBy(actor).asString();
    }
    public static Question<String> addressBook(){
        return actor -> TextContent.of(Account.AGENDA_DIRECCIONES).viewedBy(actor).asString();
    }


}
