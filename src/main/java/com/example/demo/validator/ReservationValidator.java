package com.example.demo.validator;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.ReservationForm;
import com.example.demo.util.DateTimeUtils;

@Component
public class ReservationValidator implements Validator {
    // 名前の正規表現パターン
    private static final String NAME_PATTERN = "^[ぁ-んァ-ン一-龯a-zA-Z'-]+$";
    private Pattern namePattern;
    // 電話番号の正規表現パターン
    private static final String PHONE_PATTERN
    = "^((0\\d{1,4}-?\\d{1,4}-?\\d{4})|0\\d{9})$";
    private Pattern phonePattern;

    public ReservationValidator() {
        namePattern = Pattern.compile(NAME_PATTERN);
        phonePattern = Pattern.compile(PHONE_PATTERN);
    }

	@Override
	public boolean supports(Class<?> clazz) {
		return ReservationForm.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ReservationForm reservationForm = (ReservationForm) target;
		
        LocalDate currentDate = LocalDate.now();
        LocalDate reserveDate = DateTimeUtils.parseDate(reservationForm.getReserveDate());
        if (reserveDate != null && reserveDate.isBefore(currentDate)) {
            errors.rejectValue("reserveDate", "invalidDate", "過去の日付は予約できません");
        }

        // commentが100文字を超える場合
        if (reservationForm.getComment() != null && reservationForm.getComment().length() > 100) {
            errors.rejectValue("comment", "commentTooLong", "コメントは100文字以下にしてください");
        }
        
        // commentが100文字を超える場合
        if (reservationForm.getCustomerName() != null && reservationForm.getCustomerName().length() > 50) {
        	errors.rejectValue("customerName", "customerNameTooLong", "お名前は50文字以下にしてください");
        }

        // 名前のバリデーション
        if (!namePattern.matcher(reservationForm.getCustomerName()).matches()) {
            errors.rejectValue("customerName", "invalidName", "別のお名前を使用してください");
        }
        
        // 電話番号のバリデーション
        if (!phonePattern.matcher(reservationForm.getPhone()).matches()) {
        	errors.rejectValue("phone", "invalidPhone", "別の電話番号を使用してください");
        }
    }
}
