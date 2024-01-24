import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.ResourceDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.entiry.Resource;

public class ResourceDaoTest {
	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		ResourceDaoImpl resourceDaoImpl = ctx.getBean("resourceDaoImpl", ResourceDaoImpl.class);
		
		
//		Optional<Resource> resourceOpt = resourceDaoImpl.findLinkByResourceId(1);
//		Resource resource = resourceOpt.get();
//		Integer resourceId = resource.getResourceId();
//		String link = "654321";
//		resourceDaoImpl.updateLink(link, resourceId);
		
		List<Resource> resources = resourceDaoImpl.findAllResourcesByCourseId(1);
		System.out.println(resources);
		
	}
}