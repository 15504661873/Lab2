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
    
    
    //查询书的信息
    public String QueryBook() {
    	Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名？？？
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql配置的用户名
        String password = "15504661873";     
    	try
        {
    		Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
            conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            
            String Title = null;
            String AuthorID = null;
            Statement statement = conn.createStatement();  //用statement 来执行sql语句
            String sql = "select AuthorID from author where Name = \'"+name+"\'";
            ResultSet rs = statement.executeQuery(sql);  //用于返回结果
            while(rs.next()){
            	AuthorID = rs.getString("AuthorID");
               
            }
     
            sql = "select Title from book where AuthorID = \'"+AuthorID+"\'";   //这是sql语句中的查询某个表！
            rs = statement.executeQuery(sql);  //用于返回结果
            System.out.println("---------------------------------------------------");
            name="";
            while(rs.next()){
            	Title = rs.getString("Title");
            	name=name+"《"+Title+"》";
                //System.out.println( "《"+Title+"》" + "\t\t\t" );
            }
            rs.close();
            if(name.equals(""))
            {
            	name="数据库中不存在该作者的书";
            }
           
        }catch (Exception e) {
            e.printStackTrace();
             //return ERROR;
        }finally{
            System.out.println("数据库数据读取成功！"+"\n");
    } 
    	 return SUCCESS;
 }
    
    //展示数据库
    public String ShowDatas()
    {
    	Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名？？？
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql配置的用户名
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
    		Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
            conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
          
                Statement statement = conn.createStatement();  //用statement 来执行sql语句
                String sql = "select * from book";   //这是sql语句中的查询某个表！
                ResultSet rs = statement.executeQuery(sql);  //用于返回结果
                System.out.println("---------------------------------------------------");
                //System.out.println("表中的数据有:");
                name="书表中的数据有:"+"\n";
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
                name = name+"作者表中的数据有：";
                
                sql = "select * from author";   //这是sql语句中的查询某个表！
                  rs = statement.executeQuery(sql);  //用于返回结果
                System.out.println("---------------------------------------------------");
                //System.out.println("表中的数据有:");
               
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
                    System.out.println("数据库数据读取成功！"+"\n");
            }
    	return SUCCESS;
    }
    //根据标题展示书的具体信息
    public String ShowBookDatas()
    {
    	Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名？？？
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql配置的用户名
        String password = "15504661873";     
    	try
        {
    		Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
            conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
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
            Statement statement = conn.createStatement();  //用statement 来执行sql语句
            String sql = "select * from book where Title = \'"+name+"\'";
            ResultSet rs = statement.executeQuery(sql);  //用于返回结果
            name="";
            while(rs.next()){
            	ISBN = rs.getString("ISBN");
            	Title = rs.getString("Title");
            	AuthorID = rs.getString("AuthorID");
            	Publisher = rs.getString("Publisher");
            	PublishDate = rs.getString("PublishDate");
            	Price = rs.getString("Price");
            	name=name+ISBN+" 《"+Title+"》 "+AuthorID+" "+Publisher+" "+PublishDate+" "+Price+"\n";
               // System.out.println( AuthorID + "\t\t\t" );
            }
         
            sql = "select * from author where AuthorID = \'"+AuthorID+"\'";   //这是sql语句中的查询某个表！
            rs = statement.executeQuery(sql);  //用于返回结果
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
            	name="数据库中不存在该书";
            }
        }catch (Exception e) {
            e.printStackTrace();
     
        }finally{
                System.out.println("数据库数据读取成功！"+"\n");
        	  
        }
    	 return SUCCESS;
    }
    
    //删除一本书
    public String DeleteBook()
    {
    	Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名？？？
        //String url = "jdbc:mysql://localhost:3306/bookdb?autoReconnect=true";  //指向要访问的数据库！注意后面跟的是数据库名称
       // String user = "root";   //navicat for sql配置的用户名
        //String password = "root";
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql配置的用户名
        String password = "15504661873"; 
        try
        {
    		Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
            conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
          
            PreparedStatement psql;  //还是用预处理
            psql = conn.prepareStatement("delete from book where Title = ?");//用preparedStatement预处理来执行sql语句
                psql.setString(1, name); 
                psql.executeUpdate();  //参数准备后执行语句
                psql.close();
               name = "删除成功！";
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
                System.out.println("数据库数据删除成功！"+"\n");
        }
               return SUCCESS;
    }
    
    //插入一本书
    public String InsertBook()
    {

    	Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名？？？
       // String url = "jdbc:mysql://localhost:3306/bookdb?autoReconnect=true";  //指向要访问的数据库！注意后面跟的是数据库名称
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";
        String user = "qinyanmei";   //navicat for sql配置的用户名
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
    		Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
            conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
          
   
                PreparedStatement psql = conn.prepareStatement("insert into book (ISBN,Title,AuthorID,Publisher,PublishDate,Price)"+"values(?,?,?,?,?,?)");  //用preparedStatement预处理来执行sql语句
                psql.setString(1, ISBN);  //给其六个参量分别“赋值”
                psql.setString(2, Title);
                psql.setString(3, AuthorID);
                psql.setString(4, Publisher);
                DateFormat mydateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date mydate = mydateFormat.parse(PublishDate);
                psql.setDate(5, new java.sql.Date(mydate.getTime()));
                psql.setString(6, Price);
                psql.executeUpdate();  //参数准备后执行语句
                name="书插入成功";
                Statement statement = conn.createStatement();  //用statement 来执行sql语句
                String sql = "select *from author where AuthorID = \'"+AuthorID+"\'";
                ResultSet rs = statement.executeQuery(sql);  //用于返回结果
                while(rs.next()){
                	str = rs.getString("Name");
                }
                if(str==null)
            	{
            	 psql = conn.prepareStatement("insert into author (AuthorID,Name,Age,Country)"+"values(?,?,?,?)"); 
            	 psql.setString(1, AuthorID);  //给其四个参量分别“赋值”
                 psql.setString(2, Name0);
                 psql.setString(3, Age);
                 psql.setString(4, Country);
                 psql.executeUpdate();  //参数准备后执行语句
                 name = name + ",还插入了新作者！";
                 System.out.println("插入作者");
            	}
                rs.close();
                psql.close();
        }catch (Exception e) {
            e.printStackTrace();
    
        }finally{
                System.out.println("数据库数据插入成功！"+"\n");
        	  
        }
    	return SUCCESS;
    }
    //更新一本书
    public String UpdateBook()
    {
    	Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名？？？
      //  String url = "jdbc:mysql://localhost:3306/bookdb?autoReconnect=true";  //本地数据库
        String url = "jdbc:mysql://tlfvrgylscoh.mysql.sae.sina.com.cn:10643/bookdb";//云端数据库
        String user = "qinyanmei";   //navicat for sql配置的用户名
        String password = "15504661873"; 
        String Title = book.getTitle();
        String item = book.getISBN();
        
    	 try
         {
    		 Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
             conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
             if(!conn.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
           
    
             PreparedStatement psql;
             psql = conn.prepareStatement("update book set "+item+" = ? where Title = ?");
           //  psql.setString(1, item);
             psql.setString(1, name);
             psql.setString(2, Title);
             psql.executeUpdate();
             psql.close();
             name = "修改成功！";
         }catch (Exception e) {
             e.printStackTrace();
         }finally{
                 System.out.println("数据库数据修改成功！"+"\n");
         }
    	 return SUCCESS;
    }
}




















