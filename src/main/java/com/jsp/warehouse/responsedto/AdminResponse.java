package com.jsp.warehouse.responsedto;

import com.jsp.warehouse.enums.AdminType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminResponse {
	private int adminId;
	private String adminName;
	private String adminEmail;
	private AdminType adminType;
}