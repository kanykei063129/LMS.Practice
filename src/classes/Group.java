package classes;

import java.util.List;

public class Group {
    private int id;
    private String name;
    private String description;
    private int lessons;
    private int students;

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public Group(int students,int lessons,int id) {
        this.id =id;
        this.students = students;
        this.lessons = lessons;
    }


    //    private List<Lesson> lessons;
//    private List<Student> student;

    public Group (int id , String name,String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
//    public Group(int id, String name, String description, List<Lesson> lessons, List<Student> student) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.lessons = lessons;
//        this.student = student;
//    }
    public Group(int id) {
        this.id = id;

    }
    public Group(){

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Lesson> getLessons() {
//        return lessons;
//    }
//
//    public void setLessons(List<Lesson> lessons) {
//        this.lessons = lessons;
//    }
//
//    public List<Student> getStudent() {
//        return student;
//    }
//
//    public void setStudent(List<Student> student) {
//        this.student = student;
//    }

    @Override
    public String toString() {
        return "Group" +
                "\nid=" + id +
                ",\nname='" + name + '\'' +
                ",\ndescription='" + description + '\'' +
                ",\nlessons=" + lessons +
                ",\nstudent=" + students;
    }
}
