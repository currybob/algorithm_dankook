
public class state {
	public int dir ;
	public int cr, cc ;
	public int depth, path[];
	public int qbox[][] ; 

	public state(int dd, int ro, int co, int k, int ph[], int arr[][])
	{
		qbox = new int[4][4] ;
		path = new int[20] ;      // 최대 깊이를 16으로 설정
		
		dir = dd ; cr = ro; cc = co; depth = k;
		
		for(int i=0; i <= depth; i++) {   // 루트에서부터 해당 상태까지의 경로값
			path[i] = ph[i] ;  
		}

		for(int i=0; i < 4; i++)
			for(int j=0; j < 4; j++)
				qbox[i][j] = arr[i][j] ;
	}
}
