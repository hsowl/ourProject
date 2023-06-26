package com.example.ourproject.main;

import com.example.ourproject.VO.ProductVO;
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
                Document doc = Jsoup.connect("https://front.wemakeprice.com/main").get();
                Elements poster = doc.select("div.container_inner div.contents_wrap");
                System.out.println(doc);
//                String imageUrl = null;
//
//                for (Element imgElement : poster) {
//                    //image url 가져오기
//                    imageUrl = imgElement.attr("src");
//                    imageUrl = imageUrl.replace("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==","");
//
//                    //title 가져오기
//                    String title = imgElement.attr("alt");
//                    String[] titleParts = title.split(" - ");
//                    title = titleParts[0];
//
//                    ProductVO vo = new ProductVO();
//
//                    vo.setNo(k++);
//                    vo.setImage(imageUrl);
//                    vo.setTitle(title);
//                    vo.setPrice((int)(Math.random()*7000)+7000);
//
//                    dao.productInsert(vo);
//                }
//
//


            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
