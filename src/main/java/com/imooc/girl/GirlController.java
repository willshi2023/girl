package com.imooc.girl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class GirlController {
	@Autowired
	private GirlRepository girlRepository;

	@Autowired
	private  GirlService girlService;
	/**
	 * 查询所有女生列表
	 * @return List<Girl>
	 */
	@GetMapping("/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}

	/**
	 * 新增一个girl
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping("/girls")
	public Girl girlAdd(@RequestParam("cupSize") String cupSize,
	@RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);

		return girlRepository.save(girl);
	}

	/**
	 * 查询一个女生
	 */
	@GetMapping("/girls/{id}")
	public Girl findOne(@PathVariable("id") Integer id){
		return girlRepository.findOne(id);
	}

	/**
	 * 更新一个女生
	 */
	@PutMapping("/girls/{id}")
	public  Girl girlUpdate(@PathVariable("id") Integer id,
							@RequestParam("cupSize") String cupSize,
							@RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return  girlRepository.save(girl);
	}
	/**
	 * 删除一个女生
	 */
	@DeleteMapping("/girls/{id}")
	public  void girlDelete(@PathVariable("id") Integer id){
		 girlRepository.delete(id);
	}

	/**
	 * 通过年龄查询女生列表
	 */
	@GetMapping("/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}

	/**
	 * 同时插入两个女生
	 */
	@PostMapping("/girls/two")
	public  void girlTow(){
		girlService.insertTow();
	}

}
