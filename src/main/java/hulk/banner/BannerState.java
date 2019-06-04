package hulk.banner;

public enum BannerState {

  AWAITING {
    @Override
    BannerState nextState() {
      return ACTIVE;
    }
  },
  ACTIVE {
    @Override
    BannerState nextState() {
      return EXPIRED;
    }
  },
  EXPIRED {
    @Override
    BannerState nextState() {
      return null;
    }
  },
  ;
  
  abstract BannerState nextState();
}
