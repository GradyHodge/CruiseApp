package com.tts.FinalProjectCruiseApp.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@Lob
	private String description;
	private String creator;
	private boolean status;// get rid of
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date date;
	private Date time;// get rid of
	@Enumerated(value = EnumType.STRING)
	private Priority importance;

}
