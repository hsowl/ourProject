package com.example.ourproject.main;

import com.example.ourproject.dao.CrawlingDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CrawlingMain {
    public static void main(String[] args) {
        CrawlingMain cm = new CrawlingMain();
        cm.crawling();
    }

    private void crawling() {
        CrawlingDAO dao = new CrawlingDAO();

        try {
            int k = 1;
            for(int i = 1; i<=1; i++){
                //image url 저장하기
                Document doc = Jsoup.connect("https://www.gmarket.co.kr/n/smilefresh/category?categoryCode=100001003&p="+i).get();
                Elements poster = doc.select("div.box__itemcard div.box__items-list ul.list__itemcard-slide li.list-item div.box__itemcard-container div.box__itemcard-body div.box__itemcard-inner a.link__itemcard span.box__itemcard-img img.image__itemcard");
                System.out.println(poster);
                String imageUrl = null;

                for (Element imgElement : poster) {
                    imageUrl = imgElement.attr("src");
                    imageUrl = imageUrl.replace("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==","");
                    System.out.println(imageUrl);

                    String title = imgElement.attr("alt");
                    String[] titleParts = title.split(" - ");
                    title = titleParts[0];
//                    System.out.println(title);
                }



            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
