package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<PersonVo> personSelect() {

		System.out.println("phonebookdao.personSelect");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		System.out.println(personList);
		return personList;
	}

	// 등록
	public int personInsert(PersonVo personVo) {

		System.out.println("phonebookdao.personInsert");

		int count = sqlSession.insert("phonebook.insert", personVo);
		return count;
	}

	// 등록2
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("phonebookdao.personInsert2");
		System.out.println(pMap);

		int count = sqlSession.insert("phonebook.insert2", pMap);

		return count;
	}

	// 1개 가져오기(수정폼)
	public PersonVo personSelectOne(int no) {

		System.out.println("phonebookdao.personSelectOne");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		return personVo;
	}
	//1개 가져오기 2
	public Map<String, Object> personSelectOne2(int no) {

		System.out.println("phonebookdao.personSelectOne2");
		
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne2", no);
		/*
		System.out.println(pMap.get("person_id"));
		System.out.println(pMap.get("name"));
		System.out.println(pMap.get("hp"));
		System.out.println(pMap.get("company"));
		*/
		return pMap;
	}

	// 수정
	public int personUpdate(PersonVo personVo) {

		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		return count;
	}

	// 삭제
	public int personDelete(int no) {

		int count = sqlSession.delete("phonebook.delete", no);

		return count;
	}

}
