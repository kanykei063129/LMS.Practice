package classes;

import enums.Gender;

public class Student {
    private int id;
private String name;
private String firstName;
private String email;
private String porol;
private Gender gender;
public Student(){}
    public Student(String name, String firstName, String email, String porol, Gender gender) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.porol = porol;
        this.gender = gender;
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPorol() {
        return porol;
    }

    public void setPorol(String porol) {
        this.porol = porol;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", porol=" + porol +
                ", gender=" + gender +
                '}';
    }
}
