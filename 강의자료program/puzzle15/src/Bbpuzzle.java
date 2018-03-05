
public class Bbpuzzle {
	private	int box[][] ;
	private int pt[] ;
	private int crow, ccol, dep ;
	
	public Bbpuzzle()
	{
		box = new int[4][4] ;
		pt  = new int[16] ;
		
		// 초기값
/*		box[0][0] =  1; box[0][1] =  3; box[0][2] =  4; box[0][3] = 15; 
		box[1][0] =  2; box[1][1] =  0; box[1][2] =  5; box[1][3] = 12; 
		box[2][0] =  7; box[2][1] =  6; box[2][2] = 11; box[2][3] = 14; 
		box[3][0] =  8; box[3][1] =  9; box[3][2] =  1; box[3][3] = 13; 	
		crow = 1 ; ccol = 1 ;
*/		
/*		box[0][0] =  1; box[0][1] =  2; box[0][2] =  3; box[0][3] = 4; 
		box[1][0] =  5; box[1][1] =  6; box[1][2] =  0; box[1][3] = 8; 
		box[2][0] =  9; box[2][1] = 10; box[2][2] =  7; box[2][3] = 11; 
		box[3][0] = 13; box[3][1] = 14; box[3][2] = 15; box[3][3] = 12; 
		crow = 1 ; ccol = 2 ;
*/		
		box[0][0] =  1; box[0][1] =  2; box[0][2] =  3; box[0][3] = 4; 
		box[1][0] =  5; box[1][1] =  6; box[1][2] =  7; box[1][3] = 8; 
		box[2][0] =  10; box[2][1] = 0; box[2][2] =  11; box[2][3] = 12; 
		box[3][0] = 9; box[3][1] = 13; box[3][2] = 14; box[3][3] = 15; 
		crow = 2 ; ccol = 1 ;
			
		dep = -1;
		
		solpuzzle() ;  // 15 puzzle 문제를 호출
	}
	
	private void solpuzzle()
	{
		int i, j, val, r, c ;
		int count = 0 ;
		
	    if (promising(box)) {
		    System.out.println("첫 노드가 해답 노드이다!!") ;
		    return ;
	    } 
	    
        state cstate = new state(-5, crow, ccol, dep, pt, box) ;  // -5 는 의미없는 값. 부모노드가 없음을 의미
        
	    que Q = new que();
		Q.Add(cstate) ;

		// 해답을 찾을 때까지 반복
		while( !Q.Empty() ) {       // 큐가 빌 때까지 반복
	        cstate = Q.Delete() ;   // 큐에서 하나의 상태를 삭제 - 하나의 15 퍼즐 상태를 꺼낸다.
            System.out.println("새로운 스테이트!");
			// 자식 노드들의 생성
			for (i = 1; i <= 4 ; i++) {   // 각각의 자식을 생성한다. 북(1)동(2)남(3)서(4)
				j = cstate.dir - i ;
				if (j == 2 || j == -2) continue ;
				
				crow = cstate.cr ; ccol = cstate.cc ; 
				dep = cstate.depth ;
				for (int k=0; k <= dep; k++) pt[k] = cstate.path[k] ;
				for(r=0; r < 4; r++)
					for(c=0; c < 4; c++)
						box[r][c] = cstate.qbox[r][c] ;
						    
				if ((i == 1 && crow == 0) || (i == 2 && ccol == 3) ||
					(i == 3 && crow == 3) || (i == 4 && ccol == 0))   continue ;  // 경계를 넘는 것을 체크
				
				// 방향에 따라 하나의 자식 생성
				if (i == 1) { 
					val = box[crow-1][ccol];
					box[crow-1][ccol] = box[crow][ccol];
					box[crow][ccol] = val ;
					crow-- ; }
				else if (i == 2){
					val = box[crow][ccol+1];
					box[crow][ccol+1] = box[crow][ccol];
					box[crow][ccol] = val ;
					ccol++ ; }
				else if (i == 3){
					val = box[crow+1][ccol];
					box[crow+1][ccol] = box[crow][ccol];
					box[crow][ccol] = val ;
					crow++ ; }
				else {
					val = box[crow][ccol-1];
					box[crow][ccol-1] = box[crow][ccol];
					box[crow][ccol] = val ;
					ccol-- ; }
				
				dep++ ; pt[dep] = i ;
				
				// 해답 노드를 체크
			    if (promising(box)) {    // 해답노드인 경우

					    System.out.println("\n 해답 발견"+crow+" "+ccol) ;
					    for (int k=0; k <= dep; k++) 
					    	System.out.print(pt[k]+" -> ") ;
					    return ;
					}
					else {   // 해답노드가 아닌 경우
					    state sonstate = new state(i, crow, ccol, dep, pt, box) ;
						Q.Add(sonstate) ;      // 해답 노드는 아니나 살아있는 노드인 경우 큐에 삽입
						
						count++ ;
					    System.out.println(count +" :" + crow + " "+ ccol + "dep ="+dep) ;
					    if (count > 300000 || dep >= 28)
					    {
					    	System.out.println("카운터 300,000 이상 종료 또는 최대깊이 초과" + dep) ;
					    	return ;
					    }
			       	}  // end of if
			}  // end of for 
		}   // end of while
	}

	private boolean promising(int bx[][])    // 해답상태 확인 함수
	{
		int r, c, val ;

		for(r=0; r < 4; r++)
			for(c=0; c < 4; c++){
				val = r*4 + c + 1;
				if (val == 16) return true;
				if (bx[r][c] != val) return false;
			}
		return true;
	}
	
}
