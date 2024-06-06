package com.jsp.warehouse.enums;

import java.util.List;

public enum AdminType {
	SUPER_ADMIN(List.of(
			Privilege.CREATE_WAREHOUSE,Privilege.CREATE_ADMIN,Privilege.CREATE_ADDRESS,
			Privilege.CREATE_STORAGE,Privilege.READ,Privilege.UPDATE_WAREHOUSE,
			Privilege.UPDATE_ADMIN,Privilege.UPDATE_ADDRESS,Privilege.UPDATE_STORAGE,
			Privilege.DEL_WAREHOUSE,Privilege.DEL_ADMIN,Privilege.DEL_ADDRESS,Privilege.DEL_STORAGE)),
	
	ADMIN(List.of(Privilege.CREATE_STORAGE,Privilege.READ,Privilege.UPDATE_ADMIN,
			Privilege.UPDATE_STORAGE,Privilege.DEL_STORAGE));
	
	private List<Privilege> privileges;

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	AdminType(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}
