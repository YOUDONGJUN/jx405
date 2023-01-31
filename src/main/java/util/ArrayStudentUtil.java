package util;

import day0111.Student;
import day0111.Student;

public class ArrayStudentUtil {

    public static int size(Student[] student) {
        return student.length;
    }


    // B. isEmpty()
    public static boolean isEmpty(Student[] student) {
        return size(student) == 0;
    }

    // C. get()
    public static Student get(Student[] student, int index) {

        return student[index];
    }

    // D. contains()
    public static boolean contains(Student[] student , Student element) {
        for (int i = 0; i < size(student); i++) {
            if (element == get(student, i)) {
                return true;
            }
        }
        return false;
    }

    // E. indexOf()
    public static int indexOf(Student[] student, Student element) {
        for (int i = 0; i < size(student); i++) {
            if (element == get(student, i)) {
                return i;
            }
        }
        return -1;
    }

    // F. add()
    public static Student[] add(Student[] student, Student element) {
        Student[] temp = new Student[size(student) + 1];
        for (int i = 0; i < size(student); i++) {
            temp[i] = get(student, i);
        }
        temp[size(student)] = element;

        return temp;
    }

    // G. add()
    public static Student[] add(Student[] student, int index, Student element) {
        Student[] temp = new Student[size(student) + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = get(student, i);
        }
        temp[index] = element;
        for (int i = index; i < size(student); i++) {
            temp[i + 1] = get(student, i);

        }
        temp = new Student[0];
        for (int i = 0; i < size(student); ) {
            if (i != index) {
                temp = add(temp, get(student, i));
            } else {
                temp = add(temp, element);
            }
        }

        return temp;
    }

    // H. set()
    public static Student set(Student[] student, int index, Student element) {
        Student original = get(student, index);
        student[index] = element;

        return original;
    }

    // I. removeByIndex()
    public static Student[] removeByIndex(Student[] student, int index) {
        Student[] temp = new Student[0];
        for (int i = 0; i < size(student); i++) {
            if (i != index) {
                temp = add(temp, get(student, i));
            }
        }

        return temp;

    }

    // J. removeByElement
    public static Student[] removeByElement(Student[] student, Student element) {
        return removeByIndex(student, indexOf(student, element));
    }

    // K. sort()
//    public static void sort(Student[] Student) {
//        for (int i = 0; i < Student.length - 1; i++) {
//            if (Student[i] > Student[i + 1]) {
//                int temp = Student[i];
//                Student[i] = Student[i + 1];
//                Student[i + 1] = temp;
//                i = -1;
//            }
//        }
//    }

}
