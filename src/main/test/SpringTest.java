

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		
		DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
		
		if(dataSource.getConnection().isValid(1000)) {
			System.out.println("連線成功");
		}
	}

}
