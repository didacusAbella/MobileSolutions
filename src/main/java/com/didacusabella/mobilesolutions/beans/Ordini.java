package com.didacusabella.mobilesolutions.beans;

public class Ordini
{   private String data;
    private String idordine;
    private String datainoltro;
	private String modalitaSpe;
	private String modalitaPay;
	private String totalepag;
	private String username;
	public String getData()
	{
		return data;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	public String getDataInoltro()
	{
		return datainoltro;
	}
	
	public void setDataInoltro(String datainoltro)
	{
		this.datainoltro = datainoltro;
	}
	public String getIdordine()
	{
		return idordine;
	}
	
	public void setIdordine(String idordine)
	{
		this.idordine = idordine;
	}

	public String getModalitaSpe()
	{
		return modalitaSpe;
	}
	
	public void setModalitaSpe(String modalitaSpe)
	{
		this.modalitaSpe = modalitaSpe;
	}
	public String getModalitaPay()
	{
		return modalitaPay;
	}
	
	public void setModalitaPay(String modalitaPay)
	{
		this.modalitaPay = modalitaPay;
	}
	public String getTotalePag()
	{
		return totalepag;
	}
	
	public void setTotalePag(String totalepag)
	{
		this.totalepag = totalepag;
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
