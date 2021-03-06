package com.revature;

import java.util.List;

import com.revature.dummymodels.Test;
import com.revature.util.ColumnField;
import com.revature.util.Configuration;
import com.revature.util.MetaModel;

public class Driver {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		// In our configuration object we want to add annotated class, without ever having to instantiate them
		
		cfg.addAnnotatedClass(Test.class);
		
		// this is just to prove that we successfully transformed it to a metamodel, readable by our framework
		// let's iterate over all meta models that exist in the config object
		for (MetaModel<?> metamodel : cfg.getMetaModels()) {
			
			System.out.printf("Printing metamodel for class: %s\n", metamodel.getClassName()); // %s is a place holder
			
			List<ColumnField> columnFields = metamodel.getColumns();
			
			for (ColumnField cf : columnFields) {
					
				System.out.printf("Found a column field named %s of type %s, which maps to the DB column %s\n", cf.getName(), cf.getType(), cf.getColumnName());
				
			}
		}
	}

}
