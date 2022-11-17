package hellofx;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBManager {
	
	public List<Student> loadStudents(){
		List<Student> studentAll= new ArrayList<Student>();
		Connection myConn= this.Connector();
		try {
		 Statement myStmt= myConn.createStatement();
		 String sql = "select * from students";
		 ResultSet myRs= myStmt.executeQuery(sql);
		 while (myRs.next()) {
			 Student s= new Student(myRs.getInt("id"),myRs.getString("name"),myRs.getString("gender"), myRs.getString("email"), LocalDate.parse(myRs.getString("birth")), myRs.getString("photo"), myRs.getDouble("mark"), myRs.getString("comments"));
	
			 studentAll.add(s);
		 }
		 this.close(myConn, myStmt, myRs);
		 return studentAll;
		} catch (SQLException e) {

		 e.printStackTrace();
		}
		return null;
	}
	
	public Connection Connector(){
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "test","password");
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
		if(myStmt!=null)
			myStmt.close();
		if(myRs!=null)
			myRs.close();
		if(myConn!=null)
			myConn.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void addStudent(Student student){
		 Connection myConn=null;
		 PreparedStatement myStmt = null;
		 ResultSet myRs= null;
		 try {
			 myConn = this.Connector();
			 String sql = "INSERT INTO students (id,name,gender,email,birth,photo,mark,comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			 myStmt = myConn.prepareStatement(sql);
			 myStmt.setInt(1, student.getId());
			 myStmt.setString(2, student.getName());
			 myStmt.setString(3, student.getGender());
			 myStmt.setString(4, student.getEmail());
			 myStmt.setDate(5, java.sql.Date.valueOf(student.getBirthdate()));
			 myStmt.setString(6, student.getPhoto());
			 myStmt.setDouble(7, student.getMark());
			 myStmt.setString(8, student.getComments());
			 myStmt.execute();
			 System.out.println("new");
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
		 }
		 finally{
			 close(myConn,myStmt,myRs);
		 }
	}
	
	public void updateStudent(Student student){
		 Connection myConn=null;
		 PreparedStatement myStmt = null;
		 ResultSet myRs= null;
		 try {
			 myConn = this.Connector();
			 String sql = "UPDATE students SET name = ?, gender = ?, email = ?, birth = ?, photo = ?, mark = ?, comments = ? WHERE id = ?";
			 myStmt = myConn.prepareStatement(sql);
			 myStmt.setString(1, student.getName());
			 myStmt.setString(2, student.getGender());
			 myStmt.setString(3, student.getEmail());
			 myStmt.setDate(4, java.sql.Date.valueOf(student.getBirthdate()));
			 myStmt.setString(5, student.getPhoto());
			 myStmt.setDouble(6, student.getMark());
			 myStmt.setString(7, student.getComments());
			 myStmt.setInt(8, student.getId());
			 myStmt.execute();
			 System.out.println("edit");
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
		 }
		 finally{
			 close(myConn,myStmt,myRs);
		 }
	}
	
	public void deleteStudent(int id){
		 Connection myConn=null;
		 PreparedStatement myStmt = null;
		 ResultSet myRs= null;
		 try {
			 myConn = this.Connector();
			 String sql = "DELETE FROM students WHERE id = ?";
			 myStmt = myConn.prepareStatement(sql);
			 myStmt.setInt(1, id);
			 myStmt.execute();
			 System.out.println("del");
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
		 }
		 finally{
			 close(myConn,myStmt,myRs);
		 }
	}

	public double meanMarks() {
		Connection myConn= this.Connector();
		try {
		 Statement myStmt= myConn.createStatement();
		 String sql = "select avg(mark) from students";
		 ResultSet myRs= myStmt.executeQuery(sql);
		 myRs.next();
		 double avg = myRs.getDouble(1);
		 this.close(myConn, myStmt, myRs);
		 return avg;
		} catch (SQLException e) {

		 e.printStackTrace();
		}
		return -1.0;
		 
	}
}
