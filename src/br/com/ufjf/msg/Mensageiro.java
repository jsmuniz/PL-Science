package br.com.ufjf.msg;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 *
 *
 */
public class Mensageiro {

    private static ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufjf.msg.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());

    public static void errorMsg(String msg) {
        msg = bundle.getString(msg);
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("ERRO", fm);

}

    public static void infoMsg(String msg) {
        msg = bundle.getString(msg);
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("INFO", fm);
    }
    
    
}
/*Agora criaremos um arquivo chamado â€œmessages.propertiesâ€� dentro da raiz da aplicaÃ§Ã£o, 
onde poderemos definir as mensagens da nossa aplicaÃ§Ã£o, bem como chaves para poder utiliza-las. 
O conteÃºdo desse arquivo consiste em:
chave = valor
Exemplo:
bdError = Erro ao acessar banco de dados!
Quando precisarmos utilizar nosso mensageiro, basta usar:

Mensageiro.errorMsg(â€œbdErrorâ€�);
E nossa classe irÃ¡ procurar dentro do messages.properties 
um valor que tenha como chave â€œbdErrorâ€œ, no nosso exemplo 
ele adicionaria a mensagem â€œErro ao acessar banco de dados!â€� ao nosso contexto.
Bem simples nÃ©?

Bom, agora iremos entender a nossa classe mensageira:
Primeiro nÃ³s temos o objeto estÃ¡tico ResourceBundle que utilizaremos para efetuar 
as buscas das mensagens atravÃ©s dos valores passado no arquivo messages.properties. 
Repare que eu passo o nome do arquivo sem a extensÃ£o .properties 
e a localizaÃ§Ã£o dele, no nosso caso utilizamos o mÃ©todo getViewRoot do FacesContext 
para obter a localizaÃ§Ã£o. O interessante Ã© que todas essas mensagens possuem 
suporte a internacionalizaÃ§Ã£o, vocÃª pode definir dentro do messages.properties 
mensagens personalizadas para cada locale, por isso utilizamos o mÃ©todo getLocale.
Os mÃ©todos: infoMsg e errorMsg sÃ£o os responsÃ¡veis pelas mensagens, 
recebem como parÃ¢metro uma string, que serÃ¡ utilizada como chave para encontrar o valor da mensagem.
Na linha seguinte ele faz com que a variÃ¡vel â€˜msgâ€˜ que antes possuÃ­a a chave receba 
como valor a prÃ³pria mensagem que Ã© buscada atravÃ©s do mÃ©todo getString do objeto ResourceBundle.
Nas prÃ³ximas linhas nÃ£o tem muito o que explicar, crio o objeto FacesMessage com a 
mensagem conseguida anteriormente, obtenho a instancia do FacesContext e adiciona a mensagem.
E fim, vocÃª estÃ¡ pronta p usar o seu mensageiro.
Espero que possa ajudar vocÃªs a tornar o desenvolvimento do seus sistemas menos repetitivo e mais divertido.

Quem quiser saber mais sobre jsf */