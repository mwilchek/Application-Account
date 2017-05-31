package Core; /**
 * Create Core.User Assignment; Core.Person Class
 * Attributes include: user name, email, phone number, password, profile photo
 * Resource - Picture Handling: http://javarevisited.blogspot.com/2011/12/read-write-image-in-java-example.html
 */

import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Person implements Comparable<User>{

    private String userName;
    private String email;
    private int phoneNum;
    private String password;
    private String picPath;
    private BufferedImage profilePic;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String email, int phoneNum, String password, String picPath, BufferedImage profilePic) {
        this.userName = userName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.picPath = picPath;
        this.profilePic = profilePic;
    }

    public User(String firstName, String lastName, int ssn, Date dob, String gender, String userName, String email, int phoneNum, String password, BufferedImage profilePic) {
        super(firstName, lastName, ssn, dob, gender);
        this.userName = userName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean equals(User user) {
        return(this.userName.equals(user.userName));
    }

    public String getEmail() {
        return email;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhone(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Validate Password: Must have 1 number, 1 upper case letter, 1 lower case
     * letter, 1 special character
     */
    public void validatePassword(String password) {
        this.password = password;
        boolean hasUpperLetter = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean strong = false;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (Character.isUpperCase(x)) {

                    hasUpperLetter = true;
                } else if (Character.isLowerCase(x)) {

                    hasLowerCase = true;
                } else if (Character.isDigit(x)) {

                    hasDigit = true;
                } else if (!matcher.matches()) {

                    hasSpecial = true;
                }

                // Password strong, break the loop
                if (hasUpperLetter && hasLowerCase && hasDigit && hasSpecial) {

                    strong = true;
                    break;
                }

            }
            if (strong) {
                System.out.println("PASSWORD IS STRONG");
            } else {
                System.out.println("PASSWORD IS NOT STRONG");
            }
        } else {
            System.out.println("Error: PASSWORD MUST BE AT LEAST 8 CHARACTERS");
        }
    }

    public String getPicPath() {
        return picPath;
    }

    public BufferedImage getProfilePic() {
        File imageFile = new File(picPath);
        try {
            profilePic = ImageIO.read(imageFile);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return profilePic;
    }

    @Override
    public int compareTo(User user) {
        return(this.userName.compareTo(user.userName));
    }

    @Override
    public String toString() {
        return "Core.User{" +
                "userName= '" + userName + '\'' +
                ", email= '" + email + '\'' +
                ", phone= '" + phoneNum + '\'' +
                ", password= '" + password + '\'' +
                ", photo= '" + profilePic + '\'' +
                '}';
    }

}


