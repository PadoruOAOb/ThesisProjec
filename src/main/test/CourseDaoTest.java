import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.example.dao.CourseDao;
import com.example.dao.CourseDaoImpl;
import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.entiry.Course;
import com.example.entiry.User;



public class CourseDaoTest {
	public static void main(String[] args) throws SQLException {

	
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		CourseDaoImpl courseDaoImpl = ctx.getBean("courseDaoImpl", CourseDaoImpl.class);

//		Course course = new Course();
//		course.setCourseName("打架課程");
//		course.setCourseDescription("暫無詳述");
//		course.setCourseDetail("暫無詳述");
//		course.setCourseImg("暫無入徑 Test");
//		course.setTeacher(1);
//		course.setPrice(9999);
//		course.setTypeId(2);
//		courseDaoImpl.addCourse(course);
//		System.out.println(course);

		List<Course> courses = courseDaoImpl.findAllCourses();
		System.out.println(courses);
	}
}
	

