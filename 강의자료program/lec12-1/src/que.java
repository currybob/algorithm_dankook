
public class que {
	private quenode front;   // 큐의 앞
	private	quenode rear;    // 큐의 뒤

	public que()
	{
	    front = rear = null ;   // 초기값  NULL 을 넣는다.
	}

	public void Add(int x)
	{
	   if (front == null) 
		   front = rear = new quenode(x, null);  // 첫 노드로 삽입
	   else
		   rear = rear.link = new quenode(x, null) ;  // 마지막 노드로 삽입
	}

	public int Delete()
	{  // 이 삭제함수는 빈 큐가 아닐때 삭제한다. 
	   // 따라서 이 삭제 함수를 호출하기 전에 빈 큐임을 확인해야 한다.
		if (front == null) return -1 ;   // 빈 큐일 때
		
		int retval = front.data;
		quenode lk = front ;
		front = front.link ;

		return retval ;
	}

	public boolean Empty()
	{
	   if (front != null) 
		   return false ;
	   else
		   return true  ;
	}

	
}
