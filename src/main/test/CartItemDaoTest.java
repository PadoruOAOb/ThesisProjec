
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.CartItemDaolmpl;
import com.example.entiry.CartItem;

public class CartItemDaoTest {

	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		CartItemDaolmpl cartItemDaoImpl = ctx.getBean("cartItemDaolmpl", CartItemDaolmpl.class);

//		List<CartItem> cartItems = cartItemDaoImpl.findAllCartItems();
//		System.out.println(cartItems);

//		CartItem cartItem = new CartItem();
//		cartItem.setCartId(1);
//		cartItem.setCourseId(2);
//		cartItem.setPrice(100);
//		cartItemDaoImpl.addCartItem(cartItem);
//		System.out.println(cartItem);

		// 假設 cartItemDaoImpl 和 userId 已經被正確初始化
		List<CartItem> cartItems = cartItemDaoImpl.findCartItemsByUserIdAndCheckout(1);
		System.out.println(cartItems);

	}
}
