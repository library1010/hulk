package hulk.banner;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {

  public static void main(String[] args) throws ParseException {
    BannerFactory bannerFactory = new BannerFactory();
    LocalDateTime now = LocalDateTime.now();
    bannerFactory.normalModeBanner(
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(10, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SimpleBannerContent());
    
    bannerFactory.normalModeBanner(
        Date.from(now.plus(12, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(20, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SimpleBannerContent());
    
    bannerFactory.qaModeBanner(
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(8, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SimpleBannerContent());
    
    bannerFactory.qaModeBanner(
        Date.from(now.plus(2, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(12, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SimpleBannerContent());
  }
}
