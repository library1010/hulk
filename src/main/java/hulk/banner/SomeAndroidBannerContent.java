package hulk.banner;

public class SomeAndroidBannerContent implements BannerContent {

  private SomeAndroidComponent component;
  private AndroidImage image;
  private AndroidImage emptyImage;

  public SomeAndroidBannerContent(SomeAndroidComponent component, AndroidImage image, AndroidImage emptyImage) {
    this.component = component;
    this.image = image;
    this.emptyImage = emptyImage;
  }

  @Override
  public void show() {
    component.setImage(image);
    component.show();
  }

  @Override
  public void expire() {
    component.setImage(emptyImage);
    component.show();
  }

}
