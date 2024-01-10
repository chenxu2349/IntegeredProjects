import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.example.pojo.Student;
import org.example.utils.KryoUtil;

import java.io.ByteArrayOutputStream;

public class KryoTest {
    public static void main(String[] args) {

        Student stu = Student.builder()
                .name("Tom")
                .age(21)
                .build();

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);
//        kryo.register(Student.class);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);

        // serialize
        kryo.writeObject(output, stu);
        output.close();
        System.out.println("serialize OK!");

        // deserialize
        byte[] bytes = bos.toByteArray();
        Input input = new Input(bytes);
        Student deserializeStu = kryo.readObject(input, Student.class);
        input.close();
        System.out.println(deserializeStu);
        System.out.println("deserialize OK!");


    }
}
