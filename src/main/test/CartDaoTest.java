

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.CartDaoImpl;
import com.example.entiry.Cart;

public class CartDaoTest {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		CartDaoImpl cartDaoImpl = ctx.getBean("cartDaoImpl", CartDaoImpl.class);
		
		List<Cart> carts = cartDaoImpl.findAllCarts();
		System.out.println(carts);
		
	}

}
