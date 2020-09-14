package cn.bdqn.mapper;

import cn.bdqn.domain.Employee;
import cn.bdqn.domain.EmployeeTO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    // 根据员工名和性别查询员工
    public Employee queryByNameAndSex(@Param("empName") String empName,@Param("sex") String sex);

    // 根据员工名和性别查询员工（javaBean）
    public Employee queryByNameAndSex(Employee employee);

    // 根据员工名和性别查询员工(Map)
    public Employee queryByNameAndSex(Map<String,Object> params);

    // 根据员工名和性别查询员工(TO)
    public Employee queryByNameAndSex(EmployeeTO employeeTO);

    // 根据id查询员工(list)
    public Employee queryByIds(List<Integer> ids);

    // 根据id查询员工（integer）
    public Employee queryByIds1(Integer[] ids);

    // 根据员工姓名查询所有员工(返回list类型)
    public List<Employee> queryEmployeesByName(String empName);

    // 根据员工id查询员工信息，返回值是一个Map
    public Map<String,Object> queryById(Integer id);

    // 根据姓名模糊查询员工列表，返回的值是一个List<Map<String,Object>>
    public List<Map<String,Object>> queryByName(String empName);

    // 根据姓名模糊查询员工列表，返回的值是一个Map<Integer,Employee>
    @MapKey("id")
    public Map<Integer,Employee> queryByName1(String empName);

    // 根据员工id查询员工
    public Employee queryById1(Integer id);
    // 根据员工id查询员工
    public Employee queryById2(Integer id);
    // 根据员工id查询员工
    public Employee queryById3(Integer id);

    // 根据员工id查询员工
    public Employee queryById4(Integer id);

    // 根据部门id查询该部门下的所有员工
    public List<Employee> queryByDeptId(Integer deptId);

    // 根据员工姓名、邮箱、家庭住址、性别模糊查询员工信息
    public List<Employee> queryByCondition(Employee employee);

    //根据员工姓名、邮箱、家庭住址、性别模糊查询员工信息
    public List<Employee> queryByCondition1(Employee employee);

    //根据员工姓名、邮箱、家庭住址、性别模糊查询员工信息
    public List<Employee> queryByCondition2(Employee employee);

    //根据员工姓名、邮箱、家庭住址、性别模糊查询员工信息
    public List<Employee> queryByCondition3(Employee employee);

    // 根据员工id更新员工信息【可能更新全部字段或者更新部分字段】
    public void updateById(Employee employee);
}