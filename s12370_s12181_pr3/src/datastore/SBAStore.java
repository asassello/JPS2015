package datastore;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;









import java.util.Stack;

import datastore.OID;

import java.io.File;
import java.io.IOException;












import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IIntegerObject;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import edu.pjwstk.jps.datastore.ISimpleObject;
import edu.pjwstk.jps.datastore.IStringObject;




public class SBAStore implements ISBAStore {
	
	private Map<IOID, ISBAObject> SBAObjects;
	Stack<IOID> OID_Stack;
	
	
	Integer nextOID = 0;
	IOID EntryOID;

	
	public SBAStore() {
		SBAObjects = new HashMap<IOID, ISBAObject>();
		OID_Stack = new Stack<IOID>();
	}

	@Override
	public ISBAObject retrieve(IOID oid) {
		return SBAObjects.get(oid);
	}

	@Override
	public IOID getEntryOID() {
		return EntryOID;
	}


	@Override
	public void loadXML(String filePath) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document jdomDoc = builder.build(new File(filePath));
			Element root_element = jdomDoc.getRootElement();
			
			EntryOID = generateUniqueOID();
			System.out.println(EntryOID);
			OID_Stack.push(EntryOID);
			
			parseXML(root_element);
	
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	public void parseXML (Element element){
		
		IteratorIterable<Content> contents = element.getDescendants();
		Content element_cont = contents.next();
		
		@SuppressWarnings("rawtypes")
		List list = element.getChildren();
		String ObjName = element.getName();
		System.out.println("NAME: "+element.getName());
	    System.out.println("children: "+list);
	     
	    IOID thisOID = OID_Stack.pop();
	    
         if ( !list.isEmpty() ) {
           
        	
          List<IOID> ChildrenOIDs = new ArrayList<IOID>();
          
        	 
          for ( int i = 0; i < list.size(); i++ ) {
        	  
             Element node = (Element) list.get(i);
             IOID newChildOID = generateUniqueOID(); 
             OID_Stack.push(newChildOID);
             ChildrenOIDs.add(newChildOID);
             
             System.out.println(node.toString());
             parseXML(node);
             
          }
          //System.out.println(thisOID.toString());
          ISBAObject obj = new ComplexObject(thisOID, ObjName, ChildrenOIDs);
          SBAObjects.put(thisOID, obj); 
          
         } 
         else {

              System.out.println(element_cont.getValue());
              
             
	                try { 
	                	Integer value = Integer.parseInt(element_cont.getValue()); 
	                    System.out.println("Integer");
	                    
	                    ISBAObject obj = new IntegerObject(thisOID, ObjName, value);
	                    SBAObjects.put(thisOID, obj);
	                    
	                } catch(NumberFormatException e) { 
	                	try {
	                		Double value = Double.parseDouble(element_cont.getValue()); 
		                    System.out.println("Double");
		                    
		                    
		                    ISBAObject obj = new DoubleObject(thisOID, ObjName, value);
		                    SBAObjects.put(thisOID, obj);
		                    
		                    
		                } catch(NumberFormatException e2) { 
		                	if ("true".equalsIgnoreCase(element_cont.getValue())) {
		                		System.out.println("Boolean");
		                		
		                		ISBAObject obj = new BooleanObject(thisOID, ObjName, true);
			                    SBAObjects.put(thisOID, obj);
			                    
		                	}else if ("false".equalsIgnoreCase(element_cont.getValue())) {
		                		System.out.println("Boolean");
		                		
		                		ISBAObject obj = new BooleanObject(thisOID, ObjName, false);
			                    SBAObjects.put(thisOID, obj);
		                		
		                	}else {
		                		System.out.println("String");
		                		
		                		ISBAObject obj = new StringObject(thisOID, ObjName, element_cont.getValue());
			                    SBAObjects.put(thisOID, obj);
		                	}

		                }

              
	                }  
              
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
	public void addJavaCollection(@SuppressWarnings("rawtypes") Collection o, String collectionName) {
		// TODO Auto-generated method stub
		
	}
	
	   public void PrintObjects() {
		   
		   Collection<?> ObjElements=(Collection<?>)SBAObjects.values();
		   
		   for (int i =0; i < ObjElements.size(); i++ ){
			 Object[] listaObj =  ObjElements.toArray();
			
			 Object obj = listaObj[i];
			 
			 if (obj instanceof ISimpleObject){
                 if (obj instanceof IStringObject){
                	 
                	 System.out.print("<"+((ISimpleObject<?>) obj).getOID()+", "+((ISimpleObject<?>) obj).getName()+", '");
        			 System.out.println(((ISimpleObject<?>) obj).getValue()+"'>(StringObject)");
        			 
                 } else if (obj instanceof IIntegerObject){
                	 
                	 System.out.print("<"+((ISimpleObject<?>) obj).getOID()+", "+((ISimpleObject<?>) obj).getName()+", ");
        			 System.out.println(((ISimpleObject<?>) obj).getValue()+">(IntegerObject)");
                 
                 } else if (obj instanceof IDoubleObject){
                	 
                	 System.out.print("<"+((ISimpleObject<?>) obj).getOID()+", "+((ISimpleObject<?>) obj).getName()+", ");
        			 System.out.println(((ISimpleObject<?>) obj).getValue()+">(DoubleObject)");
        			 	 
                 }
			 } else {
				 System.out.print("<"+((ComplexObject) obj).getOID()+", "+((ComplexObject) obj).getName()+", ");
    			 System.out.println(((ComplexObject) obj).getChildOIDs()+">(ComplexObject)");
    			 
             } 
			 
			 
			 
		   }
   }
	

}
