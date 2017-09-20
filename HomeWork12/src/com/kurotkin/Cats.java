package com.kurotkin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Created by Vitaly Kurotkin on 20.09.2017.
 */
public class Cats {
    private static final String[] imageURLs = {
            "http://www.zoopicture.ru/assets/2014/09/12833908543_bbc6bf0e6f_z-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/08/IMG_60491-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/07/ashera_041-120x120.jpg",
            "http://www.zoopicture.ru/assets/2014/09/68e7fd1b1539-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/08/IMG_29471-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/10/IMG_43141-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/bombay-cat-photo1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/IMG_82381-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_31221-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_78271-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_882411-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/09/IMG_74321-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_04291-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/06/kip_051-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_1999-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/09/IMG_65841-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/IMG_4436_11-120x120.jpg",
            "http://www.zoopicture.ru/assets/2014/02/537612_431196850248596_1629331499_n-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/IMG_60441-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/07/mainecoon_101-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/06/IMG_9606_1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_95351-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/08/IMG_6455_1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2013/02/3417712206_813d009d70_z-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/07/mirf_0190-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_69021-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/09/IMG_52101-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/4563734574811-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/2983583469_4787457fb81-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_9339_1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/09/4363573478381-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/09/675123522-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_72801-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/12/5930448120_44767c5ab2-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_13931-120x120.jpg",
            "http://www.zoopicture.ru/assets/2012/01/5011732523_2cbe0d25fb-120x120.jpg",
            "http://www.zoopicture.ru/assets/2014/04/6067041252_95946e628d_z-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/12/363355914_1e09e07807-120x120.jpg",
            "http://www.zoopicture.ru/assets/2012/01/4527412277_06e3a08bc9-120x120.jpg",
            "http://www.zoopicture.ru/assets/2012/09/36376064465737-120x120.jpg",
            "http://www.zoopicture.ru/assets/2012/09/IMG_9463-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_65931-120x120.jpg"};

    private static final Random random = new Random();

    public static URL getRandomUrl(){
        int n = random.nextInt(imageURLs.length);
        URL url = null;
        try {
            url = new URL(imageURLs[n]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
