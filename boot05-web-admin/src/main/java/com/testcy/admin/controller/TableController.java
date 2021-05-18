package com.testcy.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.testcy.admin.Service.AccountService;
import com.testcy.admin.Service.UserService;
import com.testcy.admin.bean.Account;
import com.testcy.admin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/basic_table")
    public String basicTable() {
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String delteUser(@PathVariable("id") long id,
                            @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                            RedirectAttributes redirectAttributes) {
        accountService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn",defaultValue ="1") Integer pn,
                               Model model) {
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123456"),
//                new User("Curry", "123456"),
//                new User("Tom", "123456"));

        List<Account> users = accountService.list();
//        model.addAttribute("users", users);
        Page<Account> userPage = new Page<>(pn, 2);
        Page<Account> page = accountService.page(userPage, null);
        model.addAttribute("users", page);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editableTable() {
        return "table/editable_table";
    }

    @GetMapping("pricing_table")
    public String pricingTable() {
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable() {
        return "table/responsive_table";
    }

}
