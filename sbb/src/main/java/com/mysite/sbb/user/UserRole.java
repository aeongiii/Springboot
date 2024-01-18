package com.mysite.sbb.user;

import lombok.Getter;

// enum (열거) 자료형으로 작성됨

@Getter	// 상수의 값을 변경할 필요는 없으므로 Setter는 필요 없음
public enum UserRole {
	// ADMIN, USER라는 상수를 만들고 각각 값("") 부여
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}
