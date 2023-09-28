package org.example;
public class Teacher extends User {
    private String subject;

    public Teacher(String firstName, String lastName, String subject) {
        super(firstName, lastName);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public boolean setSubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty");
        }
        this.subject = subject;
        return true;
    }

}


