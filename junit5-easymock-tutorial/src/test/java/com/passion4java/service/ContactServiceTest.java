package com.passion4java.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import com.passion4java.dao.ContactDao;

public class ContactServiceTest 
{
	@Test
	public void testGetNameById() 
	{
		//proxy object generated at runtime
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class); 
		
		//setting behaviour for proxy object
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Bhagyashri");
		
		EasyMock.expect(daoProxy.findNameById(102)).andReturn("RD");
		
		// save this behaviour
		EasyMock.replay(daoProxy);
		
		ContactServiceImpl service = new ContactServiceImpl();
		service.setContactDao(daoProxy);
		String name = service.getNameById(101);
		assertNotNull(name);
	}
}
