package hulk.banner.banner_content;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleBannerContent implements BannerContent {
  private static final AtomicInteger counter = new AtomicInteger(0);
  private int id;
  
  public SimpleBannerContent() {
    id = counter.getAndIncrement();
  }
  
  @Override
  public void show() {
    System.out.println("Show banner " + id);
  }

  @Override
  public void expire() {
    System.out.println("Expired banner " + id);
  }

}
