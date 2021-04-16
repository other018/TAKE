package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@Named(value = "newsBean")
@RequestScoped
public class NewsBean {

    @Inject
    private NewsItemFacadeLocal facade;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:app/jms/NewsQueue")
    private javax.jms.Queue queue;

    private String headingText;
    private String bodyText;

    public NewsBean() {
    }

    public String submitNews() {
        sendNewsItem(headingText, bodyText);
        return null;
    }

    void sendNewsItem(String heading, String body) {
        try {
//            ObjectMessage message = context.createObjectMessage();
            TextMessage message = context.createTextMessage();
            NewsItem e = new NewsItem();
            e.setHeading(heading);
            e.setBody(body);
//            message.setObject(e);
            message.setText(e.getText());

            context.createProducer().send(queue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    public List<NewsItem> getNewsList() {
        return facade.getAllNewsItem();
    }

    public String getHeadingText() {
        return headingText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
}
