
public class ShortestPathTest {

	public static void main(String[] args) {
		int nSize = 6 ;    // 정점의 수
		
		ShortestPathClass st = new ShortestPathClass(nSize) ; // 최단경로 클래스를 생성

		st.addEdge(0, 1, 50);       // 강의 교재의 그래프를 입력
		st.addEdge(0, 2, 45);
		st.addEdge(0, 3, 10);
		st.addEdge(1, 2, 10);
		st.addEdge(1, 3, 15);
		st.addEdge(2, 4, 30);
		st.addEdge(3, 0, 20);
		st.addEdge(3, 4, 15);
		st.addEdge(4, 1, 20);
		st.addEdge(4, 2, 35);
		st.addEdge(5, 4, 3);
		
		st.ShortestPath(nSize, 0);   // 출발정점 = 0 으로 해서 최단경로 함수 호출		
	}
}
