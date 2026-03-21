package com.ecommerce.models;



public class UserDTO {
    private String username;

    private String password;

    private String emailId;
    
    private String message;

    // Default Constructor
    public UserDTO() {
    }

    // Parameterized Constructor
    public UserDTO(String username, String password, String emailId) {
        this.username = username;
        this.password = password;
        this.emailId = emailId;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailId() {
        return emailId;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", emailId=" + emailId + ", message="
				+ message + "]";
	}

	
   
}