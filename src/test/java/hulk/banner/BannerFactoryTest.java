package hulk.banner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.junit.Test;
import hulk.banner.android.AndroidImage;
import hulk.banner.android.SomeAndroidComponent;
import hulk.banner.banner_content.SimpleBannerContent;
import hulk.banner.banner_content.SomeAndroidBannerContent;

public class BannerFactoryTest {

  @Test
  public void testNormalBanner() throws Exception {
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
    Thread.sleep(25_000);
  }
  
  @Test
  public void testQABanner() throws Exception {
    BannerFactory bannerFactory = new BannerFactory();
    LocalDateTime now = LocalDateTime.now();
    
    bannerFactory.qaModeBanner(
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(8, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SimpleBannerContent());
    
    bannerFactory.qaModeBanner(
        Date.from(now.plus(2, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(12, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SimpleBannerContent());
    Thread.sleep(15_000);
  }
  
  @Test
  public void testNormalAndroidBanner() throws Exception {
    BannerFactory bannerFactory = new BannerFactory();
    LocalDateTime now = LocalDateTime.now();
    AndroidImage emptyImage = new AndroidImage("default image");
    AndroidImage imageA = new AndroidImage("Image A");
    AndroidImage imageB = new AndroidImage("Image B");
    
    bannerFactory.normalModeBanner(
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(10, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SomeAndroidBannerContent(new SomeAndroidComponent(), imageA, emptyImage));
    
    bannerFactory.normalModeBanner(
        Date.from(now.plus(12, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(20, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()),
        new SomeAndroidBannerContent(new SomeAndroidComponent(), imageB, emptyImage));
    
    Thread.sleep(25_000);
  }
  
  @Test
  public void testQAAndroidBanner() throws Exception {
    BannerFactory bannerFactory = new BannerFactory();
    LocalDateTime now = LocalDateTime.now();
    AndroidImage emptyImage = new AndroidImage("default image");
    AndroidImage imageA = new AndroidImage("Image A");
    AndroidImage imageB = new AndroidImage("Image B");
    
    bannerFactory.qaModeBanner(
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(8, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        new SomeAndroidBannerContent(new SomeAndroidComponent(), imageA, emptyImage));
    
    bannerFactory.qaModeBanner(
        Date.from(now.plus(2, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()), 
        Date.from(now.plus(12, ChronoUnit.SECONDS).atZone(ZoneId.systemDefault()).toInstant()),
        new SomeAndroidBannerContent(new SomeAndroidComponent(), imageB, emptyImage));
    
    Thread.sleep(25_000);
  }
}
