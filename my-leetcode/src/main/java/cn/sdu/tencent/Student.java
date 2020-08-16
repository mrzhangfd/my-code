package cn.sdu.tencent;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student {
    private HashMap<String,Student> nameTostudentMap=new HashMap<>();
    private HashMap<String,List<String>> collegeIdTostudentsMap=new HashMap<>();
    private HashMap<String,List<String>> majorIdTostudentsMap=new HashMap<>();
    private HashMap<String,List<String>> gradeIdTostudentsMap=new HashMap<>();
    private String name;
    private String collegeId;
    private String majorId;
    private String gradeId;

    public Student(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s = null;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String[] split = s.split(" ");
            Student student = new Student(split[0], split[1], split[2], split[3]);
            nameTostudentMap.put(student.name,student);
            //学院
            processMap(collegeIdTostudentsMap,student.getCollegeId(),student.getName());

            //专业
            processMap(majorIdTostudentsMap,student.getmajorId(),student.getName());

            //年级
            processMap(gradeIdTostudentsMap,student.getGradeId(),student.getName());
        }
        br.close();
    }
    private void processMap(HashMap<String,List<String>> map,String key,String value){
        List<String> studentsName = new ArrayList<>();
        if(map.containsKey(key)){
            studentsName = map.get(key);
        }
        studentsName.add(value);
        map.put(key,studentsName);
    }

    public Student(String name, String collegeId, String majorId, String gradeId) {
        this.name = name;
        this.collegeId = collegeId;
        this.majorId = majorId;
        this.gradeId = gradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getmajorId() {
        return majorId;
    }

    public void setmajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGrade(String gradeId) {
        this.gradeId = gradeId;
    }
    Pair<String,String> getStudentInfo(String strName)
    {
        Student student = nameTostudentMap.get(strName);
        return new Pair<String,String>(student.getCollegeId(), student.getmajorId());

    };
    List<String> getMembersOfCollege(String strCollegeId)
    {
        return collegeIdTostudentsMap.get(strCollegeId);

    };
    //获取某专业的所有学生
    List<String> getMembersOfMajor(String strMajorId)
    {
        return majorIdTostudentsMap.get(strMajorId);
    };
    List<String> getMembersOfGrade(String strGradeId){
        return gradeIdTostudentsMap.get(strGradeId);
    }

    public static void main(String[] args) throws IOException {

        URL resource = Student.class.getResource("student.txt");
        InputStream resourceAsStream = Student.class.getResourceAsStream("");

        System.out.println(resourceAsStream);
        //System.out.println(resource);
        String path = resource.getPath();

        Student student = new Student(path);
        System.out.println(student.getStudentInfo("lark"));
        System.out.println(student.getMembersOfGrade("2019"));
        System.out.println(student.getMembersOfCollege("10"));
        System.out.println(student.getMembersOfMajor("101"));


    }
}
