package com.kh.ccc.board.playground.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ccc.board.freeboard.model.service.FrBoardService;

@Controller
public class KakaoPay {
	
	@Autowired
	private FrBoardService FrBoardService;
	
	
	@RequestMapping("kakaoPay.pay")
	public ModelAndView kakaoPayform(ModelAndView mv){
		mv.setViewName("board/playground/kakaoPay");
		return mv;
		
	}
	
	@ResponseBody
	@RequestMapping("kakaopayCls")
	public String kakaopay(){		
		try {
			URL ur= new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection serverconnect =(HttpURLConnection)ur.openConnection();
			serverconnect.setRequestMethod("POST");	
			serverconnect.setRequestProperty("Authorization","KakaoAK bc45bc052984e31f30fef8dbb0628dba");
			serverconnect.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			serverconnect.setDoOutput(true);
	        String prameter =
	        		"cid=TC0ONETIME"
	        		+ "&partner_order_id=partner_order_id"
	        		+ "&partner_user_id=partner_user_id"
	        		
	        		+ "&item_name=초코파이"
	        		+ "&quantity=1"
	        		
	        		+ "&total_amount=22000"
	        		+ "&vat_amount=2200"
	        		+ "&tax_free_amount=0"
	        		
	        		+ "&approval_url=http://localhost:8088/"
	        		+ "&fail_url=http://localhost:8088/"
	        		+ "&cancel_url=http://localhost:8088/";
	        
	        	OutputStream give = serverconnect.getOutputStream();
	        	DataOutputStream datagive = new DataOutputStream(give);
	        	datagive.writeBytes(prameter);
	        	datagive.flush();
	        	datagive.close();
	        	
	        	
	        	int resultcode=serverconnect.getResponseCode();
	        	
	        	InputStream receivedata;
	        	if(resultcode==200) {
	        		receivedata= serverconnect.getInputStream();
	        	}else {
	        		receivedata=serverconnect.getErrorStream();
	        	}
	        	
	        	InputStreamReader readdata = new InputStreamReader(receivedata,"UTF-8");
	        	BufferedReader transReadData = new BufferedReader(readdata);
	        	
	        	return transReadData.readLine();
	        	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
		
	}
	
	
}
