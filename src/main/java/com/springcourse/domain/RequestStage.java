package com.springcourse.domain;

import java.util.Date;

import com.springcourse.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStage {
	private Long id;
	private Date realizationDate;
	private String description;
	private RequestState state;
	private User user;
}
