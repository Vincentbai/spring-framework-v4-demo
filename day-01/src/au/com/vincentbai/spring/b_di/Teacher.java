package au.com.vincentbai.spring.b_di;

import java.util.List;
import java.util.Map;

public class Teacher {

    private Integer tid;

    private String tname;

    private List<String> cls;

    // 该命名规则有问题
//    private List<Student> sList;

    private List<Student> students;

    private Map<String,String> supervisorMap;


    public Map<String, String> getSupervisorMap() {
        return supervisorMap;
    }

    public void setSupervisorMap(Map<String, String> supervisorMap) {
        this.supervisorMap = supervisorMap;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<String> getCls() {
        return cls;
    }

    public void setCls(List<String> cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", cls=" + cls +
                ", students=" + students +
                ", supervisorMap=" + supervisorMap +
                '}';
    }
}
