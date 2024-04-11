package com.springcourse.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcourse.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 75, nullable = false)
	private String name;
	
	@Column(length = 75, nullable = false)
	private String email;

	@Getter(onMethod_ = @__({@JsonIgnore}))
	@Setter(onMethod_ = @__({@JsonProperty}))
	@Column(length = 75, nullable = false)
	private String password;
	
	@Column(length = 75, nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@Getter(onMethod_ = @__({@JsonIgnore}))
	@OneToMany(mappedBy = "owner")
	private List<Request> requests = new ArrayList<>();

	@Getter(onMethod_ = @__({@JsonIgnore}))
	@OneToMany(mappedBy = "owner")
	private List<RequestStage> stages = new ArrayList<>();
}
