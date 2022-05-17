package class1;

import java.util.Arrays;

public class MyArray {
    private Student[] students = new Student[100];
    private int totalStudents = 0;

    public void add(Student student){
        ensureSize();
        students[totalStudents] = student;
        totalStudents++;
    }

    public void addAt(int index, Student student){
        ensureSize();
        if(!validIndexToAdd(index))
            throw new IllegalArgumentException("Invalid index");

        for (int i = totalStudents; i >= index; i--) {
            students[i+1] = students[i];
        }
        students[index] = student;
        totalStudents++;
    }

    private void ensureSize(){
        if (totalStudents == students.length){
            Student[] newStudents = new Student[students.length * 2];
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }
            this.students = newStudents;
        }
    }

    private boolean validIndexToAdd(int index){
        return index >= 0 && index <= totalStudents;
    }

    public Student get(int index){
        if(!indexExists(index))
            throw new IllegalArgumentException("Invalid index");

        return students[index];
    }

    private boolean indexExists(int index){
        return index >= 0 && index < totalStudents;
    }

    public void remove(int index){
        if(!indexExists(index))
            throw new IllegalArgumentException("Invalid index");

        for (int i = index; i <= totalStudents; i++) {
            this.students[i] = this.students[i+1];
        }

        students[totalStudents] = null;
        totalStudents--;
    }

    public boolean contains(Student student){
        for (int i = 0; i < totalStudents; i++) {
            if (student.equals(students[i]))
                return true;
        }
        return false;
    }

    public int size(){
        return totalStudents;
    }

    public String toString(){
        return Arrays.toString(students);
    }
}
