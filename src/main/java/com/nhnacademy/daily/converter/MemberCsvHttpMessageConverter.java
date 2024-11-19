package com.nhnacademy.daily.converter;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.createCommand.MemberCreateCommand;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.util.List;

public class MemberCsvHttpMessageConverter extends AbstractHttpMessageConverter<Member> {
    public MemberCsvHttpMessageConverter() {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    protected Member readInternal(Class<? extends Member> clazz, HttpInputMessage inputMessage) throws IOException {
        return null;
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    protected void writeInternal(Member member, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getHeaders().setContentType(MediaType.valueOf("text/csv; charset=UTF-8"));
        try (Writer writer = new OutputStreamWriter(outputMessage.getBody())) {
            writer.write("id,password,name,age,class,locale,role");
            writer.write(System.lineSeparator());
            writer.write(
                    member.getId() + "," +
                    member.getPassword() + "," +
                    member.getName() + "," +
                    member.getAge() + "," +
                    member.getClazz() + "," +
                    member.getLocale() + "," +
                    member.getRole());
        }

    }

}
