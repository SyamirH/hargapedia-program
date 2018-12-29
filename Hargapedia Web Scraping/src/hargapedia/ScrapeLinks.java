package hargapedia;

import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element; 
import org.jsoup.select.Elements;

public class ScrapeLinks
{

	public static void main(String[] args) 
	{
		try 
		{
			//Save original out stream.
			PrintStream originalOut = System.out;
			//Create a new file output stream.
			PrintStream newOut = new PrintStream("./output.txt");
			//Redirect standard out stream to file.
			System.setOut(newOut);
			
			//fetch document over HTTP.
			Document doc = Jsoup.connect("https://www.askhargapedia.com").get();
			
			//get links in the "As Featured On" section.
			Elements featuredLinks = doc.select(".media-logo > a");
			for(Element link: featuredLinks) 
			{
				System.out.println(link.attr("href"));
			}
			//Reset original output stream.
			System.setOut(originalOut);
			//Close the PrintStream.
			newOut.close();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
