package org.example;
public class Admin extends User {
    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public boolean uploadLessonPlan(String subject, String title, String description) {
        LessonPlan newLessonPlan = new LessonPlan(subject, title, description);
        return lessonPlans.add(newLessonPlan);
    }

    public boolean removeLessonPlan(String subject, String title) {
        for (int i = 0; i < lessonPlans.size(); i++) {
            LessonPlan lp = lessonPlans.get(i);
            if (lp.getSubject().equals(subject) && lp.getTitle().equals(title)) {
                lessonPlans.remove(i);
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




