package org.example;
public class Admin extends User {
    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
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
}




