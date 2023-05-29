package src.com.session.summer.user;

public class Student extends User {
    private int course;
    private int scholarship;

    public void setCourse(int course) {
        this.course = course;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public int getCourse() {
        return course;
    }

    public int getScholarship() {
        return scholarship;
    }
}
