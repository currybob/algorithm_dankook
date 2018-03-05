
public class TVSTest {

	public static void main(String[] args) {
		int numV = 10 ;    // 정점의 수
		int delta = 5 ;    // 한계값

		TVSClass tvs = new TVSClass(numV) ; // 클래스를 생성
		
		tvs.addW(1, 2, 4);  // 교재에 있는 트리 입력
		tvs.addW(1, 3, 2);
		tvs.addW(2, 4, 2);
		tvs.addW(4, 7, 1);
		tvs.addW(4, 8, 4);
		tvs.addW(3, 5, 1);
		tvs.addW(3, 6, 3);
		tvs.addW(6, 9, 2);
		tvs.addW(6,10, 3);
		
		tvs.startTVS(1, delta);    // 시작정점은 1 로 준다.  
	}
}
