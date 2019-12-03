package watch.store.mnm.domain;

import watch.store.mnm.exception.MessageException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@NamedEntityGraph(name = "User.roles",
        attributeNodes = @NamedAttributeNode("roles"))
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Size(min = 4)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank
    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "firstname", length = 46)
    private String firstname;

    @Column(name = "lastname", length = 46)
    private String lastname;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "address", length = 130)
    private String address;

    @Column(name = "facebookUrl")
    @Pattern(regexp = "((http|https)://)?(www[.])?facebook.com/.+", message = MessageException.FORMAT_FACEBOOK_URL)
    private String faceBookUrl;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = MessageException.FORMAT_PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = "interests")
    private String interests;

    @Column(name = "description")
    private String description;

    @Column(name = "occupation")
    private String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFaceBookUrl() {
        return faceBookUrl;
    }

    public void setFaceBookUrl(String faceBookUrl) {
        this.faceBookUrl = faceBookUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Column(name = "deletedDate")
    private Date deletedDate;

    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;

    @Column(name = "createBy", nullable = false)
    private String createBy;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "flag", nullable = false, columnDefinition = "boolean default true")
    private boolean flag;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<TimeUserLogged> timeUserLoggeds;

    @ManyToMany(mappedBy = "users")
    private Set<Comment> comments;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<TimeUserLogged> getTimeUserLoggeds() {
        return timeUserLoggeds;
    }

    public void setTimeUserLoggeds(Set<TimeUserLogged> timeUserLoggeds) {
        this.timeUserLoggeds = timeUserLoggeds;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


}