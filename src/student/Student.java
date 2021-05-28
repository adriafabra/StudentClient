/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.netbeans.saas.root.Rootwe;
import org.netbeans.saas.RestResponse;

/**
 *
 * @author adri
 */
public class Student {

    /**
     * @param args the command line arguments
     */
    private static Boolean isProfessor = false;
    private static int stID;
    
    public static void main(String[] args) {        
        System.out.println("WELCOME TO MYEXAMS!!\n    A portal where you can upload or download exams and consult your grades\n");
        
        while(true){
            manageAccess();
            Boolean logout = false;

            while(!logout){
                System.out.println("Choose an option:");
                System.out.println("    Select 1: Upload exam");
                System.out.println("    Select 2: Search exam by id");
                System.out.println("    Select 3: Search exam by description");
                System.out.println("    Select 4: Modify exam description");
                System.out.println("    Select 5: Upload exam answers");
                System.out.println("    Select 6: Download exam");
                System.out.println("    Select 7: Delete exam");
                if(isProfessor){
                    System.out.println("    Select 8: Upload grades");
                    System.out.println("    Select 9: Download all grades");
                    System.out.println("    Select 10: LOGOUT");
                    System.out.println("    Select 11: EXIT");
                }
                else{
                    System.out.println("    Select 8: Download grades");
                    System.out.println("    Select 9: LOGOUT");
                    System.out.println("    Select 10: EXIT");
                }

                System.out.print("Choise: ");
                Scanner scan = new Scanner(System.in);
                int input = scan.nextInt();

                switch (input){
                    case 1:
                        uploadExam();
                        break;
                    case 2:
                        searchExamById();
                        break;
                    case 3:
                        searchExamByDescription();
                        break;
                    case 4:
                        modifyExamDescription();
                        break;
                    case 5:
                        uploadExamAnswers();
                        break;
                    case 6:
                        downloadExam();
                        break;
                    case 7:
                        deleteExam();
                        break;
                    case 8:
                        if(isProfessor){
                            uploadGrades();
                        }else{
                            downloadGrades();
                        }
                        break;
                    case 9:
                        if(isProfessor){
                            downloadAllGrades();
                        }else{
                            logout = true;
                            System.out.println("Correctly unlogged\n");
                        }
                        break;
                    case 10:
                        if(isProfessor){
                            logout = true;
                            System.out.println("Correctly unlogged\n");
                        }else{
                            System.exit(0);
                        }
                        break;
                    case 11:
                        if(isProfessor){
                            System.exit(0);
                        }
                        break;
                    default:
                        break;
                }

            }
        }
    }
    
    private static void uploadExam(){
        System.out.print("Introduce questions: ");
        Scanner scan = new Scanner(System.in);
        String questions = scan.nextLine();
        
        System.out.print("Introduce description: ");
        scan = new Scanner(System.in);
        String description = scan.nextLine();
        
        System.out.print("Introduce location: ");
        scan = new Scanner(System.in);
        String location = scan.nextLine();
        
        String answers = "";
        while(true){
            System.out.print("Do you want introduce answers? ");
            scan = new Scanner(System.in);
            String choise = scan.nextLine();
            if(choise.equals("yes")){
                System.out.print("Introduce answers: ");
                scan = new Scanner(System.in);
                String choiseAnswers = scan.nextLine();
                answers = "<answers>" + choiseAnswers + "</answers>";
                break;
            }
            else if(choise.equals("no")){
                break;
            }
        }
                   
        String exam = "<exams>\n" +
                        "<questions>" + questions + "</questions>\n" +
                        "<description>" + description + "</description>\n" +
                        "<location>" + location + "</location>\n" +
                         answers +"\n" +
                      "</exams>";
        
        System.out.println(post("http://localhost:48476/ExamsWeb/webresources/udl.exams", exam));
    }
    
    private static void searchExamById(){
        System.out.print("Introduce ExamID: ");
        Scanner scan = new Scanner(System.in);
        int exId = scan.nextInt();
        
        System.out.println(get("http://localhost:48476/ExamsWeb/webresources/udl.exams/search/" + exId));
    }
    
    private static void searchExamByDescription(){
        System.out.print("Introduce partial or full description: ");
        Scanner scan = new Scanner(System.in);
        String description = scan.nextLine();
       
        System.out.println(get("http://localhost:48476/ExamsWeb/webresources/udl.exams/search/description/" + description.replaceAll(" ", "%20")));
    }
    
    private static void modifyExamDescription(){
        System.out.print("Introduce ExamID: ");
        Scanner scan = new Scanner(System.in);
        int exId = scan.nextInt();
        
        System.out.print("Introduce description: ");
        scan = new Scanner(System.in);
        String description = scan.nextLine();
       
        System.out.println(put("http://localhost:48476/ExamsWeb/webresources/udl.exams/description/" + exId, description));
    }
    
    private static void uploadExamAnswers(){
        System.out.print("Introduce ExamID: ");
        Scanner scan = new Scanner(System.in);
        int exId = scan.nextInt();
        
        System.out.print("Introduce answers: ");
        scan = new Scanner(System.in);
        String answers = scan.nextLine();
       
        System.out.println(put("http://localhost:48476/ExamsWeb/webresources/udl.exams/answers/" + exId, answers));
    }
    
    private static void downloadExam(){
        System.out.print("Introduce ExamID: ");
        Scanner scan = new Scanner(System.in);
        int exId = scan.nextInt();
       
        System.out.println(get("http://localhost:48476/ExamsWeb/webresources/udl.exams/download/" + exId));
    }
    
    private static void deleteExam(){
        System.out.print("Introduce ExamID: ");
        Scanner scan = new Scanner(System.in);
        int exId = scan.nextInt();
       
        System.out.println(delete("http://localhost:48476/ExamsWeb/webresources/udl.exams/" + exId));
    }
    
    private static void uploadGrades(){
        System.out.print("Introduce ExamID: ");
        Scanner scan = new Scanner(System.in);
        int exId = scan.nextInt();
        
        System.out.print("Introduce StudentID: ");
        scan = new Scanner(System.in);
        int stId = scan.nextInt();
        
        int grade;
        while(true){
            System.out.print("Introduce grade: ");
            scan = new Scanner(System.in);
            grade = scan.nextInt();
            if(grade == 0 || grade == 1 || grade == 2 || grade == 3 || grade == 4 || 
               grade == 5 || grade == 6 || grade == 7 || grade == 8 || grade == 9 || grade == 10){
                break;
            }else{
                System.out.println("  Incorrect grade");
            }
        }
       
        String grades = "<grades>\n" +
                          "<grade>" + grade + "</grade>\n" +
                          "<gradesPK>\n" +
                            "<examId>" + exId + "</examId>\n" +
                            "<studentId>" + stId + "</studentId>\n" +
                          "</gradesPK>\n" +
                        "</grades>";
           
        
        System.out.println(post("http://localhost:48476/ExamsWeb/webresources/udl.grades", grades));
    }
    
    private static void downloadGrades(){
        System.out.println(get("http://localhost:48476/ExamsWeb/webresources/udl.grades/grades/" + stID));
    }
    
    private static void downloadAllGrades(){
        System.out.println(get("http://localhost:48476/ExamsWeb/webresources/udl.grades/grades"));
    }
    
    private static void manageAccess(){
        while(true){
            System.out.println("Type LOGIN to enter:");
            System.out.println("If you have not account, type REGISTRY");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
        
            if(input.equals("LOGIN")){                
                System.out.print("Login:\n    StudentID: ");
                scan = new Scanner(System.in);
                stID = scan.nextInt();
                System.out.print("    Password: ");
                scan = new Scanner(System.in);
                String psswd = scan.nextLine();

                String loginReply = put("http://localhost:48476/ExamsWeb/webresources/udl.students/login/" + stID, psswd);
                if(loginReply.equals("LOGGED")){
                    System.out.println("Correctly logged\n");
                    if(stID == 404){
                        isProfessor = true;
                    }
                    break;
                }
                else if(loginReply.equals("UNLOGGED")){
                    System.out.println("User or password are incorrect, please try again\n");
                }  
            }
            else if(input.equals("REGISTRY")){
                String registryReply;
                
                System.out.print("Signup:\n    StudentID: ");
                scan = new Scanner(System.in);
                int stID = scan.nextInt();
                System.out.print("    Password: ");
                scan = new Scanner(System.in);
                String psswd = scan.nextLine();
                
                String registry = "<students>\n" +
                                        "<password>" + psswd + "</password>\n" +
                                        "<studentId>" + stID + "</studentId>\n" +
                                  "</students>";

                registryReply = post("http://localhost:48476/ExamsWeb/webresources/udl.students/signup/", registry);
                if(registryReply.equals("SIGNUP")){
                    System.out.println("Registered successfully\n");
                    break;
                }
                else if(registryReply.equals("NOTSIGNUP")){
                    System.out.println("Choose other ID, this one is already used\n");
                }
                
            }
        }
    }
    
    private static String get(String urlPath) {
        String response = "";
        try{
            URL url = new URL(urlPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("GET");
            
            response = printResponse(httpCon.getInputStream()); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
    
    private static String post(String urlPath, String content) {
        String response = "";
        try{
            URL url = new URL(urlPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");
            httpCon.setRequestProperty("Content-Type", "application/xml");
            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write(content);
            out.close();
            
            response = printResponse(httpCon.getInputStream());             
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
    
    private static String put(String urlPath, String content) {
        String response = "";
        try{
            URL url = new URL(urlPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write(content);
            out.close();
           
            response = printResponse(httpCon.getInputStream());             
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
    
    private static String delete(String urlPath) {
        String response = "";
        try{
            URL url = new URL(urlPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("DELETE");
           
            response = printResponse(httpCon.getInputStream());            
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
    
    private static String printResponse(InputStream inputStream){
        String response = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = br.readLine();
            while (line != null) {
                response = response.concat(line.concat("\n"));
                line = br.readLine();
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return response.substring(0, response.length()-1);//Remove final \n
    }
}
    


