package hulk.banner;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class BannerFactory {
  private ReentrantLock lock;

  public BannerFactory() {
    lock = new ReentrantLock(true);
  }
  
  public Banner of(Date startTime, Date endTime, BannerContent bannerContent, String ip) {
    return isQA(ip) ? qaModeBanner(startTime, endTime, bannerContent) : normalModeBanner(startTime, endTime, bannerContent); 
  }
  
  private boolean isQA(String ip) {
    return Arrays.asList("localhost").contains(ip);
  }

  protected Banner normalModeBanner(Date startTime, Date endTime, BannerContent bannerContent) {
    return new Banner(startTime, endTime, bannerContent);
  }

  protected Banner qaModeBanner(Date startTime, Date endTime, BannerContent bannerContent) {
    if(this.lock == null) {
      throw new NullPointerException("null lock");
    }
    return new QABanner(startTime, endTime, bannerContent, this.lock);
  }

  
}
