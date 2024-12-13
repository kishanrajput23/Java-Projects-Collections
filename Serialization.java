import java.io.*;

class Student implements Serializable {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        try {
            Student student = new Student("Alice", 20);

            // Serialization
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
            out.writeObject(student);
            out.close();

            // Deserialization
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
            Student deserializedStudent = (Student) in.readObject();
            in.close();

            System.out.println("Deserialized Student: Name - " + deserializedStudent.name + ", Age - " + deserializedStudent.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
