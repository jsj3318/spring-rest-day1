package com.nhnacademy.daily.converter;

import com.nhnacademy.daily.model.Member;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

public class MemberListCsvHttpMessageConverter extends AbstractHttpMessageConverter<List<Member>> {
    public MemberListCsvHttpMessageConverter() {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return List.class.isAssignableFrom(clazz);
    }

    @Override
    protected List<Member> readInternal(Class<? extends List<Member>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected boolean canRead(MediaType mediaType) {
        return false;
    }

    @Override
    protected void writeInternal(List<Member> members, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getHeaders().setContentType(MediaType.valueOf("text/csv; charset=UTF-8"));
        try (Writer writer = new OutputStreamWriter(outputMessage.getBody())) {
            writer.write("id,password,name,age,class,locale,role");
            writer.write(System.lineSeparator());
            for(Member member : members) {
                writer.write(
                        member.getId() + "," +
                                member.getPassword() + "," +
                                member.getName() + "," +
                                member.getAge() + "," +
                                member.getClazz() + "," +
                                member.getLocale() + "," +
                                member.getRole());
                writer.write(System.lineSeparator());
            }

        }
    }
}
