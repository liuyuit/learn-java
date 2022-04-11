package pattern.abstractfactory.goodfactory;

import pattern.abstractfactory.service.AbstractFactory;
import pattern.abstractfactory.service.HtmlDocument;
import pattern.abstractfactory.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
