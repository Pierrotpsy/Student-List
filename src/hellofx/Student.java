package hellofx;

import java.time.LocalDate;

import org.apache.commons.validator.routines.EmailValidator;

public class Student {

	private int Id;
	private String Name;
	private String Gender;
	private String Email;
	private LocalDate Birthdate;
	private String Photo;
	private double Mark;
	private String Comments;
	
	private EmailValidator validator = EmailValidator.getInstance();
	
	public Student(int Id, String Name, String Gender, String Email, LocalDate Birthdate, String Photo, double Mark, String Comments) {
		this.Id = Id;
		this.Name = Name;
		this.Gender = Gender;
		this.setEmail(validator.isValid(Email) ? Email : "null@null.com");
		
		this.Birthdate = (Birthdate.getYear() >= 1980 && Birthdate.getYear() <= 2000) ? Birthdate : LocalDate.now();
		this.Photo = Photo;
		this.Mark = Mark;
		this.Comments = Comments;
	}
	
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public boolean setGender(String Gender) {
		if(Gender == "Male" || Gender == "Female") {
			this.Gender = Gender;
			return true;
		}
		return false;
	}
	
	public String getEmail() {
		return Email;
	}

	public boolean setEmail(String Email) {
		if(validator.isValid(Email)) {
			this.Email = Email;
			return true;
		}
		return false;
	}

	public LocalDate getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		Birthdate = birthdate;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public double getMark() {
		return Mark;
	}

	public void setMark(double mark) {
		Mark = mark;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String toString() {
		return this.Name;
	}
}
