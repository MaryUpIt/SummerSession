package src.com.session.summer.user;

public class UserMain {
    public static void main(String[] args) {
        Worker Ivan = new Worker();
        Ivan.setName("Ivan");
        Ivan.setAge(26);
        Ivan.setSalary(1000);

        Worker Vasiliy = new Worker();
        Vasiliy.setName("Vasiliy");
        Vasiliy.setAge(25);
        Vasiliy.setSalary(2000);

        int sumSalary = Ivan.getSalary() + Vasiliy.getSalary();
        System.out.println(sumSalary);

    }
}
