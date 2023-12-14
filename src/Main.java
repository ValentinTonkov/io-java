import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            workingWithByteStreams();
            workingWithCharacterStreams();
            fileClassExample();
            objectSerialization();

            task1();
            task2();

        } catch (FileNotFoundException e){
            System.out.println("No such file or directory");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void workingWithByteStreams() throws IOException {
        // writing to a file
        OutputStream out = new FileOutputStream("file1");  // path to the file, now it will be created
        byte[] arr = {'h', 'e', 'l', 'l', 'o'};                 // in the project's directory
        out.write(arr);                                         // full path to other directory could be also used
        out.close();

        // reading from a file
        FileInputStream in = new FileInputStream("file1");
        while (in.available() > 0) {
            System.out.println((char) in.read());
        }
        // using buffering
        FileOutputStream file1 = new FileOutputStream("fileName1");
        BufferedOutputStream outputStream = new BufferedOutputStream(file1, 10);
        outputStream.write(arr);
        outputStream.flush();  //when using buffering, we should call flush method
        outputStream.close();
        file1.close();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("fileName1"), 10);
    }

    private static void workingWithCharacterStreams() throws IOException {

        Writer writer = new FileWriter("file2");
        writer.write("This is file2");
        writer.close();

        FileReader reader = new FileReader("file2");
        BufferedReader bufferedReader = new BufferedReader(reader);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();

        PrintWriter printWriter = new PrintWriter("file2");
        printWriter.println("line");
        printWriter.close();
    }

    private static void fileClassExample() {
        File file = new File("file2");
        System.out.println(file.getAbsolutePath());
    }

    private static void objectSerialization() throws IOException, ClassNotFoundException {
        serializeObject();
        deserializeObject();
    }

    @SuppressWarnings("unchecked")
    private static void deserializeObject() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("people"));
        List<Person> people = (List<Person>) inputStream.readObject();

        people.forEach(System.out::println);
    }

    private static void serializeObject() throws IOException {
        List<Person> people = List.of(
                new Person(13, "Ivan"),
                new Person(23, "Stoyan"),
                new Person(22, "Maria"),
                new Person(39, "Georgi")
        );
        FileOutputStream file = new FileOutputStream("people");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
        objectOutputStream.writeObject(people);
    }

    private static void task1() {
        // TODO implement the task
    }

    private static void task2() {
        // TODO implement the task
    }
}