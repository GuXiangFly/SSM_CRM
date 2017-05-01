import com.guxiang.bean.Department;
import com.guxiang.bean.Employee;
import com.guxiang.dao.DepartmentMapper;
import com.guxiang.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * MapperTest
 *
 * @author guxiang
 * @date 2017/4/30
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {


    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    /**
     * 测试department
     */
    @Test
    public void  testCRUD(){
        //创建ioc容器
       // ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        System.out.println(departmentMapper);

        //插入部门
       // departmentMapper.insertSelective(new Department(null,"开发部"));
       // departmentMapper.insertSelective(new Department(null,"测试部"));

      //  employeeMapper.insertSelective(new Employee(null,"guxiang","M","1364@qq.com",1));
        //for循环批量插入 虽然 不使用sqlsession也可以完成 但是那样需要很长时间

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,uid,"N",uid+"@qq.com",1));
        }

        System.out.println("finash");
    }


}