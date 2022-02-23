
package datastructureproject;

public class Node {
    private Node left;
    private int student_number;
    private String student_name;
    private String student_surname;
    private Node right;
    
    static int number_of_student = -1;

    public Node(Node l, Node r, int sn, String sname, String ssurname) {
        left = l;
        student_number = sn;
        student_name = sname;
        student_surname = ssurname;
        right = r;
        
        number_of_student += 1;
    }   
    
    public Node(){
        left=null;
        right = null ;
        student_name = "";
        student_surname = "";
        student_number = -1;
        
        number_of_student += 1;
    }
    
    public static int getNumber_of_student() {
        return number_of_student;
    }

    public static void setNumber_of_student(int number_of_student) {
        Node.number_of_student = number_of_student;
    }
    
    public Node getLeft() {
        return left; 
    }
    
    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_number() {
        return student_number;
    }

    public String getStudent_surname() {
        return student_surname;
    }
    
    public Node getRight(){
        return right; 
    }

    public void setLeft(Node newLeft){
        left = newLeft; 
    }

    public void setRight(Node newRight){
        right = newRight; 
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }
 
}
