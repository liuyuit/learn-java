package pattern.abstractfactory.fastfactory;

import pattern.abstractfactory.service.AbstractFactory;
import pattern.abstractfactory.service.HtmlDocument;
import pattern.abstractfactory.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
