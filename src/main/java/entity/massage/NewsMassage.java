package entity.massage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *	ArticleCount	必须		图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
	Articles		必须		图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
	Title			必须		图文消息标题
	Description		必须		图文消息描述
	PicUrl			必须		图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	Url				必须		点击图文消息跳转链接
 * @author Administrator
 *
 */

@XStreamAlias("xml")
@Component
public class NewsMassage extends BaseMassage {
	
	@XStreamAlias("ArticleCount")
	private String articleCount = "1" ;
	@XStreamAlias("Articles")
	private List<Article> articles ;
	
	public NewsMassage() {
		super();
		this.setMsgType("news");
		if(articles == null)
			articles = new ArrayList<Article>();
		Article article = new Article();
		articles.add(article);
	}
	
	public NewsMassage(Map<String, String> map) {
		super(map);
		this.setMsgType("news");
		if(articles == null)
			articles = new ArrayList<Article>();
		Article article = new Article();
		articles.add(article);
	}
	
	public String getArticleCount() {
		return articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	public void updateLastArticle(String title, String description, String picUrl, String url) {
		Article article = articles.remove(Integer.parseInt(articleCount) - 1);
		articleCount = articles.size() + "";
		article.setDescription(description);
		article.setTitle(title);
		article.setPicUrl(picUrl);
		article.setUrl(url);
		articles.add(article);
		articleCount = articles.size() + "";
		return ;
	}

	public void addArticle() {
		articles.add(new Article());
		articleCount = articles.size() + "";
		return ;
	}
	
	public void deleteLastArticle() {
		if(1 == articles.size())
			return ;
		articles.remove(Integer.parseInt(articleCount) - 1);
		articleCount = articles.size() + "";
		return ;
	}
	
}

@XStreamAlias("item")
class Article{
	
	@XStreamAlias("Title")
	private String title ;
	@XStreamAlias("Description")
	private String description ;
	@XStreamAlias("PicUrl")
	private String picUrl ;
	@XStreamAlias("Url")
	private String url ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
