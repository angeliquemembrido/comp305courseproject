package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Course.allCourses;

public class Admin extends User {
    public List<Course> courses;
    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        this.courses = new ArrayList<>();
    }


    public boolean removeLessonPlan(String subject, String title) {
        for (int i = 0; i < LessonPlan.lessonPlans.size(); i++) {
            LessonPlan lp = LessonPlan.lessonPlans.get(i);
            if (lp.getSubject().equals(subject) && lp.getTitle().equals(title)) {
                LessonPlan.lessonPlans.remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean addTeacher(String firstName, String lastName, String subject) {
        if (firstName != null && !firstName.isEmpty() &&
                lastName != null && !lastName.isEmpty() &&
                subject != null && !subject.isEmpty()) {
            Teacher newTeacher = new Teacher(firstName, lastName, subject);
            return teachers.add(newTeacher);
        }
        return false;
    }

    public boolean removeTeacher(String firstName, String lastName) {
        Teacher teacherToRemove = null;
        for (Teacher t : getTeachers()) {
            if (t.getFirstName().equals(firstName) && t.getLastName().equals(lastName)) {
                teacherToRemove = t;
                break;
            }
        }
        if (teacherToRemove != null) {
            getTeachers().remove(teacherToRemove);
            return true;
        }
        return false;
    }

    public boolean addCourse(Course course) {
        if (course != null && course.getCourseCode() != null && course.getDescription() != null) {
            return allCourses.add(course);
        }
        return false;
    }

}




