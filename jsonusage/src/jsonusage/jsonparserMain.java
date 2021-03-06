package jsonusage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonparserMain {

	public static void main(String[] args) throws IOException, ParseException {

		String rootPath = System.getProperty("user.dir");
		BufferedReader br = new BufferedReader(new FileReader(rootPath + "/json/data1.json"));

		String data;
		StringBuilder sb = new StringBuilder();
		while ((data = br.readLine()) != null) {
			sb.append(data);
		}

		data = sb.toString();

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(data);

		System.out.println("이름:" + obj.get("name"));
		System.out.println("나이:" + obj.get("age"));
		System.out.println("성별:" + obj.get("gender"));
		System.out.println("지역:" + obj.get("locate"));

		data = "";
		sb.setLength(0);

		br = new BufferedReader(new FileReader(rootPath + "/json/data2.json"));
		while ((data = br.readLine()) != null) {
			sb.append(data);
		}
		
		data = sb.toString();
		sb.setLength(0);
		
		JSONArray jsonarray = (JSONArray) parser.parse(data);
		for (int i = 0; i < jsonarray.size(); i++) {
			obj = (JSONObject) jsonarray.get(i);
			String content = (String) obj.get("content");
			sb.append(content+" ");
		}
		System.out.println(sb.toString());
	}

}
