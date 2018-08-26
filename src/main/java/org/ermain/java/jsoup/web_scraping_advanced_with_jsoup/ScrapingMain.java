/**
 * 
 */
package org.ermain.java.jsoup.web_scraping_advanced_with_jsoup;

/**
 * @author Ermain
 *
 */

import static java.lang.System.*;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		out.println("Advanced Web Scraping.... ");
		
		File inputFile = new File("C:\\Users\\Ermain\\Documents\\JavaScript_Code\\DOM\\index.html");
		
		Document jsoupDoc = Jsoup.parse(inputFile, "UTF-8");
		
		// Get an element surrounding other tags
		Element doc = jsoupDoc.getElementById("head");
		
		// Parse the elements within the head tags
		Elements docLinks = doc.getElementsByTag("h1");
		
		for(Element link: docLinks) {
			String linkHref = link.attr("href");	// Select the href tags
			out.println(linkHref);
			String linktext = link.text();			// Select the text in the href tags
			out.println(linktext);
		}
	}
	
	public static void parseHTMLTags(String path, String firstTag, String closingTag) throws IOException {
		
		try {
			
			File inputFile = new File(path);
			
			// Parse the file using Jsoup
			Document inputParse = Jsoup.parse(inputFile, "UTF-8");
			
			// Parse the first tag in the HTML file
			Element inputFileTag = inputParse.getElementById(firstTag);
			
			// Parse the enclosed tags in the firsTag
			Elements inputFileTags = inputFileTag.getElementsByAttribute(closingTag);
			
			for(Element link : inputFileTags) {
				String tag = link.attr("");
				out.println("Tags " + tag);
				String text = link.text();
				out.println("Title: " + text);
			}
		}catch(Exception e) {
			out.println("An unknown exception occured");
			e.printStackTrace();
		}
		
	}
	
	public static void parseURLTags(String URL, String enclosingTags, String minorTags) throws IOException {
		
		try {
			
			Document inputURL = Jsoup.connect(URL)
					                 .timeout(30000)
					                 .get();
			
			Element enclosingTag = inputURL.getElementById(enclosingTags);
			
			Elements smallTags = enclosingTag.getElementsByTag(minorTags);
			
			for(Element smallTag: smallTags) {
				
				String attribute = smallTag.attr("");
				out.println(attribute);
				
				String tagText = smallTag.text();
				out.println("Text: " + tagText);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
