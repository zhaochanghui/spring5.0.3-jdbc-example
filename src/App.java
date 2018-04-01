import com.sql.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.sql.UserJDBCTPL;



public class App {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        UserJDBCTPL t = (UserJDBCTPL) app.getBean("tpl");
        System.out.println("添加记录：");
        t.create("张三",11);
        t.create("李四",22);
        t.create("王五",33);

        System.out.println("显示");
        List<User> users = t.listUsers();
        for(User u: users){
            System.out.println("id:"+u.getId()+"    name:"+u.getName()+"   age:"+u.getAge());
        }

        System.out.println("更新数据库");
        t.update(2,233);
        System.out.println("查询数据库");

        User user = t.getUser(2);
        System.out.println("id="+user.getId());
        System.out.println("name="+user.getName());
        System.out.println("age="+user.getAge());
    }
}
