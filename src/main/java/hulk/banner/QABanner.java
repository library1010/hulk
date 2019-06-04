package hulk.banner;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class QABanner extends Banner {

  private ReentrantLock lock;

  public QABanner(Date startTime, Date endTime, BannerContent content, ReentrantLock lock) {
    super(new Date(System.currentTimeMillis() + 1000), endTime, content);
    this.lock = lock;
  }

  @Override
  protected void show() {
    if(this.lock == null) {
      throw new NullPointerException("null lock");
    }
    this.lock.lock();
    super.show();
  }
  
  @Override
  protected void expired() {
    if(this.lock == null) {
      throw new NullPointerException("null lock");
    }
    super.expired();
    this.lock.unlock();
  }
}
