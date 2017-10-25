package com.didacusabella.mobilesolutions.beans;

public class Gestore
{
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private boolean loggato;
	
	public String getCognome()
	{
		return cognome;
	}
	
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
	public boolean isLoggato()
	{
		return loggato;
	}
	
	public void setLoggato(boolean loggato)
	{
		this.loggato = loggato;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

}
