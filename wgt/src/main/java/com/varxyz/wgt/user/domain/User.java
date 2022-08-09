package com.varxyz.wgt.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private String addr;
}
