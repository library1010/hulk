package hulk.banner.android;

public class SomeAndroidComponent {
  
  private AndroidImage image;

  public void setImage(AndroidImage image) {
    this.image = image;
  }
  
  public void show() {
    System.out.println("Showing image " + image.getName());
  }
}
