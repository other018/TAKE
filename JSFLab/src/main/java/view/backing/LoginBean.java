package view.backing;

import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    public LoginBean() {
    }

    public String login() {
        if (username.equals("scott") && password.equals("tiger")) {
            ResourceBundle rb = ResourceBundle.getBundle("ApplicationMessages");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("validation.oracle"), null);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
            return "index";
        }

        if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void activeButton(ValueChangeEvent e) {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }
}
