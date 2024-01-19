

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.UserDaoImpl;
import com.example.entiry.User;

public class UserDaoTest {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		UserDaoImpl userDaoImpl = ctx.getBean("userDaoImpl", UserDaoImpl.class);
		
		//List<User> users = userDaoImpl.findAllUsers();
		//System.out.println(users);
		
//		Optional<User> userOpt = userDaoImpl.findUserByUsername("aweit");
//		if(userOpt.isPresent()) {
//		  System.out.println(userOpt.get());
//		}
		
//		User user = new User();
//		user.setUsername("aweit123");
//		user.setPassword("123456");
//		user.setEmail("aweit123@example.com");
//		userDaoImpl.addUser(user);
//		System.out.println(user);
		
//		Optional<User> userOpt = userDaoImpl.findUserByUsername("aweit");
//		User user = userOpt.get();
//		Integer userId = user.getUserId();
//		String password = "654321";
//		userDaoImpl.updateUserPassword(password, userId);
		
	}

}
