package method;
/**
 * Tạo quan hệ giữa các thực thể
 * @author tt
 *
 */
public abstract class MatchNode {
	
	private int maxIdNode1;//id lớn nhất của tập thực thể thứ 1
	private int maxIdNode2;//id lớn nhất của tập thực thể thứ 2
	
	public abstract void RandomReferences();//tạo ngẫu nhiên liên kết giữa thực thể thứ nhất và thực thể thứ 2 qua id rồi gửi lên database
											//vd : 	match (n) where n.id=1...
											//  	match (m) where m.id=2...
											//		create (n)-[:reference]->(m)
	
	public abstract void makeReferences( int numberReferences);// tạo giả lập quan hệ với số lượng quan hệ được nhập vào
	
}
