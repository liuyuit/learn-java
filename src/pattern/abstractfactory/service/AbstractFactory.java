package pattern.abstractfactory.service;

public interface AbstractFactory {

	HtmlDocument createHtml(String md);

	WordDocument createWord(String md);

}
