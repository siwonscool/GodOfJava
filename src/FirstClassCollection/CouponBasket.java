package FirstClassCollection;

import java.util.*;

public class CouponBasket {
    private static final int COUPON_MAX_SIZE = 10;

    //변수를 final 로 선언
    private final List<Coupon> coupons;

    public CouponBasket(List<Coupon> coupons) {
        validateCouponsSize(coupons);
        validateCouponsDuplicate(coupons);
        //방어적 복사
        this.coupons = new ArrayList<>(coupons);
    }

    public List<Coupon> getCoupons() {
        //UnmodifiableList 로 객체 복사
        return Collections.unmodifiableList(coupons);
    }

    private void validateCouponsSize(List<Coupon> coupons) {
        if (coupons.size()>COUPON_MAX_SIZE){
            throw new IllegalArgumentException("쿠폰은 10개까지만 가질수 있습니다.");
        }
    }

    private void validateCouponsDuplicate(List<Coupon> coupons) {
        Set<Coupon> nonDuplicateCoupon = new HashSet<>();
        if (nonDuplicateCoupon.size() != coupons.size()){
            throw new IllegalArgumentException("중복되는 쿠폰을 가질수 없습니다.");
        }
    }

    public Coupon find(String name){
        return coupons.stream()
                .filter(coupon -> coupon.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 쿠폰이 없습니다."));
    }
}
