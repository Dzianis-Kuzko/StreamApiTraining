package org.book.chap03;

import java.util.ArrayList;

public class StudentInfo {
//    void printStudentsOverGrade(ArrayList<Student> a1, double grade) {
//        for (Student student : a1) {
//            if (student.avgGrade > grade) {
//                System.out.println(student);
//            }
//        }
//
//    }
//
//    void printStudentsUnderAge(ArrayList<Student> a1, int age) {
//        for (Student student : a1) {
//            if (student.age > age) {
//                System.out.println(student);
//            }
//        }
//    }
//
//    void printStudentsMixCondition(ArrayList<Student> a1, int age, double grade, char sex) {
//        for (Student student : a1) {
//            if (student.age > age && student.avgGrade < grade && student.sex == sex) {
//                System.out.println(student);
//            }
//        }
//    }

    void testStudents(ArrayList<Student> a1, Checks<Student> sc) {
        for (Student s : a1) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
        int grade =8;
        info.testStudents(students, (student)->student.avgGrade>grade);
        System.out.println("------------------");
        int age = 30;
        char sex='f';
        info.testStudents(students, student->student.avgGrade>grade && student.age<age && student.sex==sex) ;


//        StudentInfo info = new StudentInfo();
//        info.printStudentsOverGrade(students, 8);
//        System.out.println("------------------------------");
//        info.printStudentsUnderAge(students, 30);
//        System.out.println("------------------------------");
//        info.printStudentsMixCondition(students, 20, 9.5, 'f');
    }
}

interface Checks<T> {
    boolean check(T s);
}

