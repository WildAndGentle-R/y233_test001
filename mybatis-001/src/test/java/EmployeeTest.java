import cn.bdqn.domain.Dept;
import cn.bdqn.domain.Employee;
import cn.bdqn.domain.EmployeeTO;
import cn.bdqn.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.awt.image.ImageObserver;
import java.io.InputStream;
import java.util.*;

public class EmployeeTest {
        // 测试1： 查询全部的员工
        @Test

        public void testSelectAllEmployees() throws Exception{

            // 1、读取mybatis主配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            // 2、根据配置文件创建SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            // 3、用SqlSessionFactory工厂去创建SqlSession
            SqlSession session = factory.openSession();

            // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
            List<Employee> employees = session.selectList("cn.bdqn.mapper.selectAllEmployees");

            // 5
                    System.out.println(employees);

            // 6、关闭SqlSession
            session.close();

            // 7、关闭流
            is.close();
        }

    @Test
    public void testdelete() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过ID删除
        Integer intt = session.delete("cn.bdqn.mapper.delete",1);

        // 5
        System.out.println();

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testinserta() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、增加

        Employee  employee=new Employee();
        employee.setEmpName("tomcat");
        employee.setSex("男");
        employee.setEmail("123@qq.com");
        employee.setBirthday(new Date());
        employee.setAddress("66666");
        // 5

        session.insert("cn.bdqn.mapper.insert2",employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
       @Test
       public void testupdate() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、更改

        Employee  employee=new Employee();
        employee.setId(2);
        employee.setEmpName("罗傻逼");
        employee.setEmail("123456@qq.com");
        // 5

        session.update("cn.bdqn.mapper.update",employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testSelectById() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、

        // 5

        List<Employee> employee =  session.selectList("cn.bdqn.mapper.SelectById","罗");

        System.out.println(employee);
        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }


    @Test
    public void testinsert() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、增加

        Employee  employee=new Employee();
        employee.setEmpName("tomcat");
        employee.setSex("男");
        employee.setEmail("123@qq.com");
        employee.setBirthday(new Date());
        employee.setAddress("66666");
        // 5

        session.insert("cn.bdqn.mapper.insert2",employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    /**
    @Test
    public void save() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 4、更改

        Employee  employee=new Employee();
        employee.setId(2);
        employee.setEmpName("罗傻逼");
        employee.setEmail("123456@qq.com");
        // 5

        employeeMapper.save(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }**/
    /**@Test
    public void testQueryByNameAndSex() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryByNameAndSex("罗磊","男");

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }**/

    @Test
    public void testQueryByNameAndSex1() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee conditionEmp = new Employee();
        conditionEmp.setEmpName("罗磊");
        conditionEmp.setSex("男");
        Employee employee = employeeMapper.queryByNameAndSex(conditionEmp);;

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryByNameAndSex2() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("empNameKey","罗磊");
        params.put("sexKey","男");
        Employee employee = employeeMapper.queryByNameAndSex(params);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryByNameAndSex3() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        EmployeeTO employeeTO = new EmployeeTO();
        employeeTO.setEmpName("罗磊");
        employeeTO.setSex("男");
        Employee employee = employeeMapper.queryByNameAndSex(employeeTO);


        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryByIds() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        Employee employee = employeeMapper.queryByIds(list);
        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryByIds1() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Integer[] ids = {6};
        Employee employee = employeeMapper.queryByIds(Arrays.asList(ids));

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryEmployeesByName() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> employees = employeeMapper.queryEmployeesByName("%罗%");

        // 5、打印
        System.out.println(employees);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryById() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String,Object> result = employeeMapper.queryById(2);

        // 5、打印
        System.out.println(result);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryByName() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Map<String, Object>> maps = employeeMapper.queryByName("%罗%");


        // 5、打印
        System.out.println(maps);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testQueryByName1() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<Integer,Employee> map = employeeMapper.queryByName1("%罗%");


        // 5、打印
        System.out.println(map);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryById1() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById1(4);


        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryById2() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById2(4);


        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testQueryById3() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById3(4);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testQueryById4() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById4(2);

        // 5、打印
        System.out.println(employee.getDept().getDeptName());

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testQueryByCondition() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        //employee.setEmpName("王");
        employee.setAddress("周口");
        employee.setSex("男");
        //employee.setEmail("wang");
        List<Employee> employees = employeeMapper.queryByCondition(employee);


        // 5、打印
        System.out.println(employees);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testQueryByCondition1() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        //employee.setEmpName("罗");
        employee.setAddress("周口");
        employee.setSex("男");
        //employee.setEmail("wang");
        List<Employee> employees = employeeMapper.queryByCondition1(employee);


        // 5、打印
        System.out.println(employees);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testQueryByCondition2() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        //employee.setEmpName("罗");
        //employee.setAddress("周口");
        //employee.setSex("男");
        //employee.setEmail("wang");
        List<Employee> employees = employeeMapper.queryByCondition2(employee);


        // 5、打印
        System.out.println(employees);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testQueryByCondition3() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        //employee.setEmpName("罗");
        //employee.setAddress("周口");
        //employee.setSex("男");
        employee.setEmail("wang");
        List<Employee> employees = employeeMapper.queryByCondition3(employee);


        // 5、打印
        System.out.println(employees);

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void testUpdateById() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setId(16);
        employee.setEmpName("王大侠");

        // 更新员工名
        employeeMapper.updateById(employee);
        // 5、打印
        //System.out.println();

        // 6、关闭SqlSession
        session.commit();
        session.close();

        // 7、关闭流
        is.close();
    }
    }

