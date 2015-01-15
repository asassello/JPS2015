package datastore;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.math.NumberUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IIntegerObject;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import edu.pjwstk.jps.datastore.ISimpleObject;
import edu.pjwstk.jps.datastore.IStringObject;

public class SBAStore implements ISBAStore {
	
	private Map<IOID, ISBAObject> SBAObjects;
	Integer nextOID = 0;
	IOID entryOID;
	String drukuj;
	IComplexObject object;
	
	public SBAStore() {
		SBAObjects = new HashMap<IOID, ISBAObject>();
		drukuj = new String("");
		entryOID = generateUniqueOID();
		//System.out.println(entryOID);
		
		object = new ComplexObject(entryOID, "entry", new ArrayList<IOID>());
		addSBAObject(object); //kluczowe aby dodaæ obiekt root'owy do HashMapy inaczej tracimy do niego referncjê po zakoñczeniu dzia³ania konstruktora!
		//System.out.println(object);
		
	}

	public ISBAObject retrieve(IOID oid) {
		return SBAObjects.get(oid);
	}
	
	@Override
	public IOID getEntryOID() {
		return entryOID;
	}
	
    public String drukuj() {
        return drukuj;
    }
    
	@Override
	public IOID generateUniqueOID() {
        OID theOID = new OID(nextOID);
        nextOID++;
        return theOID;
	}

	@Override
	public void loadXML(String filePath) {

		try {
			SAXBuilder builder = new SAXBuilder();
			Document jdomDoc = builder.build(new File(filePath));
			Element root_element = jdomDoc.getRootElement();
			
			
			IComplexObject parent = (IComplexObject) retrieve(getEntryOID());
			//System.out.println(parent);
			parseXML(root_element,parent);
	
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void parseXML (Element element, IComplexObject parent){
		
		for(Element dzieci: element.getChildren()){
			parseChildren(dzieci, parent);
		}
	}

	public void parseChildren(Element el, IComplexObject parent){
		
		if(el.getChildren().isEmpty() == true){
			
			if(!el.getText().isEmpty()){
				if(el.getText().toLowerCase().toString().equals("true") || el.getText().toLowerCase().toString().equals("false") ){
					createBool( el.getName(),Boolean.valueOf(el.getValue()),parent);
//					//System.out.println("TEST");
				}
				else if( NumberUtils.isNumber(el.getText()) ){
					if( (Double.valueOf(el.getText()) % 1) != 0){
						createDouble( el.getName(),Double.valueOf(el.getText()),parent);
					}
					else
						createInt( el.getName(),Integer.valueOf(el.getText()),parent);
				}
				else
					createString( el.getName(),el.getValue(),parent);
			}
			else
				System.out.println("B³¹d! Pusty element");
		}
		else{
			createComplex(el.getName(),new ArrayList<IOID>(), el.getChildren(),parent);
		}
		
	}
	
	public void createComplex(String name, ArrayList<IOID> value, List<Element> list, IComplexObject parent){
		SBAObject ob = new ComplexObject(generateUniqueOID(),name, value);
		parent.getChildOIDs().add(ob.getOID());
		addSBAObject(ob);
		for(Element dzieci: list){
			parseChildren(dzieci,(ComplexObject)ob);
		}
	}
	
    private void addSBAObject(ISBAObject object) {
        SBAObjects.put(object.getOID(), object);
    }
	
	public SBAObject createBool(String name, Boolean value, IComplexObject parent){		
		SBAObject ob = new BooleanObject(generateUniqueOID(),name,value);
		parent.getChildOIDs().add(ob.getOID());
		addSBAObject(ob);
		return ob;
	}
	
	public SBAObject createInt(String name, Integer value, IComplexObject parent){		
		SBAObject ob = new IntegerObject(generateUniqueOID(),name,value);
		parent.getChildOIDs().add(ob.getOID());
		addSBAObject(ob);
		return ob;
	}
	
	public SBAObject createDouble(String name, Double value, IComplexObject parent){		
		SBAObject ob = new DoubleObject(generateUniqueOID(),name,value);
		parent.getChildOIDs().add(ob.getOID());
		addSBAObject(ob);
		return ob;
	}
	
	public SBAObject createString(String name, String value, IComplexObject parent){
		
			SBAObject ob = new StringObject(generateUniqueOID(),name,value);
			parent.getChildOIDs().add(ob.getOID());
			addSBAObject(ob);
			return ob;
		}	

	public void createComplexFromFiled(String name, ArrayList<IOID> value, Field[] list, IComplexObject parent) throws IllegalArgumentException, IllegalAccessException{
		SBAObject ob = new ComplexObject(generateUniqueOID(),name, value);
		parent.getChildOIDs().add(ob.getOID());
		addSBAObject(ob);
		for(Field dzieci: list){
			if(dzieci.get(dzieci) instanceof Boolean) createBool(dzieci.getName(), dzieci.getBoolean(dzieci) , parent);
			else if(dzieci.get(dzieci) instanceof Integer) createInt(dzieci.getName(), dzieci.getInt(dzieci) , parent);
			else if(dzieci.get(dzieci) instanceof Double) createDouble(dzieci.getName(), dzieci.getDouble(dzieci) , parent);
			else if(dzieci.get(dzieci) instanceof String) createString(dzieci.getName(), dzieci.toString() , parent);
			else System.out.println("Nieobs³ugiwany argument klasy");
		}
	}	
	
	@Override
	public void addJavaObject(Object o, String objectName) {
		// TODO Auto-generated method stub
		if(o instanceof Boolean) createBool(objectName, ((Boolean) o).booleanValue(), (IComplexObject)retrieve(getEntryOID()) );
		else if(o instanceof Integer) createInt(objectName, ((Integer) o).intValue(), (IComplexObject)retrieve(getEntryOID()) );
		else if(o instanceof Double) createDouble(objectName, ((Double) o).doubleValue(), (IComplexObject)retrieve(getEntryOID()) );
		else if(o instanceof String) createString(objectName, o.toString(), (IComplexObject)retrieve(getEntryOID()) );
		else
			try {
				createComplexFromFiled(objectName, new ArrayList<IOID>(), o.getClass().getFields(), (IComplexObject)retrieve(getEntryOID()));
			} catch (IllegalArgumentException | IllegalAccessException
					| SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	@Override
	public void addJavaCollection(@SuppressWarnings("rawtypes") Collection o, String collectionName) {
		// TODO Auto-generated method stub
		for(Object ob: o){
			addJavaObject(ob,collectionName);
		}
	}
	
	public void PrintObject(ISBAObject o){
		
		if(o instanceof ISimpleObject){
			if(o instanceof IStringObject){
				System.out.println( "<" + o.getOID().toString() + ", " + o.getName() + ", \"" +  String.valueOf( ((ISimpleObject) o).getValue() ) + "\">" );
			}
			else if(o instanceof IBooleanObject || o instanceof IIntegerObject || o instanceof IDoubleObject){
				System.out.println( "<" + o.getOID().toString() + ", " + o.getName() + ", " +  String.valueOf( ((ISimpleObject) o).getValue() ) + ">" );
			}
		}
		else if(o instanceof IComplexObject){
			String tmp ="";
			for(IOID oid: ((IComplexObject) o).getChildOIDs()){
				tmp += ((OID) oid).GetValue() + ",";				
			}
			if(tmp.endsWith(",")){
				tmp = tmp.substring(0, tmp.length()-1);
			}
			System.out.println( "<" + o.getOID().toString() + ", " + o.getName() + ", {" +  tmp + "}>" );
			for(IOID oid: ((IComplexObject) o).getChildOIDs()){
				PrintObject(retrieve(oid));
			}
		}
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {

		SortedSet<Map.Entry<OID, SBAObject>> sortedset = new TreeSet<Map.Entry<OID, SBAObject>>(
	            new Comparator<Map.Entry<OID, SBAObject>>() {
	                @Override
	                public int compare(Map.Entry<OID, SBAObject> e1,
	                        Map.Entry<OID, SBAObject> e2) {
	                    return e1.getKey().compareTo(e2.getKey());
	                }
	            });
		sortedset.addAll((Collection<? extends Entry<OID, SBAObject>>) SBAObjects.entrySet());
		
//		for(Map.Entry<IOID, ISBAObject> entry : SBAObjects.entrySet()){
//			mapToPrint.put((IOID)entry.getKey(),(ISBAObject)entry.getValue());
//		}
		//return ""+SBAObjects;
		return ""+sortedset;
	}

}
