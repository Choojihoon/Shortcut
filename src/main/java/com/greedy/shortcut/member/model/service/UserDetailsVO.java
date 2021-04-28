package com.greedy.shortcut.member.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/* Spring Security 로그인을 위한 UserDetails VO 객체 */
public class UserDetailsVO implements UserDetails {
	
	// 안만들어도 상관없지만 Warning이 발생함
	private static final long SerialVersionUID = 1L;
	
	private String username;	// ID
	private String password;	// PW
	private String name;
	private int no;
	private String gitUrl;
	private List<GrantedAuthority> authorities;
	
	public String getGitUrl() {
		return gitUrl;
	}
	
	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}
	
	public int getNo() {
		return this.no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	// setter
		public void setName(String name) {
			this.name = name;
		}
	
	// setter
	public void setUsername(String username) {
		this.username = username;
	}
	
	// setter
	public void setPassword(String password) {
		this.password = password;
	}
	
	// setter
	public void setAuthorities(List<String> authList) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(int i = 0; i < authList.size(); i++) {
			authorities.add(new SimpleGrantedAuthority(authList.get(i)));
		}
		
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
