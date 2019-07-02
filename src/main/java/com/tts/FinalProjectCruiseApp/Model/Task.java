package com.tts.FinalProjectCruiseApp.Model;

import javax.persistence.Entity;

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
	private Long id;
	private String title;
	private String description;
	private String creator;
	private String status;
	private String id;

}
