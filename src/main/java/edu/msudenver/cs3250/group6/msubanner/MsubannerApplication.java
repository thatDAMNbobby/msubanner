package edu.msudenver.cs3250.group6.msubanner;

import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Section;
import edu.msudenver.cs3250.group6.msubanner.entities.User;
import edu.msudenver.cs3250.group6.msubanner.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The msubanner application.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"edu"})
public class MsubannerApplication implements CommandLineRunner {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoomRepository roomRepository;

    /**
     * Starts the spring application.
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(MsubannerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sectionRepository.deleteAll();
        courseRepository.deleteAll();
        userRepository.deleteAll();
        buildingRepository.deleteAll();
        roomRepository.deleteAll();
        departmentRepository.deleteAll();
        Section section = new Section();
        section.setId("900123456");

        Course course = new Course();
        course.setId("4250");
        course.setTitle("Bla");
        course.setCredits(2);
        course.setLearningObjectives("none");
        courseRepository.save(course);
        section.setCourse(course);
        User user = new User();
        user.setId("65");
        user.setFirstName("bob");
        user.setLastName("Mow");
        userRepository.save(user);
        section.setProfessor(user);
        sectionRepository.save(section);

    }
}
