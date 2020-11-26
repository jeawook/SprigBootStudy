package hello.core.discount;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	void vip_o() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		//when
		int discount = discountPolicy.discount(member, 20000);
		//then
		assertThat(discount).isEqualTo(2000);
	}
	
	@Test
	void vip_x() {
		//given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		assertThat(discount).isEqualTo(1000);
	}

}
