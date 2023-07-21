package com.library.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="loan")
@Getter
@Setter
@ToString
public class Loan {
	
	@Id
	@Column(name="loan")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loan_id;
	
	private Date loan_deadline;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	
	private String title;
}