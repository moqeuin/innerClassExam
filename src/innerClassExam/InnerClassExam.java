package innerClassExam;

public class InnerClassExam {
	
	private int outerIv = 0;
	static int outerCv = 0;
	
	public static void main(String[] args) {
	
	}
	
	InstanceInner ii = new InstanceInner();
	StaticInner si = new StaticInner();
	
	// static 클래스
	static class StaticInner{
		
		int iv = 100;
		static int cv = 200; //static 클래스만 static 멤버를 가질 수 있다.
		int test = outerCv; // static클래스는 외부클래스의 static멤버를 호출할 수 있다.
		//int test2 = outerIv; // 인스턴스멤버는 호출이 불가능하다.
	}
	
	// 인스턴스 클래스
	class InstanceInner{	
		
		int iv = 100;		
		//static int number2 = 33; // 인스턴스클래스는 static멤버를 가질 수 없다.
		final static int cv = 12;  // final static 은 상수취급함으로 사용가능
		// 인스턴스 클래스에서는 외부클래스의 static, 인스턴스 멤버 모두 호출이 가능하다.
		int test = outerCv; 
		int test2 = outerIv;
	}
	
	// 스태틱 메서드
	static void staticMethod() {
		
		// static 클래스 접근가능
		StaticInner si = new StaticInner(); 
		
		// 인스턴스 클래스 접근 불가능
		//InstanceInner ii = new InstanceInner(); 
		
		// 접근하고자 한다면 외부클래스로 접근해서 생성해야한다.
		InnerClassExam ice = new InnerClassExam();
		InstanceInner ii = ice.new InstanceInner();
	}
	
	// 인스턴스 메서드
	void instanceMethod() {
		
		// 모두 접근가능
		InstanceInner ii = new InstanceInner();
		StaticInner si = new StaticInner();
		
		final int av = 100; // jdk 1.8부터는 final 생략가능
		// 지역 클래스
		class LocalInner{
			
			int test = av; // final 붙은 외부 메소드의 지역변수는 접근가능하다. final없으면 접근 불가능
			int iv = 200;
			//static int cv =233; // static변수를 정의할 수 없다.
			final static int cv = 12;  // final static 은 상수취급함으로 사용가능
		}
	}
}
