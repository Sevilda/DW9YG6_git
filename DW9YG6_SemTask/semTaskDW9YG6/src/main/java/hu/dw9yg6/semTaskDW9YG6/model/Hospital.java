package hu.dw9yg6.semTaskDW9YG6.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital_db")
public class Hospital {
	
	//@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="roomid")
	@Id
	private Integer roomID;
	private String ward;
	private Integer floor;
	@Column(name="patientname")
	private String patientName;
	@Column(name="doctorname")
	private String doctorName;
	@Column(name="admissiondate")
	private Date admissionDate;
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "Hospital [roomID=" + roomID + ", ward=" + ward + ", floor=" + floor + ", patientName=" + patientName
				+ ", doctorName=" + doctorName + ", admissionDate=" + admissionDate + "]";
	}
}
