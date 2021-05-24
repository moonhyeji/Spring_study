package com.test01;
import java.util.GregorianCalendar;
import java.util.Calendar;
public abstract class AbstractTest {

	
	public abstract String dayInfo();
//추상메소드: 바디가 없는 메소드. 
	//특징: 추상메소드를 가지고 있기 때문에 추상클래스. 추상메소드를 가지고 있으면 추상클래스이다.
    
	public static AbstractTest getInstance() {
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		return null;
	}



}
