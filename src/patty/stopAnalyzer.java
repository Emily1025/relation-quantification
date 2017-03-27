package patty;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

public class stopAnalyzer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       //String content="Emily -3 eating eats WorkAt isSuperEventOf mbox_sha1sum holdsRole a is";
	   String content="isSuperEventOf eating";
       StringBuffer sb=new StringBuffer();
       for (String w : content.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	        sb.append(w).append(" ");
	    }
       String content1=sb.toString();
       //System.out.println(content1);
       //System.out.println("11111111111111111");
       displayTokens(new StopAnalyzer(),content1);
	}
	static void displayTokens(Analyzer anlyzer,String text) throws Exception{
		TokenStream stream=anlyzer.tokenStream("content", new StringReader(text));
		//词汇单元对应的文本
		CharTermAttribute cta=stream.addAttribute(CharTermAttribute.class);
		//位置增量，默认值为1
//		PositionIncrementAttribute pia=stream.addAttribute(PositionIncrementAttribute.class);
//		//起始符和终止符的偏移量
//		OffsetAttribute ofa=stream.addAttribute(OffsetAttribute.class);
//		//词汇单元类型
//		TypeAttribute tya=stream.addAttribute(TypeAttribute.class);
	try{
			//reset this stream to the beginning
			stream.reset();
			while(stream.incrementToken()){
			//	String[] result=cta.toString().split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])");
				//System.out.println(cta.toString().split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])"));
				System.out.println(cta);
			}
			stream.end();
		}finally{
			stream.close();
		}
		
	}

}
