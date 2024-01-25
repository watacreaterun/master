package com.example.demo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

		@ModelAttribute("small")
		public String addGlobalModelAttributes() {
			return GlobalConstants.COPYRIGHT_TEXT;
		}
}