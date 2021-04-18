package com.passion4java.service;

import com.passion4java.dao.ContactDao;

/**
 * 
 * @author bhagyac
 *
 */
public class ContactServiceImpl implements ContactService
{
	private ContactDao contactDao;
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	@Override
	public String getNameById(Integer id) 
	{
		String name = contactDao.findNameById(id);
		String formattedName = name.toUpperCase();
		return formattedName;
	}
	
}
