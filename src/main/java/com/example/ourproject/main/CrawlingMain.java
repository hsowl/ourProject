//package com.example.ourproject.main;
//
//import com.example.ourproject.dao.CrawlingDAO;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//
//public class CrawlingMain {
//    public static void main(String[] args) {
//        CrawlingMain cm = new CrawlingMain();
//        cm.crawling();
//    }
//
//    private void crawling() {
//        CrawlingDAO dao = new CrawlingDAO();
//
//        try {
//            int k = 1;
//            for(int i = 1; i<=1; i++){
//                Document doc = Jsoup.connect("https://www.gmarket.co.kr/n/smilefresh/category?categoryCode=100001003&p="+i).get();
//                Elements poster = doc.select("div.box__itemcard div.box__items-list ul.list__itemcard-slide li.list-item div.box__itemcard-container div.box__itemcard-body div.box__itemcard-inner a.link__itemcard img.image__itemcard");
//                System.out.println(poster);
//                String image = null;
//
//                for (Element imgElement : poster) {
//                    String imageUrl = imgElement.attr("src");
//                    System.out.println(imageUrl);
//                }
//
//
//
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//}
