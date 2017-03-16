package dom4j;
import java.io.File;
import java.io.FileOutputStream;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class create_xmlDEMO {
 public static void main(String[] args) throws Exception {
  Document doc = DocumentHelper.createDocument();
  //���Ӹ��ڵ�
  Element books = doc.addElement("books");
  //������Ԫ��
  Element book1 = books.addElement("book");
  Element title1 = book1.addElement("title");
  Element author1 = book1.addElement("author");

  Element book2 = books.addElement("book");
  Element title2 = book2.addElement("title");
  Element author2 = book2.addElement("author");

  //Ϊ�ӽڵ��������
  book1.addAttribute("id", "001");
  //ΪԪ���������
  title1.setText("Harry Potter");
  author1.setText("J K. Rowling");

  book2.addAttribute("id", "002");
  title2.setText("Learning XML");
  author2.setText("Erik T. Ray");

  //ʵ���������ʽ����
  OutputFormat format = OutputFormat.createPrettyPrint();
  //�����������
  format.setEncoding("UTF-8");
  //������Ҫд���File����
  File file = new File("D:" + File.separator + "books.xml");
  //����XMLWriter���󣬹��캯���еĲ���Ϊ��Ҫ������ļ����͸�ʽ
  XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
  //��ʼд�룬write�����а������洴����Document����
  writer.write(doc);
 }
}