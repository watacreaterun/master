package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ReservationForm;
import com.example.demo.validator.ReservationValidator;

import jakarta.validation.Valid;

@Controller
public class ConfirmController {
	
    private final ReservationValidator reservationValidator;

    public ConfirmController(ReservationValidator reservationValidator) {
        this.reservationValidator = reservationValidator;
    }

    // リクエストパラメータの型変換を行うたtめのBinderの設定
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // ここに型変換の設定を記述（LocalDateとLocalTimeの設定がある場合はそのまま残しておく）
    }

    @PostMapping("/confirm")
    public String confirmForm(@Valid ReservationForm reservationForm, BindingResult bindingResult, Model model) {
        // バリデーションを実行
        reservationValidator.validate(reservationForm, bindingResult);

        if (bindingResult.hasErrors()) {
        	List<String> errors = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("reservationForm", reservationForm); // エラー時にもフォームの内容を返す
            return "reserve";
        }

        model.addAttribute("reservationForm", reservationForm);
        // 予約確認画面にリダイレクト
        return "confirm";
    }
    
    @PostMapping("/reserve_update_confirm")
    public String reserveUpdateConfirmForm(@Valid ReservationForm reservationForm, BindingResult bindingResult, Model model) {
    	// バリデーションを実行
    	reservationValidator.validate(reservationForm, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		List<String> errors = new ArrayList<>();
    		for (ObjectError error : bindingResult.getAllErrors()) {
    			errors.add(error.getDefaultMessage());
    		}
    		
    		model.addAttribute("errors", errors);
    		model.addAttribute("reservationForm", reservationForm); // エラー時にもフォームの内容を返す
    		return "reserve";
    	}
    	
    	model.addAttribute("reservationForm", reservationForm);
    	// 予約確認画面にリダイレクト
    	return "reserve_update_confirm";
    }
}
