package com.wangyonglin.restul.validator;


import com.wangyonglin.restul.entity.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    /**
     * 校验逻辑
     *
     * @param obj    校验对象
     * @param errors 错误对象
     */
    @Override
    public void validate(Object obj, Errors errors) {
        // 校验name是否为空
        // 在static rejectIfEmpty(..)对方法ValidationUtils类用于拒绝该name属性，如果它是null或空字符串
        ValidationUtils.rejectIfEmpty(errors, "name", "name不能为空");
        // 校验年龄只能在0-110之间
        Person p = (Person) obj;
        if (p.getAge() < 1) {
            errors.rejectValue("age", "年龄不能小于1");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age", "年龄不能大于110");
        }
    }

}
