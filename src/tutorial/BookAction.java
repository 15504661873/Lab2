package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
    private String name;
    private Book book=new Book();
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
   public Book getBook()
   {
	   return book;
   }
   public void setBook(Book book)
   {
	   this.book=book;
   }
    
    
    //��ѯ�����Ϣ
    public String QueryBook() {
    	Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
        String driver = "com.mysql.jdbc.Driver";  //����������������
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql���õ��û���
        String password = "15504661873";     
    	try
        {
    		Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
            conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            
            String Title = null;
            String AuthorID = null;
            Statement statement = conn.createStatement();  //��statement ��ִ��sql���
            String sql = "select AuthorID from author where Name = \'"+name+"\'";
            ResultSet rs = statement.executeQuery(sql);  //���ڷ��ؽ��
            while(rs.next()){
            	AuthorID = rs.getString("AuthorID");
               
            }
     
            sql = "select Title from book where AuthorID = \'"+AuthorID+"\'";   //����sql����еĲ�ѯĳ����
            rs = statement.executeQuery(sql);  //���ڷ��ؽ��
            System.out.println("---------------------------------------------------");
            name="";
            while(rs.next()){
            	Title = rs.getString("Title");
            	name=name+"��"+Title+"��";
                //System.out.println( "��"+Title+"��" + "\t\t\t" );
            }
            rs.close();
            if(name.equals(""))
            {
            	name="���ݿ��в����ڸ����ߵ���";
            }
           
        }catch (Exception e) {
            e.printStackTrace();
             //return ERROR;
        }finally{
            System.out.println("���ݿ����ݶ�ȡ�ɹ���"+"\n");
    } 
    	 return SUCCESS;
 }
    
    //չʾ���ݿ�
    public String ShowDatas()
    {
    	Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
        String driver = "com.mysql.jdbc.Driver";  //����������������
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql���õ��û���
        String password = "15504661873";  
        String ISBN = null;
        String Title = null;
        String AuthorID = null;
        String Publisher = null;
        String PublishDate = null;
        String Price = null;
        String Name = null;
        String Age = null;
        String Country = null;
    	try
        {
    		Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
            conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
          
                Statement statement = conn.createStatement();  //��statement ��ִ��sql���
                String sql = "select * from book";   //����sql����еĲ�ѯĳ����
                ResultSet rs = statement.executeQuery(sql);  //���ڷ��ؽ��
                System.out.println("---------------------------------------------------");
                //System.out.println("���е�������:");
                name="����е�������:"+"\n";
                //System.out.println("ISBN(PK)" + "\t\t" + "Title" + "\t\t\t" + "AuthorID(FK)"+ "\t\t" +"Publisher"+ "\t\t" +"PublishDate"+ "\t\t" +"Price");
                name=name+"ISBN(PK)" + "   " + "Title" + "   " + "AuthorID(FK)"+ "   " +"Publisher"+ "   " +"PublishDate"+ "   " +"Price\n";
                System.out.println("---------------------------------------------------");
                 
                
                while(rs.next()){
                	ISBN = rs.getString("ISBN");
                	Title = rs.getString("Title");
                	AuthorID = rs.getString("AuthorID");
                	Publisher = rs.getString("Publisher");
                	PublishDate = rs.getString("PublishDate");
                	Price = rs.getString("Price");
                	
                	name=name+ISBN + "   " + Title + "   " + AuthorID +"   "+Publisher+"   "+PublishDate+"   "+Price+"\n";
                   // System.out.println(ISBN + "\t" + Title + "\t\t\t" + AuthorID +"\t\t"+Publisher+"\t\t"+PublishDate+"\t\t"+Price);
                }
                name = name+"���߱��е������У�";
                
                sql = "select * from author";   //����sql����еĲ�ѯĳ����
                  rs = statement.executeQuery(sql);  //���ڷ��ؽ��
                System.out.println("---------------------------------------------------");
                //System.out.println("���е�������:");
               
                //System.out.println("ISBN(PK)" + "\t\t" + "Title" + "\t\t\t" + "AuthorID(FK)"+ "\t\t" +"Publisher"+ "\t\t" +"PublishDate"+ "\t\t" +"Price");
                name=name+"AuthorID" + "   " + "Name" + "   " + "Age"+ "   " +"Country\n";
                System.out.println("---------------------------------------------------");
                 
                
                while(rs.next()){
                	AuthorID = rs.getString("AuthorID");
                	Name = rs.getString("Name");
                	Age = rs.getString("Age");
                	Country = rs.getString("Country");
                	
                	
                	name=name+AuthorID + "   " + Name + "   " + Age +"   "+Country;
                   // System.out.println(ISBN + "\t" + Title + "\t\t\t" + AuthorID +"\t\t"+Publisher+"\t\t"+PublishDate+"\t\t"+Price);
                }
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
              // return ERROR;
            }finally{
                    System.out.println("���ݿ����ݶ�ȡ�ɹ���"+"\n");
            }
    	return SUCCESS;
    }
    //���ݱ���չʾ��ľ�����Ϣ
    public String ShowBookDatas()
    {
    	Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
        String driver = "com.mysql.jdbc.Driver";  //����������������
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql���õ��û���
        String password = "15504661873";     
    	try
        {
    		Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
            conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            
            String ISBN = null;
            String Title = null;
            String AuthorID = null;
            String Publisher = null;
            String PublishDate = null;
            String Price = null;
            String auname = null;
            String Age = null;
            String Country = null;
            Statement statement = conn.createStatement();  //��statement ��ִ��sql���
            String sql = "select * from book where Title = \'"+name+"\'";
            ResultSet rs = statement.executeQuery(sql);  //���ڷ��ؽ��
            name="";
            while(rs.next()){
            	ISBN = rs.getString("ISBN");
            	Title = rs.getString("Title");
            	AuthorID = rs.getString("AuthorID");
            	Publisher = rs.getString("Publisher");
            	PublishDate = rs.getString("PublishDate");
            	Price = rs.getString("Price");
            	name=name+ISBN+" ��"+Title+"�� "+AuthorID+" "+Publisher+" "+PublishDate+" "+Price+"\n";
               // System.out.println( AuthorID + "\t\t\t" );
            }
         
            sql = "select * from author where AuthorID = \'"+AuthorID+"\'";   //����sql����еĲ�ѯĳ����
            rs = statement.executeQuery(sql);  //���ڷ��ؽ��
            System.out.println("---------------------------------------------------");
            while(rs.next()){
            	auname = rs.getString("Name");
            	Age = rs.getString("Age");
            	Country = rs.getString("Country");
            	name=name+auname+Age+Country;
            }
            rs.close();
            if(name.equals(""))
            {
            	name="���ݿ��в����ڸ���";
            }
        }catch (Exception e) {
            e.printStackTrace();
     
        }finally{
                System.out.println("���ݿ����ݶ�ȡ�ɹ���"+"\n");
        	  
        }
    	 return SUCCESS;
    }
    
    //ɾ��һ����
    public String DeleteBook()
    {
    	Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
        String driver = "com.mysql.jdbc.Driver";  //����������������
        //String url = "jdbc:mysql://localhost:3306/bookdb?autoReconnect=true";  //ָ��Ҫ���ʵ����ݿ⣡ע�������������ݿ�����
       // String user = "root";   //navicat for sql���õ��û���
        //String password = "root";
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql���õ��û���
        String password = "15504661873"; 
        try
        {
    		Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
            conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
          
            PreparedStatement psql;  //������Ԥ����
            psql = conn.prepareStatement("delete from book where Title = ?");//��preparedStatementԤ������ִ��sql���
                psql.setString(1, name); 
                psql.executeUpdate();  //����׼����ִ�����
                psql.close();
               name = "ɾ���ɹ���";
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
                System.out.println("���ݿ�����ɾ���ɹ���"+"\n");
        }
               return SUCCESS;
    }
    
    //����һ����
    public String InsertBook()
    {

    	Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
        String driver = "com.mysql.jdbc.Driver";  //����������������
       // String url = "jdbc:mysql://localhost:3306/bookdb?autoReconnect=true";  //ָ��Ҫ���ʵ����ݿ⣡ע�������������ݿ�����
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql���õ��û���
        String password = "15504661873"; 
        String ISBN = book.getISBN();
        String Title = book.getTitle();
        String AuthorID = book.getAuthorID();
        String Publisher = book.getPublisher();
        String PublishDate = book.getPublishDate();
        String Price = book.getPrice();
        String Name0 = book.getAuName();
        String Age = book.getAuAge();
        String Country = book.getAuCountry();
        String str = null;
    	try
        {
    		Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
            conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
          
   
                PreparedStatement psql = conn.prepareStatement("insert into book (ISBN,Title,AuthorID,Publisher,PublishDate,Price)"+"values(?,?,?,?,?,?)");  //��preparedStatementԤ������ִ��sql���
                psql.setString(1, ISBN);  //�������������ֱ𡰸�ֵ��
                psql.setString(2, Title);
                psql.setString(3, AuthorID);
                psql.setString(4, Publisher);
                DateFormat mydateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date mydate = mydateFormat.parse(PublishDate);
                psql.setDate(5, new java.sql.Date(mydate.getTime()));
                psql.setString(6, Price);
                psql.executeUpdate();  //����׼����ִ�����
                name="�����ɹ�";
                Statement statement = conn.createStatement();  //��statement ��ִ��sql���
                String sql = "select *from author where AuthorID = \'"+AuthorID+"\'";
                ResultSet rs = statement.executeQuery(sql);  //���ڷ��ؽ��
                while(rs.next()){
                	str = rs.getString("Name");
                }
                if(str==null)
            	{
            	 psql = conn.prepareStatement("insert into author (AuthorID,Name,Age,Country)"+"values(?,?,?,?)"); 
            	 psql.setString(1, AuthorID);  //�����ĸ������ֱ𡰸�ֵ��
                 psql.setString(2, Name0);
                 psql.setString(3, Age);
                 psql.setString(4, Country);
                 psql.executeUpdate();  //����׼����ִ�����
                 name = name + ",�������������ߣ�";
                 System.out.println("��������");
            	}
                rs.close();
                psql.close();
        }catch (Exception e) {
            e.printStackTrace();
    
        }finally{
                System.out.println("���ݿ����ݲ���ɹ���"+"\n");
        	  
        }
    	return SUCCESS;
    }
    //����һ����
    public String UpdateBook()
    {
    	Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
        String driver = "com.mysql.jdbc.Driver";  //����������������
      //  String url = "jdbc:mysql://localhost:3306/bookdb?autoReconnect=true";  //�������ݿ�
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";//�ƶ����ݿ�
        String user = "qinyanmei";   //navicat for sql���õ��û���
        String password = "15504661873"; 
        String Title = book.getTitle();
        String item = book.getISBN();
        
    	 try
         {
    		 Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
             conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
             if(!conn.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
           
    
             PreparedStatement psql;
             psql = conn.prepareStatement("update book set "+item+" = ? where Title = ?");
           //  psql.setString(1, item);
             psql.setString(1, name);
             psql.setString(2, Title);
             psql.executeUpdate();
             psql.close();
             name = "�޸ĳɹ���";
         }catch (Exception e) {
             e.printStackTrace();
         }finally{
                 System.out.println("���ݿ������޸ĳɹ���"+"\n");
         }
    	 return SUCCESS;
    }
}




















