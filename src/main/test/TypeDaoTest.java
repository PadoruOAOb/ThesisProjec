import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.TypeDaoImpl;
import com.example.entiry.Course;
import com.example.entiry.Type;
import com.example.entiry.User;

public class TypeDaoTest {
	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		TypeDaoImpl typeDaoImpl = ctx.getBean("typeDaoImpl", TypeDaoImpl.class);

		List<Course> courses = typeDaoImpl.findCourseByTypeId(1);
		for (Course course : courses) {
			System.out.println(course.getCourseName());
		}
	}
}
