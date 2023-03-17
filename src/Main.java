import Interface.ServiceImpl;
import Interface.TwoImpl;
import classes.Admin;
import exceptions.BadRequestException;
import exceptions.MyException;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException, BadRequestException {
        ServiceImpl service1 = new ServiceImpl();
        Calendar calendar = Calendar.getInstance();
        int date1 = calendar.get(Calendar.DATE);
        int date2 = calendar.get(Calendar.MARCH);
        int date3 = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        if (hour >= 5 && hour <= 11) {
            System.out.println("Кутман тан!" + " Саат -> " + hour + ":" + minute + "." + " Дата -> " + date1 + "." + date2 + "." + date3 + ".");
        } else if (hour >= 12 && hour <= 16) {
            System.out.println("Кутман кун!" + " Саат -> " + hour + ":" + minute + "." + " Дата -> " + date1 + "." + date2 + "." + date3 + ".");
        } else if (hour >= 17 && hour <= 22) {
            System.out.println("Кутман кеч!" + " Саат -> " + hour + ":" + minute + "." + " Дата -> " + date1 + "." + date2 + "." + date3 + ".");
        } else if (hour >= 23 && hour <= 4) {
            System.out.println("Кутман тун!" + " Саат -> " + hour + ":" + minute + "." + " Дата -> " + date1 + "." + date2 + "." + date3 + ".");
        }
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        boolean isE = true;
        while (isE) {
            try {
                System.out.println("Kатталган болсонуз 0 басыныз");
                int start = new Scanner(System.in).nextInt();
                switch (start) {
                    case 0 -> {
                        boolean isTrue1 = true;

                        System.out.print("\"Электрондук почтанызды жазыныз:\"");
                        admin.setEmail((scanner.nextLine()));
                        System.out.print("Пароль жазыныз:");
                        admin.setPorol(scanner.nextLine());
                        while (isTrue1) {
                            System.out.println("*********** Бир команда танданыз! ***********");
                            System.out.println("""
                                     1 -> Add new group.
                                     2 -> Get group by name.
                                     3 -> Update group name.
                                     4 -> Get all groups.
                                     5 -> Add new student to group.
                                     6 -> Update student.
                                     7 -> Find student by first name.
                                     8 -> Get all students by group name.
                                     9 -> Add new lesson to group.
                                     10 -> Delete student.
                                     11 -> Get all students lesson.
                                     12 -> Get lesson by name.
                                     13 -> Get all lesson by group name.
                                     14 -> delete lessons.
                                     15 -> delete group.
                                    """);
                            int number1 = scanner.nextInt();
                            switch (number1) {
                                case 1 -> service1.add_New_Group();
                                case 2 -> service1.get_Group_By_Name();
                                case 3 -> service1.update_group_Name();
                                case 4 -> service1.get_All_Groups();
                                case 5 -> service1.add_New_Student_To_Group();
                                case 6 -> service1.update_Student();
                                case 7 -> service1.find_Student_By_First_Name();
                                case 8 -> service1.get_All_Students_By_Group_Name();
                                case 9 -> service1.add_New_Lesson_To_Group();
                                case 10 -> service1.delete_Student();
                                case 11 -> service1.get_All_Students_Lesson();
                                case 12 -> service1.get_Lesson_By_Name();
                                case 13 -> service1.get_All_Lesson_By_Group_Name();
                                case 14 -> service1.delete_Lessons();
                                case 15 -> service1.delete_Group();
                            }
                        }
                    }
                    case 1 -> {
                        isE = false;
                    }
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


