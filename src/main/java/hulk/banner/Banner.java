package hulk.banner;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import hulk.banner.banner_content.BannerContent;

public class Banner {

  private BannerContent content;
  private Timer timer;
  
  public Banner(Date startTime, Date endTime, BannerContent content) {
    if(startTime.after(endTime)) {
      throw new IllegalArgumentException("Start time should be after end time: " + startTime + " - " + endTime);
    }
    
    this.content = content;
    this.timer = new Timer(false);
    timer.schedule(new BannerTask(() -> this.show()), startTime);
    timer.schedule(new BannerTask(() -> this.expired()), endTime);
  }
  
  protected void show() {
    this.content.show();
  }
  
  protected void expired() {
    this.content.expire();
    this.timer.purge();
  }
  
  private class BannerTask extends TimerTask {
    
    private Runnable task;

    public BannerTask(Runnable task) {
      this.task = task;
    }

    @Override
    public void run() {
      task.run();
    }
  }

}
