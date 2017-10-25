package com.didacusabella.mobilesolutions.beans;

public class Vendite
{
	private String idvendita;
	private String data;
	private String marca;
	private String modello;
	private String prezzo;
	private String username;
	
	public String getData()
	{
		return data;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public String getIdvendita()
	{
		return idvendita;
	}
	
	public void setIdvendita(String idvendita)
	{
		this.idvendita = idvendita;
	}

	public String getMarca()
	{
		return marca;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public String getModello()
	{
		return modello;
	}
	
	public void setModello(String modello)
	{
		this.modello = modello;
	}
	
	public String getPrezzo()
	{
		return prezzo;
	}
	
	public void setPrezzo(String prezzo)
	{
		this.prezzo = prezzo;
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
