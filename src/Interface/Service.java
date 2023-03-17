package Interface;

import classes.Group;

public interface Service {
    Group add_New_Group();
    void get_Group_By_Name();
    void update_group_Name();
    void get_All_Groups();
    void add_New_Student_To_Group();
    void update_Student();
    void find_Student_By_First_Name();
    void get_All_Students_By_Group_Name();
    void add_New_Lesson_To_Group();
    void delete_Student();
    void get_All_Students_Lesson();
    void get_Lesson_By_Name();
    void get_All_Lesson_By_Group_Name();
    void delete_Lessons();
    void delete_Group();
}

