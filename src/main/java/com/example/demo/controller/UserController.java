package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private UserService userService;

	/**
	 * ユーザー情報検索画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/search")
	public String displaySearch(Model model) {
		model.addAttribute("userSearchRequest", new UserSearchRequest());
		return "user/search";
	}

	/**
	   * ユーザー情報一覧画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";

	}

	/**
	   * ユーザー新規登録画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		return "user/add";
	}

	/**
	   * ユーザー情報詳細画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("userData", user);
		return "user/view";
	}

	/**
	 * ユーザー情報検索
	 * @param userSearchRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
	public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
		List<User> userList = userService.searchAll();
		model.addAttribute("userList", userList);
		return "user/list";

	}
}