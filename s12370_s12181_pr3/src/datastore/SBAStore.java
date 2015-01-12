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

import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IIntegerObject;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import edu.pjwstk.jps.datastore.ISimpleObject;
import edu.pjwstk.jps.datastore.IStringObject;

import org.apache.commons.lang3.math.NumberUtils;

public class SBAStore implements ISBAStore {
	
	private Map<IOID, ISBAObject> SBAObjects;
	Integer nextOID;
	IOID EntryOID;
	String drukuj;
	IComplexObject object;

	
	public SBAStore() {
		SBAObjects = new HashMap<IOID, ISBAObject>();
		nextOID = 0;
		drukuj = new String("");
		EntryOID = generateUniqueOID();
		object = new ComplexObject(EntryOID, "entry", new ArrayList<IOID>());
	}

	@Override
	public ISBAObject retrieve(IOID oid) {
		return SBAObjects.get(oid);
	}

	@Override
	public IOID getEntryOID() {
		return EntryOID;
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
				if(el.getText().toLowerCase().toString() == "true" || el.getText().toLowerCase().toString() == "false" ){
					createSimple( el.getName(),Boolean.valueOf(el.getValue()),parent);
					
				}
				else if( NumberUtils.isNumber(el.getText()) ){
					if( (Double.valueOf(el.getText()) % 1) != 0){
						createSimple( el.getName(),Double.valueOf(el.getText()),parent);
					}
					else
						createSimple( el.getName(),Integer.valueOf(el.getText()),parent);
				}
				else
					createSimple( el.getName(),el.getValue(),parent);
			}
			else
				System.out.println("B³¹d! Pusty element");
		}
		else{
			//complex to do
		}
		
	}
	
    private void addSBAObject(ISBAObject object) {
        SBAObjects.put(object.getOID(), object);
    }
	
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T>void createSimple(String name, T value, IComplexObject parent){
		@SuppressWarnings("rawtypes")
		SBAObject ob = new SimpleObject(generateUniqueOID(),name,value);
		parent.getChildOIDs().add(object.getOID());
		addSBAObject(ob);		
	}

	
	

	@Override
	public void addJavaObject(Object o, String objectName) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void addJavaCollection(@SuppressWarnings("rawtypes") Collection o, String collectionName) {
		// TODO Auto-generated method stub
		
	}	

}
