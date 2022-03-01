package FirstClassCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CouponService {
    private static final int COUPON_MAX_SIZE = 10;


    public void createCouponList(){
        CouponBasket couponBasket = new CouponBasket(createNonDuplicateCoupons());
    }

    private List<Coupon> createNonDuplicateCoupons() {
        return new ArrayList<Coupon>();
    }
}
