package org.example.common;

import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
@Component
public class GlobalFunction {
    public String checkRequired(Checkable checkable, Object object) throws NoSuchFieldException, IllegalAccessException {
        for (String str : checkable.getRequired()
             ) {
            Field field = object.getClass().getDeclaredField(str);
            field.setAccessible(true);
            if (field.get(object)==null)
                return str + " не заполнено";
        }
        return "OK";
    }
}
