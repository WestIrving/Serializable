package 对象序列化;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class TestPeople {
	
	public static void main(String[] args) {
		
		String file="C:\\Users\\Administrator.SKY-20170306IYS\\Desktop\\obj.dat";
		
		try {
			//将对象存入文件中
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
			
			People p1=new People(1001, "张三", "男");
			People p2=new People(1002, "李四", "男");
			People p3=new People(1003, "王五", "男");
			ArrayList list=new ArrayList();
			
			list.add(p1);
			list.add(p2);
			list.add(p3);
			oos.writeObject(list); //将对象写入File中
			
			oos.close();
			
			//将对象从文件中读出
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			
			
			list=(ArrayList)ois.readObject();
			
			System.out.println(list);
			ois.close();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
