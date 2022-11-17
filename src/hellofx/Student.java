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
	
	/**
	 * Simple constructor for Student object.
	 * @param Id
	 * @param Name
	 * @param Gender
	 * @param Email
	 * @param Birthdate
	 * @param Photo
	 * @param Mark
	 * @param Comments
	 */
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
	
	/**
	 * Getter for Student id.
	 * @return Id
	 */
	public int getId() {
		return this.Id;
	}
	
	/**
	 * Getter for Student name.
	 * @return Id
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * Getter for Student gender.
	 * @return Gender
	 */
	public String getGender() {
		return this.Gender;
	}

	/**
	 * Getter for Student email.
	 * @return Email
	 */
	public String getEmail() {
		return this.Email;
	}

	/**
	 * Getter for Student birth date.
	 * @return Birthdate
	 */
	public LocalDate getBirthdate() {
		return this.Birthdate;
	}

	/**
	 * Getter for Student photo path.
	 * @return Photo
	 */
	public String getPhoto() {
		return this.Photo;
	}

	/**
	 * Getter for Student mark.
	 * @return Mark
	 */
	public double getMark() {
		return this.Mark;
	}

	/**
	 * Getter for Student comments.
	 * @return Comments
	 */
	public String getComments() {
		return this.Comments;
	}
	
	/**
	 * Setter for Student id.
	 * @param Id
	 */
	public void setId(int Id) {
		this.Id = Id;
	}
	
	/**
	 * Setter for Student name.
	 * @param Name
	 */
	public void setName(String Name) {
		this.Name = Name;
	}
	
	/**
	 * Setter for Student gender.
	 * @param Gender
	 */
	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	/**
	 * Setter for Student email.
	 * @param Email
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}

	/**
	 * Setter for Student birthdate.
	 * @param Birthdate
	 */
	public void setBirthdate(LocalDate Birthdate) {
		this.Birthdate = Birthdate;
	}

	/**
	 * Setter for Student photo.
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.Photo = photo;
	}

	/**
	 * Setter for Student mark;
	 * @param mark
	 */
	public void setMark(double Mark) {
		this.Mark = Mark;
	}

	/**
	 * Setter for Student comments.
	 * @param comments
	 */
	public void setComments(String comments) {
		this.Comments = comments;
	}

	/**
	 * toString method for the Student class.
	 */
	@Override
	public String toString() {
		return this.Name;
	}
}
