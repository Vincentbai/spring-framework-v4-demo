package au.com.vincentbai.ioc.b_life;

public class Person {

    private Integer id;

    private String gender;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("2. dependency injection");
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("1. create an object");
    }

    // 如果没有在xml中注册这两个方法，就不会被调用
    public void init(){
        System.out.println("3. init the Person object");
    }

    public void destroy(){
        System.out.println("5. destory the Person object");
    }

    @Override
    public String toString() {
        return "4. Person{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
