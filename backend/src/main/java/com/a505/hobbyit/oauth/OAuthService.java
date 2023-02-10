package com.a505.hobbyit.oauth;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class OAuthService {

    @Value("${oauth.REST_API_KEY}")
    private String REST_API_KEY;

    @Value("${oauth.redirect_uri}")
    private String redirect_uri;

    private String oauth_token;

    public String getKakaoToken(String code) {
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=" + REST_API_KEY);
            sb.append("&redirect_uri=" + redirect_uri);
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            oauth_token = element.getAsJsonObject().get("access_token").getAsString();

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oauth_token;
    }

    public List<String> getKakaoMember(String token) {
        List<String> account = new ArrayList<>();

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        // token을 이용하여 사용자 정보 조회
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, token전송

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            //Gson 라이브러리로 JSON파싱
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            account.add(element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString());
            account.add(element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString());
            account.add(element.getAsJsonObject().get("properties").getAsJsonObject().get("profile_image").getAsString());

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return account;
    }

}
