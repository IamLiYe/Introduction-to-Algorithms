package y2017.m8.d10;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
/**
 * 测试文件操作mark和reset
 * @author bo.li
 * @version 0.0.1
 * @see <a href="http://www.cnblogs.com/zhang-qiang/articles/2050885.html"></a>
 */
public class FilleTest {
	
	public static void main(String[] args) {
		byte[] bytes= {1,2,3,4,5};
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		BufferedInputStream inputStream=new BufferedInputStream(bais);
		try {
			System.out.println(inputStream.read());
			inputStream.mark(1000);
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			inputStream.reset();
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			inputStream.reset();
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			inputStream.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
package y2017.m8.d10;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
/**
 * 测试文件操作mark和reset
 * @author bo.li
 * @version 0.0.1
 * @see <a href="http://www.cnblogs.com/zhang-qiang/articles/2050885.html"></a>
 */
public class FilleTest {
	
	public static void main(String[] args) {
		byte[] bytes= {1,2,3,4,5};
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		BufferedInputStream inputStream=new BufferedInputStream(bais);
		try {
			System.out.println(inputStream.read());
			inputStream.mark(1000);
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			inputStream.reset();
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			inputStream.reset();
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			System.out.println(inputStream.read());
			inputStream.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
