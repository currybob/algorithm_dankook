
public class quenode {
	public state  data ;      // 데이터 필드
	public quenode link ;  // 링크 필드
	
	public quenode(state st, quenode lk)
	{
	    data = st ;
	    link = lk ;
	}
}
