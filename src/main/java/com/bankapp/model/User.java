package com.bankapp.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String role;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String username, String password, String email, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}
    
    
    
    // Getters and Setters
}

