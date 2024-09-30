import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentManagement{
    Student[] students=new Student[100];
    int numOfStudents=0;

    /**
     * check if s1 and s2 have same group
     * @param s1
     * @param s2
     * @return
     */
    public static boolean sameGroup(Student s1, Student s2){
        return s1.getGroup().equals(s2.getGroup());
    }

    public void addStudent(Student newStudent){
        students[numOfStudents]=newStudent;
        numOfStudents++;
    }

    /**
     *
     * @return
     */

    public String studentsByGroup(){
        String result="";
        List<String> listOfGroups=new ArrayList<>();
        for(int i=0;i<numOfStudents;i++){
            if(listOfGroups.contains(students[i].getGroup())){
                continue;
            }
            listOfGroups.add(students[i].getGroup());
        }
        for (String group : listOfGroups) {
            result+=group+"\n";
            for(int j=0;j<numOfStudents;j++){
                if(students[j].getGroup().equals(group)){
                    result+=students[j].getInfo()+"\n";
                }
            }
        }
        return result;
    }

    public void removeStudent(String id){
        for(int i=0;i<numOfStudents;i++){
            if(students[i].getId().equals(id)){
                for(int j=0;j<numOfStudents-1;j++){
                    students[j]=students[j+1];
                }
                break;
            }
        }
        numOfStudents--;
    }

    /**
     * this is method
     * @param args
     */

    public static void main(String[] args) {
        StudentManagement sm= new StudentManagement();
        Student s1= new Student(name:"Nguyen Van An",id:"17020001",email:"17020001@vnu.edu.vn");
        Student s2= new Student(name:"Nguyen Van B",id:"17020002",email:"17020002@vnu.edu.vn");
        s2.setGroup("K62CC");
        Student s3= new Student(name:"Nguyen Van C",id:"17020003",email:"17020003@vnu.edu.vn");
        Student s4= new Student(name:"Nguyen Van D",id:"17020004",email:"17020004@vnu.edu.vn");
        s4.setGroup("K62CC");
        sm.addStudent(s1);
        sm.addStudent(s2);
        sm.addStudent(s3);
        sm.addStudent(s4);
        System.out.println(sm.studentsByGroup());
    }
}