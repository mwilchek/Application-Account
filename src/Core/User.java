package Core; /**
 * Create Core.User Assignment; Core.Person Class
 * Attributes include: user name, email, phone number, password, profile photo
 */

import java.io.Serializable;

public class User extends Person implements Serializable {
    private String userName;
    private String email;
    private String phone;
    private String password;
    private String profilePic;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String email, String phone, String password, String profilePic) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profilePic = profilePic;
    }

    public User(String firstName, String lastName, String dob, String gender, String userName, String email, String phone, String password, String profilePic) {
        super(firstName, lastName, dob, gender);
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return profilePic;
    }

    public void setPhoto(String photo) {
        this.profilePic = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + profilePic + '\'' +
                '}';
    }

}


