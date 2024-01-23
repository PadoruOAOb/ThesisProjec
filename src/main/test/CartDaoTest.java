
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.CartDao;
import com.example.dao.CartDaoImpl;
import com.example.entiry.Cart;
import com.example.entiry.Course;
import com.example.entiry.User;
import com.example.dao.CourseDaoImpl;


public class CartDaoTest {

	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		CartDaoImpl cartDaoImpl = ctx.getBean("cartDaoImpl", CartDaoImpl.class);

//		List<Cart> carts = cartDaoImpl.findAllCarts();
//		System.out.println(carts);

//		Cart cart = new Cart();
//		cart.setUserId(2);
//		cart.setAmount(500);
//		cart.setIsCheckout(0);
//		cartDaoImpl.addCart(cart);
//		System.out.println(cart);

//		3. 根據購物車ID查找購物車資料(單筆)成功
//		 Optional<Cart> cartPot = cartDaoImpl.findCartById(1); 
//		 if (cartPot.isPresent()) {
//			    // 取得購物車資料
//			    Cart cart = cartPot.get();
//			    // 列印購物車資料
//			    System.out.println("CartId: " + cart.getCartId());
//			    System.out.println("UserId: " + cart.getUserId());
//			    System.out.println("IsCheckout: " + cart.getIsCheckout());
//			    System.out.println("CheckoutTime: " + cart.getCheckoutTime());
//			}  else {
//				System.out.println("找不到指定的購物車");
//			}
//			
//		4. 根據使用者ID及結帳狀態來查找其所有購物車資料(多筆)
//		 List<Cart> cartlist = cartDaoImpl.findCartsbyUserIdAndCheckoutStatus(2,0);
//		 System.out.println("找到" + cartlist.size() + " 使用者為2的未結帳購物車(0)");

//	    5. 根據使用者ID來查找其未結帳的購物車資料(單筆)
		Optional<Cart> cartPot = cartDaoImpl.findNoneCheckoutCartByUserId(2);
		cartPot.ifPresent(cart -> {
			System.out.println("找到未結帳的購物車:");
			System.out.println("購物車ID: " + cart.getCartId());
			System.out.println("使用者ID: " + cart.getUserId());
			System.out.println("是否結帳: " + cart.getIsCheckout());
			System.out.println("結帳時間: " + cart.getCheckoutTime());
		});
		
//      如果未找到購物車，則列印相應消息
		if (cartPot.isEmpty()) {
			System.out.println("未找到未結帳的購物車");
		}
	}
//      6.根據使用者ID將該使用者的購物車設置為已結帳狀態(前台的事件)


        
}
