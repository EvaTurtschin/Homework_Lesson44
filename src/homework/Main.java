package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /* Создать следующие интерфейсы:
Printable, содержащий метод void print(String s) и Producible, содержащий метод String produce()
Используя эти интерфейсы написать 2 лямбды, реализующие метод соответствующего интерфейса таким образом:
- строка распечатывается в виде !строка!
- возвращается строка "Hello World"
Task 2
Написать метод, принимающий имя файла и лист Person. Метод сохраняет в этот файл обьекты класса Person
из листа (класс Person имеет 2 поля name и age - см код занятия).
     */

    public static void main(String[] args) {

        //Task 1
        Printable printable = s -> System.out.println("!" + s + "!");
        printable.print("Hello");

        Producible producible = () -> "Hello World";
        System.out.println(producible.produce());

        //Task 2
        Person person1 = new Person("Jack", 47);
        Person person2 = new Person("Ann", 33);
        Person person3 = new Person("Kate", 16);
        Person person4 = new Person("Bill", 20);
        List<Person> personList = Arrays.asList(person1,person2,person3,person4);

        String file = "file.txt";
        createFile(personList,file);
    }

    public static void createFile (List<Person> personList, String file){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"))){
            for (Person p : personList){
                bufferedWriter.write (p.toString());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}
