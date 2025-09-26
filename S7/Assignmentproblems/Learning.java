class Course {
    void progress() { System.out.println("General course progress"); }
}
class VideoCourse extends Course {
    void progress() { System.out.println("Video: Completion % and Watch Time"); }
}
class InteractiveCourse extends Course {
    void progress() { System.out.println("Interactive: Quiz Scores and Projects"); }
}
class ReadingCourse extends Course {
    void progress() { System.out.println("Reading: Pages Read and Notes"); }
}
class CertificationCourse extends Course {
    void progress() { System.out.println("Certification: Exam Attempts and Status"); }
}
public class Learning {
    public static void main(String[] args) {
        Course[] c = { new VideoCourse(), new InteractiveCourse(), new ReadingCourse(), new CertificationCourse() };
        for(Course x: c) x.progress();
    }
}
