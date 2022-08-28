package com.example.lecture_spring_2_crudproject.service.openAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

@Service
public class PublicAPI {

    void testAPI() {
        String key = "%2Fk49W4UhNTuGlvyhZ6NCaHVhV1%2BBp0wbhWy0YjmvKgHQSFbVPwQqzw4ppSYg8O9ubHyLPYi8N%2F0e4yGvEQKGug%3D%3D";

        // 파싱한 데이터를 저장할 변수
        String bfResult = "";
        String brResult="";
        StringBuilder sb=new StringBuilder();

        try {

            URL url = new URL("https://apis.data.go.kr/B551177/BusInformation/getBusInfo?serviceKey="
                    + key + "&numOfRows=10&pageNo=1&area=1&type=json");

//            BufferedReader bf;
//            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//            bfResult = bf.readLine();

            HttpURLConnection con =(HttpURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));

            while((brResult=br.readLine())!=null) {
                sb.append(brResult);
                System.out.println(brResult);
            }
            br.close();
            con.disconnect();

            Gson gson=new Gson();
//            AirLineList flightInfo=gson.fromJson(sb.toString(), AirLineList.class);

//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
//            JSONObject movieInfoResult = (JSONObject)jsonObject.get("movieInfoResult");
//            JSONObject movieInfo = (JSONObject)movieInfoResult.get("movieInfo");
//
//            JSONArray nations = (JSONArray)movieInfo.get("nations");
//            JSONObject nations_nationNm = (JSONObject)nations.get(0);
//
//            JSONArray directors = (JSONArray)movieInfo.get("directors");
//            JSONObject directors_peopleNm = (JSONObject)directors.get(0);
//
//            JSONArray genres = (JSONArray)movieInfo.get("genres");
//
//            JSONArray actors = (JSONArray)movieInfo.get("actors");
//
//            System.out.println("영화코드 : " + movieInfo.get("movieCd"));
//            System.out.println("영화명(한글) : " + movieInfo.get("movieNm"));
//            System.out.println("영화명(영문) : " + movieInfo.get("movieNmEn"));
//            System.out.println("재생시간 : " + movieInfo.get("showTm"));
//            System.out.println("개봉일 : " + movieInfo.get("openDt"));
//            System.out.println("영화유형 : " + movieInfo.get("typeNm"));
//            System.out.println("제작국가명 : " + nations_nationNm.get("nationNm"));


        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
