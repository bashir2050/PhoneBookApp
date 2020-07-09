package com.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Data

@Entity
@Table(name="CONTACT")
public class ContactEntity {
	@Id
	
	@SequenceGenerator(name="cid_seq_gen",sequenceName = "CONTACT_ID_SEQ",allocationSize = 1)
	@GeneratedValue(generator = "cid_seq_gen",strategy=GenerationType.SEQUENCE)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACTNAME")
	private String contactName;
	@Column(name="CONTACTEMAIL")
	private String contactEmail;
	@Column(name="CONTACTNUMBER")
	private Long contactNumber;
	
	@CreationTimestamp
	@Column(name="CREATEDDATE")
	private Date createdDate;
	@UpdateTimestamp
	@Column(name="UPDATEDDATE")
	private Date updatedDate;

}
