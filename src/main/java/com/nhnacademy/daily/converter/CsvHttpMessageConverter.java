package com.nhnacademy.daily.converter;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.createCommand.MemberCreateCommand;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import com.nhnacademy.daily.model.type.Role;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;

public class CsvHttpMessageConverter extends AbstractHttpMessageConverter<MemberCreateCommand> {
    public CsvHttpMessageConverter() {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return MemberCreateCommand.class.isAssignableFrom(clazz);
    }

    @Override
    protected MemberCreateCommand readInternal(Class<? extends MemberCreateCommand> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        //id,password,name,age,class,locale,role
        //jsj,1234,조승주,25,A,KO,member

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputMessage.getBody()))) {
            String header = bufferedReader.readLine();
            String body = bufferedReader.readLine();
        if( header != null && body != null ) {
            String[] info = body.split(",");
            if(info.length == 7){
            return new MemberCreateCommand(
                    info[0],
                    info[1],
                    info[2],
                    Integer.parseInt(info[3]),
                    ClassType.fromString(info[4]),
                    Locale.fromString(info[5]),
                    Role.forValue(info[6]));
            }
        }
        } catch (Exception e) {
            throw new HttpMessageNotReadableException(e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected boolean canRead(MediaType mediaType) {
        return mediaType != null && mediaType.getSubtype().equals("csv");
    }

    @Override
    protected void writeInternal(MemberCreateCommand member, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

}
