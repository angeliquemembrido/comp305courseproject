package org.example;

/**
 * The {@code Teacher} class represents a teacher with first name, last name, and a subject they teach.
 */
public class Teacher extends User {
    private String subject;

    /**
     * Constructs a new teacher with the specified first name, last name, and subject.
     *
     * @param firstName The first name of the teacher.
     * @param lastName  The last name of the teacher.
     * @param subject   The subject that the teacher teaches.
     */
    public Teacher(String firstName, String lastName, String subject) {
        super(firstName, lastName);
        this.subject = subject;
    }

    /**
     * Gets the subject that the teacher teaches.
     *
     * @return The subject that the teacher teaches.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject that the teacher teaches.
     *
     * @param subject The subject to set for the teacher.
     * @return true if the subject is successfully set, false if the subject is null or empty.
     * @throws IllegalArgumentException if the subject is null or empty.
     */
    public boolean setSubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty");
        }
        this.subject = subject;
        return true;
    }
}

