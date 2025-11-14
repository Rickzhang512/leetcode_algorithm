import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;

class Student {
    String uid;
    String firstname;
    String lastname;
    String nickname;
    int marks;
    public Student(String uid, String firstname, String lastname){
        this.uid = uid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Student() {}

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }

    public void setNickname(String name) {
        this.nickname = name;
    }

    public void setMarks(int i) {
        this.marks = i;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

public class JSONParser {
    public static void main(String[] args) {
        Gson gson = new Gson();

        try (JsonReader reader = new JsonReader(new FileReader("input.json"))) {
            Student[] students = gson.fromJson(reader, Student[].class);
            for (Student student : students) {
                System.out.println("Student roll no: " + student.uid);
                System.out.println("First Name: " + student.firstname);
                System.out.println("Last Name: " + student.lastname);
                System.out.println("Nick Name: " + student.nickname);
                System.out.println("Marks: " + student.marks);
            }

            Student student = new Student();
            student.setUid("u677767");
            student.setFirstname("Alice");
            student.setLastname("Johnson");
            student.setNickname("Ally");
            student.setMarks(95);

//            String json = gson.toJson(student);
//            System.out.println(json);
//             json = "{ \"uid\": \"4\", \"firstname\": \"Alex\", \"lastname\": \"Brown\", \"nickname\": \"Bobby\", \"marks\": 88 }";
//            Student student2 = gson.fromJson(json, Student.class);
//            System.out.println(student2.getFirstname());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
