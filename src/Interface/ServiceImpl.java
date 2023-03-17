package Interface;

import classes.Group;
import classes.Lesson;
import classes.Student;
import enums.Gender;
import exceptions.BadRequestException;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceImpl implements Service {
    private List<Group> groups = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();

    @Override
    public Group add_New_Group() {
        Group group = new Group(students.size(), lessons.size(), groups.size() + 1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Жаны группага ат жазыныз:");
        String name = scanner.nextLine();
        group.setName(name);
        System.out.println("Группанын суроттомосун жазыныз:");
        String description = scanner.nextLine();
        group.setDescription(description);
        groups.add(group);
        System.out.println(groups);
        return group;
    }


    @Override
    public void get_Group_By_Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        boolean isFalse = false;
        for (Group g : groups) {
            if (g.getName().equalsIgnoreCase(name)) {
                System.out.println(g);
                isFalse = false;
                break;
            } else {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("Мындай группа табылган жок!!!");
        }
    }

    @Override
    public void update_group_Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        Group newGroup = new Group();
        for (Group g : groups) {
            if (g.getName().equalsIgnoreCase(name)) {
                System.out.println("Жаны ат жазыныз:");
                String name1 = scanner.nextLine();
                g.setName(name1);
                System.out.println(g);
                newGroup = g;
                break;
            }
        }
        if (newGroup.getName() == null) {
            System.out.println("404");
        }
    }

    @Override
    public void get_All_Groups() {
        System.out.println(groups);
    }

    @Override
    public void add_New_Student_To_Group() {
        boolean isTure = true;
        Student student = new Student(students.size() + 1);
        System.out.println("Кайсы группага студент кошосуз, ошол группанын атын жазыныз:");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        try {
            String name = scanner.nextLine();
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    g.setStudents(g.getStudents() + 1);
                    System.out.println("Студенттин атын жазыныз:");
                    String name1 = scanner1.nextLine();
                    student.setName(name1);
                    System.out.println("Фамилиясын жазыныз:");
                    String name2 = scanner.nextLine();
                    student.setFirstName(name2);
                    int b = 0;
                    while (true) {
                        System.out.println("Электрондук почтанызды жазыныз:");
                        Scanner scanner21 = new Scanner(System.in);
                        try {
                            String name3 = scanner21.nextLine();
                            student.setEmail(name3);
                            if (name3.contains("@")) {
                            } else if (!name3.equals("@")) {
                                throw new BadRequestException("Электронный почтанызда @ жок!!!");
                            }
                            System.out.println("Пароль жазыныз:");
                            Scanner scanner23 = new Scanner(System.in);
                            while (true) {
                                String porol = scanner23.nextLine();
                                if (porol.length() >= 7) {
                                    student.setPorol(porol);
                                    b++;
                                    break;
                                } else {
                                    throw new BadRequestException("Пороль 7 cимболдон тузулуш керек");
                                }
                            }
                        } catch (BadRequestException badRequestException) {
                            System.out.println(badRequestException.getMessage());
                        }
                        if (b == 1) {
                            break;
                        }
                    }
                    while (isTure) {
                        System.out.println("Жынысын жазыныз(male/female):");
                        String pol = scanner1.nextLine();
                        if (pol.equalsIgnoreCase("male")) {
                            student.setGender(Gender.MALE);
                            isTure = false;
                        } else if (pol.equalsIgnoreCase("female")) {
                            student.setGender(Gender.FEMALE);
                            isTure = false;
                        } else {
                            System.out.println("Мындай жыныс жок!!!");
                            isTure = true;
                        }
                    }
                    System.out.println("Студент(-кa) ийгиликтуу кошулду!");
                    System.out.println(student);
                    students.add(student);
                    break;

                } else {
                    System.out.println("Мындай группа жок!!!");
                }
            }
        } catch (IllegalAccessError e) {
            System.out.println();
        }
    }

    @Override
    public void update_Student() {
        Student student = new Student(students.size() + 1);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Электронный почтанызды жазыныз:");
        String name = scanner.nextLine();
        System.out.println("Пароль жазыныз:");
        String porol = scanner1.nextLine();
        for (Student s : students) {
            if (s.getEmail().equals(name)) {
                if (s.getPorol().equalsIgnoreCase(porol)) {
                    System.out.println("Жаны ат жазыныз:");
                    String name1 = scanner.nextLine();
                    s.setName(name1);
                    System.out.println("Жаны фамилиясын жазыныз:");
                    String name2 = scanner1.nextLine();
                    s.setFirstName(name2);
                    students.add(s);
                }
            } else {
                System.out.println("Электронный почта же пороль туура эмес!!!");
            }
            break;
        }
        System.out.println(students);
    }

    @Override
    public void find_Student_By_First_Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Студенттин атын жазыныз:");
        String name = scanner.nextLine();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println(s);
            } else {
                System.out.println("Мындай стедунт табылган жок!!!");
            }
        }
    }

    @Override
    public void get_All_Students_By_Group_Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        for (Student s : students) {
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    System.out.println(s);
                } else {
                    System.out.println("Мындай группа жок!!!");
                }
            }
        }
    }

    @Override
    public void add_New_Lesson_To_Group() {
        Lesson lesson = new Lesson(lessons.size() + 1);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        for (Group g : groups) {
            if (g.getName().equalsIgnoreCase(name)) {
                g.setLessons(g.getLessons() + 1);
                System.out.println("Сабактын атын жазыныз:");
                String name1 = scanner1.nextLine();
                lesson.setLessonName(name1);
                System.out.println("Тапшырманын суроттомосун жазыныз:");
                String name2 = scanner.nextLine();
                lesson.setTaskDescription(name2);
            } else {
                System.out.println("Мындай группа жок!!!");
            }
            System.out.println(lesson);
            lessons.add(lesson);
        }
    }

    @Override
    public void delete_Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кимди очуросуз, ошол адамдын электронный почтасын жазыныз:");
        String email = scanner.nextLine();
        for (Student s : students) {
            if (s.getEmail().equals(email)) {
                this.students.remove(s);
                System.out.println("Электронный почтасы " + s.getEmail() + " болгон студент(-ка) ийгидиктуу очурулду!");
                break;
            } else {
                System.out.println("Мындай электронный почта жок!!!");
            }
        }
    }

    @Override
    public void get_All_Students_Lesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Студенттин почтасын жазыныз:");
        boolean isFalse = false;
        for (Student s : students) {
            String name = scanner.nextLine();
            if (s.getEmail().equals(name)) {
                System.out.println(lessons);
                isFalse = false;
                break;
            } else {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("Мындай электронный почта жок!!!");
        }
    }

    @Override
    public void get_Lesson_By_Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сабактын атын жазыныз:");
        for (Lesson l : lessons) {
            String name = scanner.nextLine();
            if (l.getLessonName().equalsIgnoreCase(name)) {
                System.out.println(lessons);
            } else {
                System.out.println("Мындай сабак жок!!!");
            }
        }
    }

    @Override
    public void get_All_Lesson_By_Group_Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        for (Lesson l : lessons) {
            for (Group g : groups) {
                String name = scanner.nextLine();
                if (g.getName().equalsIgnoreCase(name)) {
                    System.out.println(l);
                } else {
                    System.out.println("Мындай группа жок!!!");
                }
            }
        }
    }

    @Override
    public void delete_Lessons() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сабактын атын жазыныз:");
        for (Lesson l : lessons) {
            String name = scanner.nextLine();
            if (l.getLessonName().equalsIgnoreCase(name)) {
                this.lessons.remove(l);
                System.out.println("Сабак ийгиликтуу очурулду!");
                break;
            } else {
                System.out.println("Мындай сабак жок!!!");
            }

        }
    }

    @Override
    public void delete_Group() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        for (Group g : groups) {
            String name = scanner.nextLine();
            if (g.getName().equalsIgnoreCase(name)) {
                this.groups.remove(g);
                System.out.println("Группа ийгиликтуу очурулду!");
                break;
            } else {
                System.out.println("Мындай группа жок!!!");
            }
        }
    }
}
