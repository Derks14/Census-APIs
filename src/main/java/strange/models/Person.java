package strange.models;

import org.springframework.data.annotation.Id;

public class Person {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String Othernames;
    private Integer age;
    private Character gender;
    private String nationality;
    private String email;
    private String phone;
    private String houseNumber;
    private String status;
    private String CurrentEduLevel;

    public Person() {
    }

    public Person(String lastname, String firstname, String othernames, String age, Character gender, String nationality, String email, String phone, String houseNumber, String status, String currentEduLevel) {
        this.lastname = lastname;
        this.firstname = firstname;
        Othernames = othernames;
        this.age = Integer.parseInt(age);
        this.gender = gender;
        this.nationality = nationality;
        this.email = email;
        this.phone = phone;
        this.houseNumber = houseNumber;
        this.status = status;
        CurrentEduLevel = currentEduLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getOthernames() {
        return Othernames;
    }

    public void setOthernames(String othernames) {
        Othernames = othernames;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentEduLevel() {
        return CurrentEduLevel;
    }

    public void setCurrentEduLevel(String currentEduLevel) {
        CurrentEduLevel = currentEduLevel;
    }
}
