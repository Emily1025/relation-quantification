package patty;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;

public class jena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String inputFileName="D:\\myeclipseworkbench\\dataSet\\iswc-2013-complete.rdf";
	      Model model=ModelFactory.createDefaultModel();
	      InputStream in=FileManager.get().open(inputFileName);
	      if(in==null){
	    	  throw new IllegalArgumentException("File:"+inputFileName+"not found");
	      }
	      model.read(in,"","RDF/XML");
	      StmtIterator iter=model.listStatements();
	      while(iter.hasNext()){
	    	  Statement stmt=iter.nextStatement();
	    	  String predicate=stmt.getPredicate().getLocalName().toString();
	    	  System.out.println(predicate);
	}
	}
}
