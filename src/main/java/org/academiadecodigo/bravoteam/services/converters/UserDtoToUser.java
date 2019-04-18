package org.academiadecodigo.bravoteam.services.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.academiadecodigo.bravoteam.services.Command.UserDto;
import org.academiadecodigo.bravoteam.services.Model.User;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUser implements Converter<UserDto, User> {


    @Override
    public Object convert(Object o) {
        return null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
