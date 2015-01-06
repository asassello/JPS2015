package datastore;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;







import datastore.OID;

import java.io.File;
import java.io.IOException;
 




import org.jdom2.Comment;
import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;




import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;



public class SBAStore implements ISBAStore {
	
	private Map<IOID, ISBAObject> SBAObjects;
	Integer nextOID = 0;
	
	public SBAStore() {
		SBAObjects = new HashMap<IOID, ISBAObject>();
	}

	@Override
	public ISBAObject retrieve(IOID oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOID getEntryOID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadXML(String filePath) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document jdomDoc = builder.build(new File(filePath));
			Element web_app = jdomDoc.getRootElement();
			
			Document document = (Document) builder.build(filePath);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("liczbaTestowa");
			System.out.println(web_app.getText());
	         
			
			IteratorIterable<Content> contents = web_app.getDescendants();
			
			while (contents.hasNext()) {
	            Content web_app_content = contents.next();
	            
	            
	            if (!web_app_content.getCType().equals(CType.Text) && !web_app_content.getCType().equals(CType.Comment)) {
	                System.out.println(web_app_content.toString());
	            }

	    		
	            for (int i = 0; i < list.size(); i++) {
					Element node = (Element) list.get(i);
					System.out.println("First Name : " + node.getChildText(web_app_content.toString()));
				}

	        }

			
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public IOID generateUniqueOID() {
        OID theOID = new OID(nextOID);
        nextOID++;
        return theOID;
	}

	@Override
	public void addJavaObject(Object o, String objectName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJavaCollection(Collection o, String collectionName) {
		// TODO Auto-generated method stub
		
	}
	

   
	
	

}
