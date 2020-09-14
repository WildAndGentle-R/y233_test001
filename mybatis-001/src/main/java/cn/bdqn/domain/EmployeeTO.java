package cn.bdqn.domain;

public class EmployeeTO {

    private String empName;

    private  String sex;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "EmployeeTO{" +
                "empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
