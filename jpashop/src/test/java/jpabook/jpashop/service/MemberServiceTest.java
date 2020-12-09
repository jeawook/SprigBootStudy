package jpabook.jpashop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	@Autowired EntityManager em;
	
	@Test
	@Rollback(false)
	public void 회원가입() throws Exception {
		//given
		Member member = new Member();
		member.setName("kim");
		Address address = new Address("군포", "산본길", "111");
		member.setAddress(address);
		
		//when
		Long savedId = memberService.join(member);
		
		//then
		assertEquals(member, memberRepository.findOne(savedId));
	}
	
	
	  @Test(expected = IllegalStateException.class)
	  public void 중복_회원_제외() throws Exception { 
		  //given
		  Member member1 = new Member();
		  member1.setName("kim");
		  Address address1 = new Address("군포", "산본길", "111");
		  member1.setAddress(address1);
		  
		  Member member2 = new Member();
		  member2.setName("kim");
		  Address address2 = new Address("군포", "산본길", "111");
		  member2.setAddress(address2);
	  
		  //when
		  memberService.join(member1);
		  memberService.join(member2);
			
		  //then
		  fail("예외가 발생해야 한다.");
		  
	  }
	 
}
