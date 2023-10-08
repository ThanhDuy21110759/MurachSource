package murach.business;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String birth;
    private String heardFrom;
    private String wantsUpdates;
    private String wantsSendMail;
    private String contactVia;    

    public User() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHeardFrom() {
        return heardFrom;
    }

    public void setBirth(String birth) {
    	this.birth = birth;
    }
    public String getBirth() {
    	return birth;
    }
    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }

    public String getWantsUpdates() {
        return wantsUpdates;
    }

    public void setWantsUpdates(String wantsUpdates) {
        this.wantsUpdates = wantsUpdates;
    }

    public String getContactVia() {
        return contactVia;
    }

    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }   
    
    public void setWantsSendMail(String wantsSendMail) {
    	this.wantsSendMail = wantsSendMail;
    }
    public String getWantsSendMail(){
    	return wantsSendMail;
    }
}