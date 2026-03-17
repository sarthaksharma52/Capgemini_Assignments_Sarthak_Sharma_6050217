package cg.demo.associationMapping;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class IndianPassport {
	@Id
	private int passportNo;
	private LocalDate passportExpireData;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Citizen citizen;
	
	public int getPassportNo() {
		return passportNo;
	}
	
	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	
	public LocalDate getPassportExpireData() {
		return passportExpireData;
	}
	
	public void setPassportExpireData(LocalDate passportExpireData) {
		this.passportExpireData = passportExpireData;
	}
	
}
