package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Course.allCourses;

/**
 * The `Admin` class represents an administrator user with additional privileges.
 * It inherits properties and methods from the `User` class.
 */
public class Admin extends User {
    // List of courses managed by the admin
    public List<Course> courses;

    /**
     * Creates a new `Admin` object with the specified first name and last name.
     *
     * @param firstName The first name of the admin.
     * @param lastName  The last name of the admin.
     */
    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        this.courses = new ArrayList<>();
    }

    /**
     * Removes a lesson plan based on its subject and title.
     *
     * @param subject The subject of the lesson plan to remove.
     * @param title   The title of the lesson plan to remove.
     * @return `true` if the lesson plan is successfully removed, `false` otherwise.
     */
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

    /**
     * Overrides the `addTeacher` method from the `User` class to allow admin-specific behavior.
     *
     * @param firstName The first name of the teacher to add.
     * @param lastName  The last name of the teacher to add.
     * @param subject   The subject that the teacher specializes in.
     * @return `true` if the teacher is successfully added, `false` otherwise.
     */
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

    /**
     * Removes a teacher based on their first name and last name.
     *
     * @param firstName The first name of the teacher to remove.
     * @param lastName  The last name of the teacher to remove.
     * @return `true` if the teacher is successfully removed, `false` otherwise.
     */
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

    /**
     * Adds a new course to the list of all courses.
     *
     * @param course The course to be added.
     * @return `true` if the course is successfully added, `false` otherwise.
     */
    public boolean addCourse(Course course) {
        if (course != null && course.getCourseCode() != null && course.getDescription() != null) {
            return allCourses.add(course);
        }
        return false;
    }
}




