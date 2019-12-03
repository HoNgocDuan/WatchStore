package watch.store.mnm.dto;

import org.apache.tomcat.util.codec.binary.Base64;
import watch.store.mnm.domain.User;
import watch.store.mnm.exception.MessageException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
import java.util.Set;

public class UserDTO {
    @NotBlank(message = MessageException.USERNAME_NULL)
    @Size(min = 4, message = MessageException.USERNAME_MIN)
    private String username;
    private String firstname;
    private String lastname;
    private String address;

    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = MessageException.FORMAT_PHONE_NUMBER)
    private String phoneNumber;
    private String imageBase64;
    private String roleNameVietNamese;

    @Pattern(regexp = "((http|https)://)?(www[.])?facebook.com/.+", message = MessageException.FORMAT_FACEBOOK_URL)
    private String facebookUrl;
    private String description;
    private long numberUserOfSystem = 0;
    private String interests;
    private String occupation;
    private String email;
    private boolean active;
    private String roleName;

    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleNameVietNamese(String nameRole) {
        if (nameRole.equals(ROLE_ADMIN)) {
            this.roleNameVietNamese = ROLE_ADMIN_VIETNAMESE;

        }
        if (nameRole.equals(ROLE_ACCOUNTANT)) {
            this.roleNameVietNamese = ROLE_ACCOUNTANT_VIETNAMESE;

        }
        if (nameRole.equals(ROLE_CASHIER)) {
            this.roleNameVietNamese = ROLE_CASHIER_VIETNAMESE;

        }
        if (nameRole.equals(ROLE_EMPLOYEE)) {
            this.roleNameVietNamese = ROLE_EMPLOYEE_VIETNAMESE;

        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private int gender;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.address = user.getAddress();
        this.description = user.getDescription();
        this.phoneNumber = user.getPhoneNumber();
        this.facebookUrl = user.getFaceBookUrl();
        this.interests = user.getInterests();
        this.occupation = user.getOccupation();
        this.description = user.getDescription();
        this.imageBase64 = Base64.encodeBase64String(user.getImage());
        this.email = user.getEmail();
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    private List<TimeUserLoggedDTO> timeUserLoggeds;

    public List<TimeUserLoggedDTO> getTimeUserLoggeds() {
        return timeUserLoggeds;
    }

    public void setTimeUserLoggeds(List<TimeUserLoggedDTO> timeUserLoggeds) {
        this.timeUserLoggeds = timeUserLoggeds;
    }

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
    private static final String ROLE_ACCOUNTANT = "ROLE_ACCOUNTANT";
    private static final String ROLE_CASHIER = "ROLE_CASHIER";

    private static final String ROLE_ADMIN_VIETNAMESE = "Quản Trị Viên";
    private static final String ROLE_EMPLOYEE_VIETNAMESE = "Nhân Viên";
    private static final String ROLE_ACCOUNTANT_VIETNAMESE = "Kế Toán";
    private static final String ROLE_CASHIER_VIETNAMESE = "Thu Ngân";

    public String getRoleNameVietNamese() {
        return roleNameVietNamese;
    }

    public void setRoleNameVietNamese(Set<String> listRole) {
        int numberRole = listRole.size();
        if (numberRole == 4) {
            this.roleNameVietNamese = ROLE_ADMIN_VIETNAMESE;
            return;
        }
        for (String nameRole : listRole) {
            if (nameRole.equals(ROLE_ADMIN)) {
                this.roleNameVietNamese = ROLE_ADMIN_VIETNAMESE;
                break;
            }
            if (nameRole.equals(ROLE_ACCOUNTANT)) {
                this.roleNameVietNamese = ROLE_ACCOUNTANT_VIETNAMESE;
                break;
            }
            if (nameRole.equals(ROLE_CASHIER)) {
                this.roleNameVietNamese = ROLE_CASHIER_VIETNAMESE;
                break;
            }
            if (nameRole.equals(ROLE_EMPLOYEE)) {
                this.roleNameVietNamese = ROLE_EMPLOYEE_VIETNAMESE;
                break;
            }
        }
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO() {
    }

    public UserDTO(User user, long numberUserOfSystem, List<TimeUserLoggedDTO> timeUserLogged) {
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.address = user.getAddress();
        this.description = user.getDescription();
        this.phoneNumber = user.getPhoneNumber();
        this.interests = user.getInterests();
        this.facebookUrl = user.getFaceBookUrl();
        this.occupation = user.getOccupation();
        this.imageBase64 = Base64.encodeBase64String(user.getImage());
        this.numberUserOfSystem = numberUserOfSystem;
        this.timeUserLoggeds = timeUserLogged;
    }

    public long getNumberUserOfSystem() {
        return numberUserOfSystem;
    }

    public void setNumberUserOfSystem(long numberUserOfSystem) {
        this.numberUserOfSystem = numberUserOfSystem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
