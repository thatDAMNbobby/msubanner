package edu.msudenver.cs3250.group6.msubanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Days;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.entities.HourBlock;
import edu.msudenver.cs3250.group6.msubanner.entities.Professor;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;
import edu.msudenver.cs3250.group6.msubanner.entities.Section;
import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import edu.msudenver.cs3250.group6.msubanner.repositories.BuildingRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.DepartmentRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.HourBlockRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.ProfessorRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.RoomRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.ScheduleRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.SectionRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.SemesterRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.UserRepository;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * The msubanner application.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "edu" })
public class MsubannerApplication extends WebSecurityConfigurerAdapter
        implements CommandLineRunner {

    /** The section repository. */
    @Autowired
    private SectionRepository sectionRepository;

    /** The course repository. */
    @Autowired
    private CourseRepository courseRepository;

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /** The building repository. */
    @Autowired
    private BuildingRepository buildingRepository;

    /** The department repository. */
    @Autowired
    private DepartmentRepository departmentRepository;

    /** The room repository. */
    @Autowired
    private RoomRepository roomRepository;

    /** The schedule repository. */
    @Autowired
    private ScheduleRepository scheduleRepository;

    /** The hour block repository. */
    @Autowired
    private HourBlockRepository hourBlockRepository;

    /** The semester repository. */
    @Autowired
    private SemesterRepository semesterRepository;

    /** The professor repository. */
    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Starts the spring application.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(MsubannerApplication.class, args);
    }

    @Override
    public final void run(final String... args) throws Exception {
        System.out.println("\n\n\n----------\nWorking Directory = "
                + System.getProperty("user.dir") + "\n\n\n\n");

        deleteRepositories();

        Department department = new Department("Morty's Memories");
        departmentRepository.save(department);

        Department department2 = new Department("Pickled Ricks");
        departmentRepository.save(department2);

        Department department3 = new Department("Citadel Ricks");
        departmentRepository.save(department3);

        Department department4 = new Department("Jerry Day Care");
        departmentRepository.save(department4);

        Semester semester = new Semester();
        semesterRepository.save(semester);

        Semester semester2 = new Semester();
        semester2.setSemesterStartDate(2018, 1, 12);
        semester2.setSemesterEndDate(2018, 3, 15);
        semester2.setSeason("Spring");
        semesterRepository.save(semester2);

        Course course = new Course();
        course.setId("ITR4250");
        course.setTitle("Intergalactic Travel for Ricks");
        course.setCredits(2);
        course.setLearningObjectives("none");
        course.setDepartment(department);
        courseRepository.save(course);

        Course course2 = new Course();
        course2.setId("MDFF3250");
        course2.setTitle("Blood Dome Combat for Fun and Profit");
        course2.setCredits(3);
        course2.setLearningObjectives("Rickmance the Stone");
        course2.setDepartment(department2);
        courseRepository.save(course2);

        Course course3 = new Course();
        course3.setId("PRA2100");
        course3.setTitle("Purging with Robotic Armor");
        course3.setCredits(4);
        course3.setLearningObjectives("Get your "
                        + "aggression out the healthy way");
        course3.setDepartment(department3);
        courseRepository.save(course3);

        Course course4 = new Course();
        course4.setId("PSDS2100");
        course4.setTitle("Puppet Shows for Death Stalkers");
        course4.setCredits(4);
        course4.setLearningObjectives("Entertainment for Cannibal");
        course4.setDepartment(department4);
        courseRepository.save(course4);

        Professor prof = new Professor();
        prof.setId("65");
        prof.setFirstName("Rick");
        prof.setLastName("Sanchez");
        userRepository.save(prof);
        professorRepository.save(prof);

        Professor prof2 = new Professor();
        prof2.setId("55");
        prof2.setFirstName("Jaguar");
        prof2.setLastName("  ");
        userRepository.save(prof2);
        professorRepository.save(prof2);

        Professor prof3 = new Professor();
        prof3.setId("45");
        prof3.setFirstName("Revolio");
        prof3.setLastName("Clockberg Jr.");
        userRepository.save(prof3);
        professorRepository.save(prof3);

        Professor prof4 = new Professor();
        prof4.setId("375");
        prof4.setFirstName("Million");
        prof4.setLastName("Ants");
        userRepository.save(prof4);
        professorRepository.save(prof4);

        Professor prof5 = new Professor();
        prof5.setId("600");
        prof5.setFirstName("Ghost");
        prof5.setLastName("Train");
        userRepository.save(prof5);
        professorRepository.save(prof5);

        Section section = new Section();
        section.setId("900123456");
        section.setProfessor(prof);
        section.setCourse(course);
        sectionRepository.save(section);

        Section section2 = new Section();
        section2.setId("900937823");
        section2.setProfessor(prof5);
        section2.setCourse(course2);
        sectionRepository.save(section2);

        Section section3 = new Section();
        section3.setId("900578394");
        section3.setProfessor(prof3);
        section3.setCourse(course3);
        sectionRepository.save(section3);

        Section section4 = new Section();
        section4.setId("900578395");
        section4.setProfessor(prof4);
        section4.setCourse(course4);
        sectionRepository.save(section4);

        Building building = new Building();
        building.setBuildingName("The Citadel of Ricks");
        building.setId("1488");
        buildingRepository.save(building);

        Building building2 = new Building();
        building2.setBuildingName("Blood Dome");
        building2.setId("2365");
        buildingRepository.save(building2);

        Building building3 = new Building();
        building3.setBuildingName("WorldEnder Stronghold");
        building3.setId("2800");
        buildingRepository.save(building3);

        Building building4 = new Building();
        building4.setBuildingName("Harry Herpson High School");
        building4.setId("3900");
        buildingRepository.save(building4);

        Room room = new Room();
        room.setId("54564");
        room.setRoomNumber(42);
        room.setRoomCapacity(30);
        room.setBuilding(building);
        roomRepository.save(room);

        Room room2 = new Room();
        room2.setId("656565");
        room2.setRoomNumber(30);
        room2.setRoomCapacity(20);
        room2.setBuilding(building2);
        roomRepository.save(room2);

        Room room3 = new Room();
        room3.setId("767676");
        room3.setRoomNumber(130);
        room3.setRoomCapacity(45);
        room3.setBuilding(building3);
        roomRepository.save(room3);

        Room room4 = new Room();
        room4.setId("878787");
        room4.setRoomNumber(240);
        room4.setRoomCapacity(25);
        room4.setBuilding(building4);
        roomRepository.save(room4);

        HourBlock block = new HourBlock(6, 1);
        hourBlockRepository.save(block);

        HourBlock block2 = new HourBlock(8, 2);
        hourBlockRepository.save(block2);

        HourBlock block3 = new HourBlock(11, 3);
        hourBlockRepository.save(block3);

        HourBlock block4 = new HourBlock(9, 2);
        hourBlockRepository.save(block4);


        List<Days.Day> days = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));

        List<Days.Day> days2 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.TUESDAY, Days.Day.THURSDAY }));

        List<Days.Day> days3 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.TUESDAY }));

        List<Days.Day> days4 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.TUESDAY, Days.Day.THURSDAY }));

        Schedule schedule = new Schedule();
        schedule.setScheduleName("Schedule 1");
        schedule.setRoom(room);
        schedule.setBuilding(building);
        schedule.setSemester(semester);
        schedule.setId("4512");
        schedule.setDuration(2);
        schedule.setHourBlock(block);
        schedule.setDays(days);
        schedule.setStartDate("2018/01/06");
        scheduleRepository.save(schedule);

        Schedule schedule2 = new Schedule();
        schedule2.setScheduleName("Schedule 2");
        schedule2.setRoom(room2);
        schedule2.setBuilding(building2);
        schedule2.setSemester(semester2);
        schedule2.setId("4215");
        schedule2.setDuration(3);
        schedule2.setHourBlock(block2);
        schedule2.setDays(days2);
        schedule2.setStartDate("2018/04/12");
        scheduleRepository.save(schedule2);

        Schedule schedule3 = new Schedule();
        schedule3.setScheduleName("Schedule 3");
        schedule3.setRoom(room3);
        schedule3.setBuilding(building3);
        schedule3.setSemester(semester2);
        schedule3.setId("5214");
        schedule3.setDuration(3);
        schedule3.setHourBlock(block3);
        schedule3.setDays(days3);
        schedule3.setStartDate("2018/01/16");
        scheduleRepository.save(schedule3);

        Schedule schedule4 = new Schedule();
        schedule4.setScheduleName("Schedule 4");
        schedule4.setRoom(room4);
        schedule4.setBuilding(building4);
        schedule4.setSemester(semester2);
        schedule4.setId("6767");
        schedule4.setDuration(4);
        schedule4.setHourBlock(block4);
        schedule4.setDays(days4);
        schedule4.setStartDate("2018/04/11");
        scheduleRepository.save(schedule4);
    }

    /**
     * Deletes repositories to prepare for prepopulation.
     */
    private void deleteRepositories() {
        sectionRepository.deleteAll();
        courseRepository.deleteAll();
        userRepository.deleteAll();
        buildingRepository.deleteAll();
        roomRepository.deleteAll();
        departmentRepository.deleteAll();
        scheduleRepository.deleteAll();
        hourBlockRepository.deleteAll();
        semesterRepository.deleteAll();
        professorRepository.deleteAll();
    }

    /**
     * Config for Authentication.
     *
     * @param http HttpSecurity
     * @throws Exception if login unsuccessful
     */
    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/error", "/static/**").permitAll()
                .antMatchers("/**").authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(new
                        LoginUrlAuthenticationEntryPoint("/login"));
    }

}
