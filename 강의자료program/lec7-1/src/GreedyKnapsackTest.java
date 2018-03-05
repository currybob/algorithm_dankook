
public class GreedyKnapsackTest {

	public static void main(String[] args) {
		int numObj = 16 ;    // 물건의 수
		int capacity = 200 ;  // 용량
		Obj ob[] = new Obj[numObj+1] ;

		for(int i=1; i<= numObj; i++) {
			int p = (int)(java.lang.Math.random()*99 + 50);  //테스트 데이터 생성
			int w = (int)(java.lang.Math.random()*49) + 10;   //테스트 데이터 생성
			ob[i] = new Obj(p,w) ;
		}

		GreedyKnapsackClass gk = new GreedyKnapsackClass(ob, numObj) ; // 클래스를 생성
		
		gk.GreedyKnapsack(capacity, numObj);    //  Knapsack 함수 호출
        gk.printResult(); 

	}

}
