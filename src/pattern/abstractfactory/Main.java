package pattern.abstractfactory;

import java.io.IOException;
import java.nio.file.Paths;

import pattern.abstractfactory.fastfactory.FastFactory;
import pattern.abstractfactory.goodfactory.GoodFactory;
import pattern.abstractfactory.service.AbstractFactory;
import pattern.abstractfactory.service.HtmlDocument;
import pattern.abstractfactory.service.WordDocument;

/**
 *  java src/pattern/abstract_factory/Main.java
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws IOException {
		AbstractFactory fastFactory = new FastFactory();
		HtmlDocument fastHtml = fastFactory.createHtml("#Hello\nHello, world!");
		System.out.println(fastHtml.toHtml());
		fastHtml.save(Paths.get(".", "fast.html"));
		WordDocument fastWord = fastFactory.createWord("#Hello\nHello, world!");
		fastWord.save(Paths.get(".", "fast.doc"));

		AbstractFactory goodFactory = new GoodFactory();
		HtmlDocument goodHtml = goodFactory.createHtml("#Hello\nHello, world!");
		System.out.println(goodHtml.toHtml());
		goodHtml.save(Paths.get(".", "good.html"));
		WordDocument goodWord = goodFactory.createWord("#Hello\nHello, world!");
		goodWord.save(Paths.get(".", "good.doc"));
	}
}
