package method;
import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;

/**
 * Kết nối cơ sở dữ liệu
 * @author tt
 *
 */

public class ConectionDB {
	
	private final Driver driver;

    public ConectionDB( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }
    public ConectionDB()
    {
        driver = GraphDatabase.driver( "bolt://localhost:11004", AuthTokens.basic( "akiko", "06081997" ) );
    }
    
    public void close() throws Exception
    {
        driver.close();
    }
    
    public StatementResult execute(String s){
    	
    	StatementResult rs= null;
    	try ( Session session = driver.session() ){
    		rs=session.run(s);
    	}
    	
    	return rs;
    }
	
	void getConection(){	
		
	};
	void getData(){
		
	};
	void setData(){
		
	};
	void updateData(){
		
	}
	void removeData(){
		
	};
	public static void main(String[] args) {
		ConectionDB cn = new ConectionDB();
		cn.execute("CREATE (ee:Person { name: 'aa', from: 'Việt Nam', klout: 99 })");
	}
}
