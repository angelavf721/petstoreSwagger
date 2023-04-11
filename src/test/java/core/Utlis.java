package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static io.restassured.http.ContentType.MULTIPART;

public class Utlis {

    public static Object getID(){
        return RestAssured.get( "/pet/findByStatus?status=pending").then().extract().path("id[0]");
    }
    public static RequestSpecification multipartReqSpec() {
        return new RequestSpecBuilder()
                .setContentType(MULTIPART)
                .build();
    }
    public static String dataDiferencaDias(Integer qtdDias){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,qtdDias);
        return getDataFormatada(cal.getTime());
    }

    public static String getDataFormatada(Date data){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }
}
