package classes;

import exceptions.MyException;

public class Admin {
    private String email;
    private String porol;

    public Admin(String email, String porol) {
        this.email = email;
        this.porol = porol;
    }
    public Admin(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws MyException {
        if (!email.equals("kanykei@")) {
            throw new MyException("Туура эмес!!!");
        } else {
            this.email = email;
        }
    }

    public String getPorol() {
        return porol;
    }

    public void setPorol(String porol) throws MyException {
        if (!porol.equals("kanykei.06")) {
            throw new MyException("Туура эмес!!!");
        } else {
            this.porol = porol;
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                "email='" + email + '\'' +
                ", porol='" + porol + '\'' +
                '}';
    }
}
