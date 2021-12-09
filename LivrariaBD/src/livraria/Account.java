package livraria;

public class Account {
    private String emailAddress;
    private long id;
    private String password;
    
    private long idTemp;
    private String passwordTemp;
    

    //Métodos de Operação
    public boolean verifyPassword(){
        return password.equals(passwordTemp);
    }
    
    public boolean validateLogin(){
        return (id==idTemp);
    }
    
    public boolean validateLogin(long ID, String password){
        idTemp=id;
        passwordTemp=password;
        return (validateLogin() && verifyPassword());
    }
    
    
    //Métodos Acessores
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
