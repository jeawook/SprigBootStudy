package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
	
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
		
		Long memberid = 1L;
		Member member = new Member(memberid, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberid, "itemA", 10000);
		
		System.out.println("order = "+order);
		System.out.println("calculatePrice = "+order.calculatePrice());
	}

}