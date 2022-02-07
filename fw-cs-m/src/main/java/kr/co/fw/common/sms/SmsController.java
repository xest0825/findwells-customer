package kr.co.fw.common.sms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.system.auth.AuthVO;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@RestController
public class SmsController extends BaseController {
	
	@PostMapping("/sms/send-authnum-to-custoemr")
	public ResponseEntity<HashMap<String, Object>> getIntroducers(@RequestBody SmsVO paramvo) {
		log.info("[POST] /sms/send-authnum-to-custoemr");
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		JSONObject jobj = new JSONObject();
		

		try {
			String serviceId = "ncp:sms:kr:273490381644:fw1001";
			String apiUrl = "https://sens.apigw.ntruss.com/sms/v2/services/"+serviceId+"/messages";
			String reqMethod = "POST";
			long timestamp =  System.currentTimeMillis();
			
			HashMap<String, Object> signingkey =new HashMap<String, Object>();
			signingkey.put("timestamp", timestamp+"");
			signingkey.put("serviceId", serviceId);
			signingkey.put("accessKey", "sfsdoiOcSK1FAfNXSzi0");
			signingkey.put("secretKey", "wAeebl69JCs94hc4hXWy2PF3hQwkTDRleCTdeMD9");
			String signature = CommUtil.getSigningKey(signingkey);
			log.info("signature : " + signature);
			
			//HashMap<String, Object> header = new HashMap<String, Object>();
			/*
			paramMap.put("Content-Type", "application/json");
			paramMap.put("x-ncp-apigw-timestamp",timestamp + "");
			paramMap.put("x-ncp-iam-access-key",  "t49MAOU3HwqZaMkkcpt7");
			paramMap.put("x-ncp-apigw-signature-v2", signature);
			*/
			String authno = CommUtil.makeRandomNumber(6, 2);
			log.info("AuthNo : " + authno);
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("timestamp", timestamp + "");
			paramMap.put("accessKey", "sfsdoiOcSK1FAfNXSzi0");
			paramMap.put("signature", signature);
			
			paramMap.put("type", "SMS");
			paramMap.put("contentType", "COMM");
			paramMap.put("countryCode", "82");
			paramMap.put("from", "0262031144");
			paramMap.put("to", paramvo.getCall_to().replace("-", ""));
			paramMap.put("subject", "[파인드웰스] 인증번호 전송");
			String content = "[파인드웰스] 회원가입을 위한 인증번호는 \n"
					+ authno + " 입니다." 
					;
			paramMap.put("content", content);
			List<HashMap<String,Object>> msgList = new ArrayList<HashMap<String, Object>>();
			List<HashMap<String,Object>> fileList = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> msgItem = new HashMap<String,Object>();
			msgItem.put("to", paramvo.getCall_to().replace("-", ""));
			msgItem.put("subject", "[파인드웰스] 인증번호 전송");
			msgItem.put("content", content);
			msgList.add(msgItem);
			
			
			paramMap.put("messages", msgList);
			//paramMap.put("files", fileList);
			//paramMap.put("reserveTime", "");
			//paramMap.put("reserveTimeZone", "");
			//paramMap.put("scheduleCode", "");
			
			
			jobj = CommUtil.getApiData(apiUrl, reqMethod, paramMap);
			if (jobj.get("res_cd").toString().equals("OK")) {
				
				AuthVO auth = new AuthVO();
				auth.setAuth_no(authno);
				auth.setSender("0262031144");
				auth.setReceiver(paramvo.getCall_to().replace("-", ""));
				auth.setReceiver_nm(paramvo.getReceiver_nm());
				getAuthService().insertAuthLog(auth);
				
				hmap.put("res_cd", "OK");
				hmap.put("msg", "SMS 전송 완료");			
				hmap.put("msg_seq", auth.getSeq());
				
				
				
			} else {
				hmap.put("res_cd", "FAIL");
				hmap.put("msg", jobj.get("msg").toString());				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(hmap, HttpStatus.OK);
		return entity;
	}
	
}
