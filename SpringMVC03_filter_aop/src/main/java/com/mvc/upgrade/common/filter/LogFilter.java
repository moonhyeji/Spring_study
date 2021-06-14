package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	//필터 초기화 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	
	//dofilter : filter전후처리 
	//req파라미터 읽어서 filter실행. 
	//만약 다음 filter 존재시 filterchain이용해서 다음 필터 수행
	//res로 응답의 필터링 filter 수행 
	@Override   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;  //요청을 HttpServletRequest로 형변환 
		
		String remoteAddr = req.getRemoteAddr();  //클라이언트의 ip주소 가져오기 
	    String uri = req.getRequestURI();      //context + servlet 경로 
	    String url = req.getRequestURL().toString(); //전체경로 (프로토콜 + 도메인 + 포트번호 + 컨텍스트 경로 + 서블릿 경로)
	    String queryString = req.getQueryString();   //쿼리스트링. 보내지는 값. 
	    String referer = req.getHeader("referer");  //이전 페이지의 URL을 가져오기.( 파라미터도 같이 얻을 수 있다)
	                        //getHeader = requestheader에 저장돼서 넘어오는 정보 
	    String agent = req.getHeader("User-Agent"); //접속자 정보 
	    
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append("* remoteAddr :" + remoteAddr + "\n") //ip주소 
	      .append("* uri :" + uri + "\n")
	      .append("* url :" + url + "\n")
	      .append("* queryString :" + queryString + "\n")
	      .append("* referer :" + referer + "\n")
	      .append("* agent :" + agent );  //브라우저, os등 사용자정보 
	
		  logger.info("LOG FILTER\n" + sb);   //req에 들어있는 정보 읽어서 filter 실행 
		  
		  chain.doFilter(request, response); //다음에 존재하는 필터가 있으면 그 필터 실행되도록 chaing하는 코드 
	}

	
	//필터 인스턴스 종료 
	@Override
	public void destroy() {
	}

}
