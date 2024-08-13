package com.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class singUpDTO {
  
	private int userNo; 
	private String userNm ;		 
	private String userId ;		 
	private String userPwd;		 
	private String userEmail;		 
	private String userRole	;	 
	
}

	
