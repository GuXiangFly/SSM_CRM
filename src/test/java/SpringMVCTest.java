import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * SpringMVCTest
 *
 * 使用spring测试模块提供的测试请求功能
 * @author guxiang
 * @date 2017/5/1
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class SpringMVCTest {

    //传入springmvc的IOC   为了传入ioc容器本身 使用另一个注解

    MockMvc mockMvc;

}
