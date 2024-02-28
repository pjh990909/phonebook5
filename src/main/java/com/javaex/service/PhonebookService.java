package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	@Autowired
	private PhonebookDao phonebookDao;
	
	
	
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		int count = phonebookDao.personInsert(personVo);
		
		return count;
	}
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		List<PersonVo> personList = phonebookDao.personSelect();
		
		return personList;
	}
	
	public int exeDelete(int personId) {
		System.out.println("PhonebookService.exeDelete()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		int count = phonebookDao.personDelete(personId);
		
		return count;
	}
	
	public PersonVo exeModifyForm(int no) {
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		PersonVo personVo = phonebookDao.personSelectOne(no);
		
		return personVo;
	}
	
	public int exeUpdate(PersonVo personVo) {
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		int count = phonebookDao.personUpdate(personVo);
		
		return count;
	}
}

