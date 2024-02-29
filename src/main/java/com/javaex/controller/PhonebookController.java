package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;
	
	
	//리스트
		@RequestMapping(value="/phone/list" , method = {RequestMethod.GET,RequestMethod.POST})
		public String list(Model model) {
			System.out.println("PhonebookController.list()");
			
			//PhonebookService phonebookService = new PhonebookService();
			List<PersonVo> personList = phonebookService.exeList();
			
			
			//PhonebookDao phonebookDao = new PhonebookDao();
			
			//List<PersonVo> personList = phonebookDao.personSelect();
			//System.out.println(personList);
			
			model.addAttribute("pList",personList);
			
			return "list";
		}
	
	
	
	
	//등록폼
	//localhost:8080/phonebook5/phone/writeForm
	@RequestMapping(value="/phone/writeform", method = {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm");
		
		return "writeForm";
	}
	
	
	
	//등록2
		//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
		@RequestMapping(value ="/phone/write", method = {RequestMethod.GET,RequestMethod.POST})
		public String write(@ModelAttribute PersonVo personVo) {
			
			System.out.println("PhonebookController.write");
			/*
			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);
			
			//vo 묶는다
			PersonVo personVo = new PersonVo(name,hp,company);
			*/
			System.out.println(personVo.toString());
			
			//서비스를 메모리에 올리고
			//서비스릐 메소드 사용
			
			//자동연결
			//PhonebookService phonebookService = new PhonebookService();
			phonebookService.exeWrite(personVo);
			
			
			
			
			
			return "redirect:/phone/list";
			
			
		}
	
	
	
	//등록
	//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	@RequestMapping(value ="/phone/write2", method = {RequestMethod.GET,RequestMethod.POST})
	public String write2(@RequestParam(value="name") String name,
			@RequestParam(value="hp")String hp,
			@RequestParam(value="company")String company) {
		System.out.println("PhonebookController.write");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		phonebookService.exeWrite2(name,hp,company);
		
		return "redirect:/phone/list";
		
		
	}
	
		/*
		// 수정폼
		// localhost:8080/phonebook5/phone/modifyform
		@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
		public String modifyForm() {
			System.out.println("/phone/modifyForm.jsp");

			return "/WEB-INF/views/modifyForm.jsp";
		}
		*/
		//강사님버전 수정폼
		@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
		public String modifyForm(@RequestParam (value="no") int no, Model model) {
			
			//PhonebookService phonebookService = new PhonebookService();
			
			PersonVo personVo = phonebookService.exeModifyForm(no);
			
			//PhonebookDao phonebookDao = new PhonebookDao();
			
			//PersonVo personVo = phonebookDao.personSelectOne(no);
			
			model.addAttribute("personVo",personVo);
			
			return "/modifyForm";
			
		}
		
		//수정폼2
		@RequestMapping(value = "/phone/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
		public String modifyForm2(@RequestParam (value="no") int no,Model model) {
			System.out.println("PhonebookController.modifyForm2");
			System.out.println(no);
			
			
			Map<String, Object> pMap = phonebookService.exeModifyForm2(no);
			System.out.println(pMap);
			model.addAttribute("pMap",pMap);
			
			return "modifyForm2";
		}
		
		
		
		/*
		// 수정
		@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
		public String modify(@RequestParam(value = "no") int personId, @RequestParam(value = "name") String name,
				@RequestParam(value = "hp") String hp, @RequestParam(value = "company") String company) {
			System.out.println("phonebookController.modify()");

			System.out.println(personId);
			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);

			// vo 묶는다
			PersonVo personVo = new PersonVo(personId, name, hp, company);

			// dao를 메모리에 올린다
			PhonebookDao phonebookDao = new PhonebookDao();
			// dao.personModify(vo) 저장한다
			phonebookDao.personUpdate(personVo);

			// 리스트로 리다이렉트
			return "redirect:/phone/list";
		}
		*/
		
		//강사님버전 수정
		@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
		public String modify(@ModelAttribute PersonVo personVo) {
			System.out.println("phonebookController.modify()");
			
			System.out.println(personVo);
			
			//PhonebookService phonebookService = new PhonebookService();
			phonebookService.exeUpdate(personVo);
			
			//PhonebookDao phonebookDao = new PhonebookDao();
			//phonebookDao.personUpdate(personVo);		
			
			
			return "redirect:/phone/list";
		}
		
		// 삭제
		@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
		public String delete(@RequestParam(value = "no") int personId) {
			
			System.out.println("phonebookController.delete()");

			System.out.println(personId);
			
			//PhonebookService phonebookService = new PhonebookService();
			phonebookService.exeDelete(personId);
			
			// dao를 메모리에 올린다
			//PhonebookDao phonebookDao = new PhonebookDao();
			
			// dao.personModify(vo) 저장한다
			//phonebookDao.personDelete(personId);

			// 리스트로 리다이렉트
			return "redirect:/phone/list";
			
		}
}
